package com.github.tanyaofei.validation.core.validator.range;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Range;

import java.math.BigDecimal;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(BigDecimal.class)
public class RangeValidatorForBigDecimal extends AbstractRangeValidator<BigDecimal> {

  @Override
  public boolean compare(Range range, BigDecimal value) {
    return value.compareTo(new BigDecimal(range.min())) >= 0
        && value.compareTo(new BigDecimal(range.max())) <= 0;
  }

}
