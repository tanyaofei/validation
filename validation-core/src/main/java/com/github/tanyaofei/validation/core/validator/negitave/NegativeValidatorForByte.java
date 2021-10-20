package com.github.tanyaofei.validation.core.validator.negitave;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Byte.class)
public class NegativeValidatorForByte extends AbstractNegativeValidator<Byte> {

  @Override
  boolean compare(Byte value) {
    return value < 0;
  }
}
