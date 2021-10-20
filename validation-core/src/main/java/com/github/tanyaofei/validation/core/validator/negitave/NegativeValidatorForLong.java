package com.github.tanyaofei.validation.core.validator.negitave;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Long.class)
public class NegativeValidatorForLong extends AbstractNegativeValidator<Long> {

  @Override
  boolean compare(Long value) {
    return value < 0L;
  }
}
