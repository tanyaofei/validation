package com.github.tanyaofei.validation.core.validator.range;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Range;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Byte.class)
public class RangeValidatorForByte extends AbstractRangeValidator<Byte> {

  @Override
  public boolean compare(Range range, Byte value) {
    return (byte) range.min() <= value && value <= (byte) range.max();
  }
}
