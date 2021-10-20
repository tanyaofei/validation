package com.github.tanyaofei.validation.core.validator.repeat;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(Object[].class)
public class NotRepeatValidatorForArray extends AbstractNotRepeatValidator<Object[]> {

  @Override
  public boolean compare(Object[] value) {
    return value.length < 2 || new HashSet<>(Arrays.asList(value)).size() == value.length;
  }

}
