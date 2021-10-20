package com.github.tanyaofei.validation.core.validator.min;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Min;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(Float.class)
public class MinValidatorForFloat extends AbstractMinValidator<Float> {

  @Override
  public boolean compare(Min min, Float value) {
    return value >= min.value();
  }

}
