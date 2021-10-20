package com.github.tanyaofei.validation.core.annotation;


import com.github.tanyaofei.validation.core.validator.ConstraintValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraint {

  /**
   * @return 校验器全类名
   */
  Class<? extends ConstraintValidator<?, ?>>[] validateBy();

}
