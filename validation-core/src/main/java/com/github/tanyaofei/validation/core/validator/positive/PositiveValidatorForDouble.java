package com.github.tanyaofei.validation.core.validator.positive;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Double.class)
public class PositiveValidatorForDouble extends AbstractPositiveValidator<Double> {

  @Override
  boolean compare(Double value) {
    return value > 0D;
  }
}
