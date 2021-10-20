package com.github.tanyaofei.validation.core.validator.size;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Size.List;

import java.util.Collection;

/**
 * @author 谭耀飞
 * @since 2021.01.0
 */
@ValidateSupport(Collection.class)
public class SizeListValidatorForCollection extends AbstractSizeListValidator<Collection<?>> {

  @Override
  boolean compare(List sizes, Collection<?> value) {
    for (var size : sizes.value()) {
      if (size.min() <= value.size() && value.size() <= size.max()) {
        return true;
      }
    }
    return false;
  }

}
