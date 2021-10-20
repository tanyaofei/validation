package com.github.tanyaofei.validation.core.validator.object;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.NotNull;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(Object.class)
public class NotNullValidator implements ConstraintValidator<NotNull, Object> {

  @Override
  public boolean isValid(NotNull notNull, Object value) {
    return value != null;
  }
}
