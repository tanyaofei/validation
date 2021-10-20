package com.github.tanyaofei.validation.core.validator.size;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Size;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
@ValidateSupport(Object[].class)
public class SizeValidatorForArray extends AbstractSizeValidator<Object[]> {

  @Override
  boolean compare(Size size, Object[] value) {
    return size.min() <= value.length && size.max() >= value.length;
  }

}
