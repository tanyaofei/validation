package com.github.tanyaofei.validation.core.validator.max;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Max;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(Long.class)
public class MaxValidatorForLong extends AbstractMaxValidator<Long> {

  @Override
  public boolean compare(Max max, Long value) {
    return value <= max.value();
  }

}
