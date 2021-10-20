package com.github.tanyaofei.validation.core.validator.range;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Range;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Float.class)
public class RangeValidatorForFloat extends AbstractRangeValidator<Float> {

  @Override
  public boolean compare(Range range, Float value) {
    return range.min() <= value && value <= range.max();
  }
}
