package com.github.tanyaofei.validation.core.validator.range;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Range;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Double.class)
public class RangeValidatorForDouble extends AbstractRangeValidator<Double> {

  @Override
  public boolean compare(Range range, Double value) {
    return range.min() <= value && value <= range.max();
  }
}
