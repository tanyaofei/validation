package com.github.tanyaofei.validation.core.validator.time;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

import java.time.LocalDate;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(LocalDate.class)
public class FutureOrPresentValidatorForLocalDate extends
    AbstractFutureOrPresentValidator<LocalDate> {

  @Override
  boolean compare(LocalDate value) {
    var now = LocalDate.now();
    return now.isAfter(value) || now.isEqual(value);
  }

}
