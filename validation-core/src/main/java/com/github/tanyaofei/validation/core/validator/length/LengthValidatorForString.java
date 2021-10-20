package com.github.tanyaofei.validation.core.validator.length;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Length;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(String.class)
public class LengthValidatorForString extends AbstractLengthValidator<String> {

  @Override
  boolean compare(Length length, String value) {
    return length.min() <= value.length() && value.length() <= length.max();
  }
}
