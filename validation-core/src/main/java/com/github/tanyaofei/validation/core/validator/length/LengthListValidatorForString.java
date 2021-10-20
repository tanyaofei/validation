package com.github.tanyaofei.validation.core.validator.length;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Length.List;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(String.class)
public class LengthListValidatorForString extends AbstractLengthListValidator<String> {

  @Override
  boolean compare(List list, String value) {
    for (var length : list.value()) {
      if (length.min() <= value.length() && value.length() <= length.max()) {
        return true;
      }
    }

    return false;
  }
}
