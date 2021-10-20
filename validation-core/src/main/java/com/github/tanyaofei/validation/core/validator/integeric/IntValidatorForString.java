package com.github.tanyaofei.validation.core.validator.integeric;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Int;

/**
 * @author 谭耀飞
 * @since 2021.06.0
 */
@ValidateSupport(String.class)
public class IntValidatorForString extends AbstractIntValidator<String> {

  @Override
  boolean compare(Int anInt, String value) {
    for (char c : value.toCharArray()) {
      if (!Character.isDigit(c)) {
        return false;
      }
    }
    return true;
  }

}
