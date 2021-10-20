package com.github.tanyaofei.validation.core.validator.size;

import com.github.tanyaofei.validation.core.annotation.constraint.Size.List;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;
import org.springframework.lang.Nullable;

/**
 * @author 谭耀飞
 * @since 2021.06.0
 */
public abstract class AbstractSizeListValidator<T> implements ConstraintValidator<List, T> {

  @Override
  final
  public boolean isValid(List sizes, @Nullable T value) {
    return value == null || compare(sizes, value);
  }

  abstract boolean compare(List sizes, T value);
}
