package com.github.tanyaofei.validation.core.validator.max;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Max;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(Byte.class)
public class MaxValidatorForByte extends AbstractMaxValidator<Byte> {

  @Override
  public boolean compare(Max max, Byte value) {
    return value <= max.value();
  }

}
