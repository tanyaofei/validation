package com.github.tanyaofei.validation.core.validator.time;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

import java.time.LocalDate;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(LocalDate.class)
public class PastValidatorForLocalDate extends AbstractPastValidator<LocalDate> {

  @Override
  public boolean compare(LocalDate value) {
    return value.isBefore(LocalDate.now());
  }

}
