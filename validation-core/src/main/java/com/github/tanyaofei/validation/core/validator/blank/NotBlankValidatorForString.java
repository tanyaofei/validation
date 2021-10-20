package com.github.tanyaofei.validation.core.validator.blank;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(String.class)
public class NotBlankValidatorForString extends AbstractNotBlankValidator<String> {

  @Override
  boolean compare(String value) {
    int len = value.length();
    for (int i = 0; i < len; ++i) {
      if (!Character.isWhitespace(value.codePointAt(i))) {
        return true;
      }
    }

    return false;
  }

}
