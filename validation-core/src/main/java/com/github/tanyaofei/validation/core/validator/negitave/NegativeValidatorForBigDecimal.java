package com.github.tanyaofei.validation.core.validator.negitave;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

import java.math.BigDecimal;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(BigDecimal.class)
public class NegativeValidatorForBigDecimal extends
    AbstractNegativeValidator<BigDecimal> {

  @Override
  boolean compare(BigDecimal value) {
    return value.compareTo(BigDecimal.ZERO) < 0;
  }
}
