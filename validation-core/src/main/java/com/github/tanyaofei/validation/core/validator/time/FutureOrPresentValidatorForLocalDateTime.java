package com.github.tanyaofei.validation.core.validator.time;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

import java.time.LocalDateTime;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(LocalDateTime.class)
public class FutureOrPresentValidatorForLocalDateTime extends
    AbstractFutureOrPresentValidator<LocalDateTime> {

  @Override
  boolean compare(LocalDateTime value) {
    var now = LocalDateTime.now();
    return now.isAfter(value) || now.isEqual(value);
  }

}
