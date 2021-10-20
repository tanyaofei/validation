package com.github.tanyaofei.validation.core.validator.length;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Length;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(Number.class)
public class LengthValidatorForNumber extends AbstractLengthValidator<Number> {

  @Override
  boolean compare(Length length, Number value) {
    String valueString = value.toString();
    return length.min() <= valueString.length() && valueString.length() <= length.max();
  }

}
