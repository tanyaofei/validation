package com.github.tanyaofei.validation.core.validator.length;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Length.List;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Number.class)
public class LengthListValidatorForNumber extends AbstractLengthListValidator<Number> {

  @Override
  boolean compare(List list, Number value) {
    for (var length : list.value()) {
      String valueString = value.toString();
      if (length.min() <= valueString.length() && valueString.length() <= length.max()) {
        return true;
      }
    }

    return false;
  }
}
