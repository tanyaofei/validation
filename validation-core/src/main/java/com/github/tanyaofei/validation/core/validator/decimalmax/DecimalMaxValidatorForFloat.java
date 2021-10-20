package com.github.tanyaofei.validation.core.validator.decimalmax;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.DecimalMax;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Float.class)
public class DecimalMaxValidatorForFloat extends AbstractDecimalMaxValidator<Float> {

  @Override
  boolean compare(DecimalMax decimalMax, Float value) {
    return value.compareTo(Float.valueOf(decimalMax.value())) <= 0;
  }

}
