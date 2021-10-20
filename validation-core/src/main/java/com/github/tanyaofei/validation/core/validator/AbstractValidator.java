package com.github.tanyaofei.validation.core.validator;


import java.lang.annotation.Annotation;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.Collection;
import javax.annotation.Resource;

import com.github.tanyaofei.validation.core.ConstraintValidatorMapper;
import com.github.tanyaofei.validation.core.annotation.Valid;
import com.github.tanyaofei.validation.core.support.ConstraintUtils;
import com.github.tanyaofei.validation.core.support.ParameterUtils;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.objenesis.instantiator.util.UnsafeUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sun.misc.Unsafe;


/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@Log4j2
public abstract class AbstractValidator implements Validator, ComplexValidate {

  @Resource
  public ConstraintValidatorMapper constraintValidatorMapper;

  @Resource
  public ApplicationContext applicationContext;

  private static final Unsafe UNSAFE = UnsafeUtils.getUnsafe();
  private static final String ERROR_CODE = "invalid-value";
  private static final MethodType CONSTRAINT_MESSAGE_METHOD_TYPE = MethodType
      .methodType(String.class);

  @Override
  public void validate(@Nullable Object target, Errors errors) {
    if (target == null) {
      return;
    }

    if (constraintValidatorMapper == null) {
      throw new NullPointerException("constrainValidatorMapper is null, 校验器容器注入失败");
    }

    for (var field : target.getClass().getDeclaredFields()) {
      try {
        validate(field, target, errors);
      } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
        UNSAFE.throwException(e);
        return;
      }
      if (errors.hasErrors()) {
        return;
      }

      // 递归校验
      Valid valid = field.getAnnotation(Valid.class);
      if (valid != null) {
        if (Collection.class.isAssignableFrom(field.getType())) {
          Collection<?> items;
          try {
            field.setAccessible(true);
            items = (Collection<?>) field.get(target);
          } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
          }
          if (items == null) {
            return;
          }
          for (var item : items) {
            this.getValidator(valid).validate(item, errors);
            if (errors.hasErrors()) {
              return;
            }
          }
        } else {
          try {
            this.getValidator(valid)
                .validate(field.get(target), errors);
          } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
          }
          if (errors.hasErrors()) {
            return;
          }
        }
      }
    }

    // 自定义校验
    if (supports(target.getClass())) {
      complexValidate(target, errors);
    }
  }

  /**
   * 校验字段
   *
   * @param field  字段
   * @param object 这个字段所属的对象
   * @param errors 异常信息
   */
  @SneakyThrows
  public void validate(Field field, Object object, Errors errors)
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    for (var annotation : field.getAnnotations()) {
      if (!ConstraintUtils.isConstraint(annotation)) {
        continue;
      }
      var validator = constraintValidatorMapper.getValidator(
          annotation.annotationType(), field.getType()
      );

      field.setAccessible(true);
      Object value = field.get(object);

      if (validator.isPresent()) {
        if (!(boolean) this.getIsValidMethod(validator.get()).invokeExact(annotation, value)) {
          errors.reject(ERROR_CODE, getErrorMessage(field.getName(), annotation));
          return;
        }
      }

      // 如果要继续校验这个字段对象里面的字段
      Valid valid = field.getAnnotation(Valid.class);
      if (valid != null) {
        this.getValidator(valid).validate(value, errors);
        if (errors.hasErrors()) {
          return;
        }
      }
    }
  }

  /**
   * 校验方法参数
   *
   * @param parameter 参数
   * @param value     参数值
   * @param errors    异常信息
   */
  @SneakyThrows
  public void validate(
      Parameter parameter,
      @Nullable Object value,
      Errors errors
  ) {
    for (var annotation : parameter.getAnnotations()) {
      if (!ConstraintUtils.isConstraint(annotation)) {
        continue;
      }

      var validator = constraintValidatorMapper.getValidator(
          annotation.annotationType(), parameter.getType()
      );

      if (validator.isPresent()) {
        if (!(boolean) this.getIsValidMethod(validator.get()).invokeExact(annotation, value)) {
          errors.reject(ERROR_CODE, getErrorMessage(parameter.getName(), annotation));
          return;
        }
      }
    }

    // 判断是否是基础对象, 如果不是基础对象则继续校验这个对象里面的字段
    if (!ParameterUtils.isBasicClass(parameter.getType())) {
      if (value == null) {
        return;
      }

      Valid valid = parameter.getAnnotation(Valid.class);
      if (valid == null) {
        // should not happen: 因为这个方法校验的入口, 如果没有 @Valid 不应该进入这个方法
        return;
      }
      // 如果是一个列表, 则递归每一个元素进行校验
      if (Collection.class.isAssignableFrom(value.getClass())) {
        var items = (Collection<?>) value;
        for (var item : items) {
          this.getValidator(valid).validate(item, errors);
          if (errors.hasErrors()) {
            return;
          }
        }
      } else {
        // 如果是一个对象, 则对这个对象进行校验
        this.getValidator(valid).validate(value, errors);
      }
    }
  }


  /**
   * 获取约束注解上的错误返回信息
   *
   * @param fieldName  字段名称
   * @param constraint 约束注解
   * @return 约束注解上的错误返回信息
   * @see NotNull#message()
   */
  private String getErrorMessage(String fieldName, Annotation constraint) {

    String message;
    try {
      message = (String) MethodHandles
          .lookup()
          .findVirtual(constraint.getClass(), "message", CONSTRAINT_MESSAGE_METHOD_TYPE)
          .bindTo(constraint)
          .invokeExact();
      if (message.isEmpty()) {
        message = "Field '" + fieldName + "' validate not pass";
      }
    } catch (Throwable throwable) {
      throw new IllegalStateException("Failed to find 'message()' method on " + constraint);
    }
    return message;
  }

  /**
   * 根据 valid 注解获取递归校验里的校验器
   *
   * @param valid 校验注解
   * @return 如果有指定则返回校验器 Bean, 否则返回 this
   */
  private AbstractValidator getValidator(Valid valid) {
    if (applicationContext == null) {
      throw new NullPointerException("applicationContext is null");
    }

    return valid.validateBy() == com.github.tanyaofei.validation.core.validator.CommonValidator.class
        || valid.validateBy() == AbstractValidator.class
        ? this
        : applicationContext.getBean(valid.validateBy());
  }

  /**
   * 获取 isValid 方法
   *
   * @param target 实现 isValid 的对象实例
   * @return 方法句柄
   * @see ConstraintValidator#isValid(Annotation, Object)
   */
  private MethodHandle getIsValidMethod(ConstraintValidator<?, ?> target) {
    try {
      return MethodHandles
          .lookup()
          .findVirtual(
              target.getClass(),
              ConstraintValidator.IS_VALID_METHOD_NAME,
              ConstraintValidator.IS_VALID_METHOD_TYPE)
          .bindTo(target);
    } catch (NoSuchMethodException e) {
      throw new IllegalStateException("Failed to find 'isValid()' method on " + target, e);
    } catch (IllegalAccessException e) {
      throw new IllegalStateException(
          "Failed to Call Method 'isValid()' on " + target + " , make sure it's a public method",
          e);
    }
  }

}
