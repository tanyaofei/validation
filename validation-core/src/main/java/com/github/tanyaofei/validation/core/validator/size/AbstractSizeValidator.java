package com.github.tanyaofei.validation.core.validator.size;

import com.github.tanyaofei.validation.core.annotation.constraint.Size;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;
import org.springframework.lang.Nullable;

/**
 * @author 谭耀飞
 * @since 2021.06.0
 */
public abstract class AbstractSizeValidator<T> implements ConstraintValidator<Size, T> {

  @Override
  final
  public boolean isValid(Size size, @Nullable T value) {
    return value == null || compare(size, value);
  }

  abstract boolean compare(Size size, T value);
}
