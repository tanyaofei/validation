package com.github.tanyaofei.validation.core.validator.size;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Size.List;

/**
 * @author 谭耀飞
 * @since 2021.01.0
 */
@ValidateSupport(Object[].class)
public class SizeListValidatorForArray extends AbstractSizeListValidator<Object[]> {

  @Override
  boolean compare(List sizes, Object[] value) {
    for (var size : sizes.value()) {
      if (size.min() <= value.length && value.length <= size.max()) {
        return true;
      }
    }
    return false;
  }
}
