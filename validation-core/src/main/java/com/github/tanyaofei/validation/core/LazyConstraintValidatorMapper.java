package com.github.tanyaofei.validation.core;

import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;
import lombok.extern.log4j.Log4j2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 约束注解 - 类型 - 校验器容器
 * <pre>
 *   懒加载校验器, 在第一次遇到约束注解时将其相关的所有校验器初始化
 * </pre>
 *
 * @author 谭耀飞
 * @since 2020.11.0
 */
@Log4j2
public class LazyConstraintValidatorMapper implements ConstraintValidatorMapper {

  /**
   * 默认容器容量
   * <pre>aka 32</pre>
   */
  private final static int DEFAULT_CONTAINER_CAPACITY = 2 << 4;

  /**
   * {约束注解类型: {校验值类型: 校验器}} 容器
   * <pre>
   * eg: {
   *        Min.class: {
   *          Short.class: MinValidatorForShort, Long.class: MinValidatorForLong
   *        },
   *        Max.class: {
   *          Short.class: MaxValidatorForShort, Long.class: MaxValidatorForLong
   *        }
   *      }
   * </pre>
   */
  private final Map<Class<? extends Annotation>, Map<Class<?>, ConstraintValidator<?, ?>>> container =
      new HashMap<>(DEFAULT_CONTAINER_CAPACITY, 1.0F);

  @Override
  public Optional<ConstraintValidator<?, ?>> getValidator(
      Class<? extends Annotation> constraintType, Class<?> valueType
  ) {
    return this.container.containsKey(constraintType)
        ? getValidator0(constraintType, valueType)
        : loadAndGetValidator(constraintType, valueType);
  }

  /**
   * 加载这个约束注解所有校验器
   *
   * @param annotationType 约束注解类型
   * @param valueType      要返回的待校验值值类型对应的校验器
   * @return 校验器
   */
  @SuppressWarnings("all")
  private Optional<ConstraintValidator<?, ?>> loadAndGetValidator(
      Class<? extends Annotation> annotationType, Class<?> valueType
  ) {

    // 注解锁
    synchronized (annotationType) {
      // 二次校验: 进入同步块后再次确认此注解未加载
      if (container.containsKey(annotationType)) {
        return this.getValidator0(annotationType, valueType);
      }
      Constraint constraint = annotationType.getAnnotation(Constraint.class);
      if (constraint == null) {
        // 非约束注解
        return Optional.empty();
      }

      // 初始化此注解的校验器
      ConstraintValidator<?, ?> masterRet = null, backupRet = null;
      var validatorTypes = constraint.validateBy();
      var typeValidatorMap = new HashMap<Class<?>, ConstraintValidator<?, ?>>(
          validatorTypes.length,
          1.0F);
      for (var validatorType : validatorTypes) {
        ValidateSupport support;
        if ((support = validatorType.getAnnotation(ValidateSupport.class)) == null) {
          log.error("校验器未标记 @ValidateSupport 注解: " + validatorType);
          continue;
        }

        ConstraintValidator<?, ?> validator;
        try {
          validator = validatorType.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
          log.error("初始化校验器失败: " + validatorType, e);
          continue;
        }

        typeValidatorMap.put(support.value(), validator);
        if (support.value() == valueType) {
          // 如果支持类型等于被校验值的类型, 则确定这是需要返回的校验器
          masterRet = validator;
        } else if (masterRet == null && support.value().isAssignableFrom(valueType)) {
          // 如果还没找到直接支持的类型, 同时这个校验器支持类型是待校验值类型的父类/接口, 也将记录
          backupRet = validator;
        }
      }

      // 一次性将该注解的所有校验器添加到容器中
      container.put(annotationType, typeValidatorMap);
      return Optional.ofNullable(masterRet != null ? masterRet : backupRet);
    }
  }

  /**
   * 获取一个校验器
   *
   * @param constraintType 约束注解类型
   * @param valueType      校验对象类型
   * @return 校验器
   */
  private <A extends Annotation, V> Optional<ConstraintValidator<?, ?>> getValidator0(
      Class<A> constraintType, Class<V> valueType
  ) {

    Map<Class<?>, ConstraintValidator<?, ?>> typeValidatorMap = container.get(constraintType);
    if (typeValidatorMap == null) {
      return Optional.empty();
    }

    Optional<ConstraintValidator<?, ?>> ret;
    if ((ret = this.getBySupportEqual(typeValidatorMap, valueType)).isEmpty()) {
      ret = this.getBySupportAssignableFrom(typeValidatorMap, valueType);
    }

    return ret;
  }

  /**
   * 获取直接类型支持的校验器
   *
   * @param typeValidatorMap 类型 - 校验器字典
   * @param valueType        待校验值类型
   * @return 校验器
   */
  private Optional<ConstraintValidator<?, ?>> getBySupportEqual(
      Map<Class<?>, ConstraintValidator<?, ?>> typeValidatorMap,
      Class<?> valueType
  ) {
    return Optional.ofNullable(typeValidatorMap.get(valueType));
  }

  /**
   * 获取继承/实现支持的校验器
   *
   * @param typeValidatorMap 类型 - 校验器字典
   * @param valueType        带校验值类型
   * @return 校验器
   */
  private Optional<ConstraintValidator<?, ?>> getBySupportAssignableFrom(
      Map<Class<?>, ConstraintValidator<?, ?>> typeValidatorMap,
      Class<?> valueType
  ) {
    for (var validator : typeValidatorMap.values()) {
      var support = validator.getClass().getAnnotation(ValidateSupport.class);

      // 如果被校验的值是校验器的子类, 则返回此校验器
      if (support.value().isAssignableFrom(valueType)) {
        return Optional.of(validator);
      }
    }
    return Optional.empty();
  }

}
