package com.github.tanyaofei.validation.core.validator.positive;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Integer.class)
public class PositiveOrZeroValidatorForInteger extends AbstractPositiveOrZeroValidator<Integer> {

  @Override
  boolean compare(Integer value) {
    return value >= 0;
  }
}
