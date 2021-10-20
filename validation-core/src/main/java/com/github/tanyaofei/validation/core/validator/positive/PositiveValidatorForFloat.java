package com.github.tanyaofei.validation.core.validator.positive;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Float.class)
public class PositiveValidatorForFloat extends AbstractPositiveValidator<Float> {

  @Override
  boolean compare(Float value) {
    return value > 0F;
  }
}
