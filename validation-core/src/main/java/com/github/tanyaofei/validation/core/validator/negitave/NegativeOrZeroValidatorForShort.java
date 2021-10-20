package com.github.tanyaofei.validation.core.validator.negitave;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Short.class)
public class NegativeOrZeroValidatorForShort extends
    AbstractNegativeOrZeroValidator<Short> {

  @Override
  boolean compare(Short value) {
    return value <= 0;
  }
}
