package com.github.tanyaofei.validation.core.validator.empty;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(CharSequence.class)
public class NotEmptyValidatorForCharSequence extends AbstractNotEmptyValidator<CharSequence> {

  @Override
  boolean compare(CharSequence value) {
    return value.length() > 0;
  }
}
