package com.github.tanyaofei.validation.core.validator.positive;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Long.class)
public class PositiveValidatorForLong extends AbstractPositiveValidator<Long> {

  @Override
  boolean compare(Long value) {
    return value > 0L;
  }

}
