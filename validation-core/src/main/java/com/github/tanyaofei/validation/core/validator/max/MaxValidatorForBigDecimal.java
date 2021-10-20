package com.github.tanyaofei.validation.core.validator.max;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Max;

import java.math.BigDecimal;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(BigDecimal.class)
public class MaxValidatorForBigDecimal extends AbstractMaxValidator<BigDecimal> {

  @Override
  public boolean compare(Max max, BigDecimal value) {
    return value.compareTo(new BigDecimal(max.value())) <= 0;
  }

}
