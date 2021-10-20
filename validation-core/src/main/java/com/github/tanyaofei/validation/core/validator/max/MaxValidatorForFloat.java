package com.github.tanyaofei.validation.core.validator.max;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Max;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(Float.class)
public class MaxValidatorForFloat extends AbstractMaxValidator<Float> {

  @Override
  public boolean compare(Max max, Float value) {
    return value <= max.value();
  }

}
