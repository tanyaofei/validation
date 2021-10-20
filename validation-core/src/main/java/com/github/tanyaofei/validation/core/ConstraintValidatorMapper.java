package com.github.tanyaofei.validation.core;


import com.github.tanyaofei.validation.core.validator.ConstraintValidator;

import java.lang.annotation.Annotation;
import java.util.Optional;

/**
 * @author 谭耀飞
 * @since 2021.01.0
 */
public interface ConstraintValidatorMapper {

  /**
   * 获取校验器
   *
   * @param annotationType 校验注解类型
   * @param valueType      待校验值类型
   * @return 校验器
   */
  Optional<ConstraintValidator<?, ?>> getValidator(
      Class<? extends Annotation> annotationType, Class<?> valueType
  );

}
