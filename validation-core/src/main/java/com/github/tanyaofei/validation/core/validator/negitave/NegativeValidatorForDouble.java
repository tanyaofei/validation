package com.github.tanyaofei.validation.core.validator.negitave;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Double.class)
public class NegativeValidatorForDouble extends AbstractNegativeValidator<Double> {

  @Override
  boolean compare(Double value) {
    return value < 0D;
  }
}
