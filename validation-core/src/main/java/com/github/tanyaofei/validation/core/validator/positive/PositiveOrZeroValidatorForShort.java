package com.github.tanyaofei.validation.core.validator.positive;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Short.class)
public class PositiveOrZeroValidatorForShort extends AbstractPositiveOrZeroValidator<Short> {

  @Override
  boolean compare(Short value) {
    return value >= 0;
  }
}
