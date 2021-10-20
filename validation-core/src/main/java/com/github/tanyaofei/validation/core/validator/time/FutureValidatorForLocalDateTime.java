package com.github.tanyaofei.validation.core.validator.time;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

import java.time.LocalDateTime;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(LocalDateTime.class)
public class FutureValidatorForLocalDateTime extends AbstractFutureValidator<LocalDateTime> {

  @Override
  public boolean compare(LocalDateTime value) {
    return value.isAfter(LocalDateTime.now());
  }

}
