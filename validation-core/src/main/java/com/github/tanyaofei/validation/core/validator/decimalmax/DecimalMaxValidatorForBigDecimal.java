package com.github.tanyaofei.validation.core.validator.decimalmax;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.DecimalMax;

import java.math.BigDecimal;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(BigDecimal.class)
public class DecimalMaxValidatorForBigDecimal extends
    AbstractDecimalMaxValidator<BigDecimal> {

  @Override
  boolean compare(DecimalMax decimalMax, BigDecimal value) {
    return value.compareTo(new BigDecimal(decimalMax.value())) <= 0;
  }

}
