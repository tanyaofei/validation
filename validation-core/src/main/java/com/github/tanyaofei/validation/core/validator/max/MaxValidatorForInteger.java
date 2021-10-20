package com.github.tanyaofei.validation.core.validator.max;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Max;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(Integer.class)
public class MaxValidatorForInteger extends AbstractMaxValidator<Integer> {

  @Override
  public boolean compare(Max max, Integer value) {
    return value <= max.value();
  }

}
