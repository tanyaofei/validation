package com.github.tanyaofei.validation.core.validator.length;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Length;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(CharSequence.class)
public class LengthValidatorForCharSequence extends AbstractLengthValidator<CharSequence> {

  @Override
  boolean compare(Length length, CharSequence value) {
    return length.min() <= value.length() && value.length() <= length.max();
  }

}
