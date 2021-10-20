package com.github.tanyaofei.validation.core.validator.object;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Null;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(Object.class)
public class NullValidator implements ConstraintValidator<Null, Object> {

  @Override
  public boolean isValid(Null n, Object value) {
    return value == null;
  }
}
