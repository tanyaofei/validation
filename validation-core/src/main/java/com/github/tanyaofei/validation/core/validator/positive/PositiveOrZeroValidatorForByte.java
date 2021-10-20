package com.github.tanyaofei.validation.core.validator.positive;


import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Byte.class)
public class PositiveOrZeroValidatorForByte extends AbstractPositiveOrZeroValidator<Byte> {

  @Override
  boolean compare(Byte value) {
    return value >= 0x0;
  }
}
