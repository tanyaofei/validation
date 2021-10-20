package com.github.tanyaofei.validation.core.validator.empty;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;

import java.util.Collection;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(Collection.class)
public class NotEmptyValidatorForCollection extends AbstractNotEmptyValidator<Collection<?>> {

  @Override
  boolean compare(Collection<?> value) {
    return !value.isEmpty();
  }

}
