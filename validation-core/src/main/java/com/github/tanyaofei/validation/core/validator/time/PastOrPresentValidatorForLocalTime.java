package com.github.tanyaofei.validation.core.validator.time;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

import java.time.LocalTime;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(LocalTime.class)
public class PastOrPresentValidatorForLocalTime extends AbstractPastOrPresentValidator<LocalTime> {

  @Override
  public boolean compare(LocalTime value) {
    var now = LocalTime.now();
    return now.isBefore(value) || now.equals(value);
  }

}
