package com.github.tanyaofei.validation.core.validator.decimalmin;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.DecimalMin;

import java.math.BigDecimal;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(BigDecimal.class)
public class DecimalMinValidatorForBigDecimal extends
    AbstractDecimalMinValidator<BigDecimal> {

  @Override
  public boolean compare(DecimalMin decimalMax, BigDecimal value) {
    return value.compareTo(new BigDecimal(decimalMax.value())) >= 0;
  }

}
