package com.github.tanyaofei.validation.core.validator.decimalmin;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.DecimalMin;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Double.class)
public class DecimalMinValidatorForDouble extends AbstractDecimalMinValidator<Double> {

  @Override
  public boolean compare(DecimalMin decimalMin, Double value) {
    return value.compareTo(Double.valueOf(decimalMin.value())) >= 0;
  }

}
