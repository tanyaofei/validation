package com.github.tanyaofei.validation.core.validator.empty;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(String.class)
public class NotEmptyValidatorForString extends AbstractNotEmptyValidator<String> {

  @Override
  boolean compare(String value) {
    return value.length() > 0;
  }
}
