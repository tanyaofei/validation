package com.github.tanyaofei.validation.core.validator.min;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Min;

import java.math.BigDecimal;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(BigDecimal.class)
public class MinValidatorForBigDecimal extends AbstractMinValidator<BigDecimal> {

  @Override
  public boolean compare(Min min, BigDecimal value) {
    return value.compareTo(new BigDecimal(min.value())) >= 0;
  }

}
