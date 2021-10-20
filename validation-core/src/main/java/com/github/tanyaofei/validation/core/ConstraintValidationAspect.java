package com.github.tanyaofei.validation.core;

import com.github.tanyaofei.validation.core.annotation.Valid;
import com.github.tanyaofei.validation.core.exception.ValidationException;
import com.github.tanyaofei.validation.core.validator.AbstractValidator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author 谭耀飞
 * @since 2021.04.0
 */
@Aspect
public class ConstraintValidationAspect {


  /**
   * 校验器缓存
   */
  private final ConcurrentMap<Class<? extends AbstractValidator>, AbstractValidator> VALIDATOR_CACHES = new ConcurrentHashMap<>();

  /**
   * 不需要进行校验的方法缓存
   *
   * @see #validateOnRestControllerMethods
   */
  private final Set<String> NO_VALID_METHODS = new HashSet<>();

  /**
   * Spring Application Context
   * <p>使用 @Valid(validateBy=x) 指定该方法参数使用自定义校验器进行校验, 需要保证该校验器归属 Spring IOC 管理, 因此需要使用
   * applicationContext 获取自定义校验器实例对象</p>
   */
  private final ApplicationContext applicationContext;

  public ConstraintValidationAspect(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  /**
   * 拦截所有 RestController 方法, 并缓存方法里有没有 @Valid 方法, 如果没有, 则下次不会再循环判断
   */
  @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
  public void pointcutOnRestControllerMethods() {

  }

  @Before("pointcutOnRestControllerMethods()")
  public void validateOnRestControllerMethods(JoinPoint joinPoint) throws Throwable {
    var sign = (MethodSignature) joinPoint.getSignature();
    if (NO_VALID_METHODS.contains(sign.getMethod().getName())) {
      return;
    }

    boolean hasValidParams = this.validate0(joinPoint);
    if (!hasValidParams) {
      synchronized (NO_VALID_METHODS) {
        NO_VALID_METHODS.add(sign.getMethod().getName());
      }
    }
  }

  /**
   * 进行参数校验, 如果校验不成功, 直接从 Errors 里生产 FinalResultVO 返回, 不走入 Controller
   *
   * @param joinPoint 切面
   * @return 是否有被 {@link Valid} 标记的参数
   * @throws Throwable ignored
   */
  private boolean validate0(JoinPoint joinPoint) throws Throwable {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    var method = signature.getMethod();
    var params = method.getParameters();
    var args = joinPoint.getArgs();

    boolean hasValidParams = false;
    for (int i = 0; i < params.length; i++) {
      var param = params[i];
      var arg = args[i];
      var valid = param.getAnnotation(Valid.class);
      if (valid == null) {
        continue;
      }
      hasValidParams = true;

      var errors = new BeanPropertyBindingResult(arg, param.getName());
      this.getValidator(valid.validateBy()).validate(param, arg, errors);
      if (errors.hasErrors()) {
        var errMsg = errors
            .getAllErrors()
            .stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .findFirst()
            .orElse("参数校验不通过");
        throw new ValidationException(errMsg);
      }
    }

    return hasValidParams;
  }

  /**
   * 根据类名获取校验器
   *
   * @param clazz 校验器类
   * @return 校验器
   */
  private AbstractValidator getValidator(Class<? extends AbstractValidator> clazz) {
    return Optional.ofNullable(VALIDATOR_CACHES.get(clazz)).orElseGet(() -> {
      var validator = applicationContext.getBean(clazz);
      VALIDATOR_CACHES.put(clazz, validator);
      return validator;
    });
  }

}
