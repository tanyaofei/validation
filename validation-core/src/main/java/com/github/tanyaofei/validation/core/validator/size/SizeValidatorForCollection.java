package com.github.tanyaofei.validation.core.validator.size;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Size;

import java.util.Collection;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(Collection.class)
public class SizeValidatorForCollection extends AbstractSizeValidator<Collection<?>> {

  @Override
  boolean compare(Size size, Collection<?> value) {
    return size.min() <= value.size() && size.max() >= value.size();
  }

}
