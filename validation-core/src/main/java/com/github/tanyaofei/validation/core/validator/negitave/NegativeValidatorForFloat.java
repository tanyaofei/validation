package com.github.tanyaofei.validation.core.validator.negitave;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Float.class)
public class NegativeValidatorForFloat extends AbstractNegativeValidator<Float> {

  @Override
  boolean compare(Float value) {
    return value < 0F;
  }
}
