package com.github.tanyaofei.validation.core.validator.blank;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(CharSequence.class)
public class NotBlankValidatorForCharSequence extends AbstractNotBlankValidator<CharSequence> {

  @Override
  boolean compare(CharSequence value) {
    int len = value.length();
    for (int i = 0; i < len; ++i) {
      if (!Character.isWhitespace(value.charAt(i))) {
        return true;
      }
    }

    return false;
  }
}
