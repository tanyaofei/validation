package com.github.tanyaofei.validation.core.validator.decimalmin;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.DecimalMin;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Float.class)
public class DecimalMinValidatorForFloat extends AbstractDecimalMinValidator<Float> {

  @Override
  public boolean compare(DecimalMin decimalMin, Float value) {
    return value.compareTo(Float.valueOf(decimalMin.value())) >= 0;
  }

}
