package com.github.tanyaofei.validation.core.validator.repeat;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

import java.util.HashSet;
import java.util.List;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(List.class)
public class NotRepeatValidatorForList extends AbstractNotRepeatValidator<List<?>> {

  @Override
  boolean compare(List<?> value) {
    return value.size() < 2 || new HashSet<>(value).size() == value.size();
  }

}
