package com.github.tanyaofei.validation.core.validator.positive;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

import java.math.BigDecimal;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(BigDecimal.class)
public class PositiveOrZeroValidatorForBigDecimal extends AbstractPositiveOrZeroValidator<BigDecimal> {

  @Override
  boolean compare(BigDecimal value) {
    return value.compareTo(BigDecimal.ZERO) >= 0;
  }
}
