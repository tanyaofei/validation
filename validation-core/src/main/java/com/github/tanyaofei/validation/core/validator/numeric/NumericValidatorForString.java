package com.github.tanyaofei.validation.core.validator.numeric;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Numeric;

import java.math.BigDecimal;

/**
 * @author 谭耀飞
 * @since 2021.06.0
 */
@ValidateSupport(String.class)
public class NumericValidatorForString extends AbstractNumericValidator<String> {

  @Override
  final boolean compare(Numeric numeric, String value) {
    if (value.isEmpty() || value.isBlank()) {
      return false;
    }

    try {
      new BigDecimal(value);
    } catch (NumberFormatException ignored) {
      return false;
    }

    return true;
  }


}
