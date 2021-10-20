package com.github.tanyaofei.validation.core.validator.decimalmax;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.DecimalMax;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Double.class)
public class DecimalMaxValidatorForDouble extends AbstractDecimalMaxValidator<Double> {

  @Override
  boolean compare(DecimalMax decimalMax, Double value) {
    return value.compareTo(Double.valueOf(decimalMax.value())) <= 0;
  }

}
