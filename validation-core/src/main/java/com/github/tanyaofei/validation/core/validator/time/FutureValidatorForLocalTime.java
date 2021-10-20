package com.github.tanyaofei.validation.core.validator.time;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

import java.time.LocalTime;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(LocalTime.class)
public class FutureValidatorForLocalTime extends AbstractFutureValidator<LocalTime> {

  @Override
  public boolean compare(LocalTime value) {
    return value.isAfter(LocalTime.now());
  }

}
