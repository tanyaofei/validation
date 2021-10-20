package com.github.tanyaofei.validation.core.validator.max;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Max;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(Short.class)
public class MaxValidatorForShort extends AbstractMaxValidator<Short> {

  @Override
  public boolean compare(Max max, Short value) {
    return value <= max.value();
  }

}
