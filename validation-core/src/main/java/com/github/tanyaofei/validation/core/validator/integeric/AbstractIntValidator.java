package com.github.tanyaofei.validation.core.validator.integeric;

import com.github.tanyaofei.validation.core.annotation.constraint.Int;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;
import org.springframework.lang.Nullable;

/**
 * @author 谭耀飞
 * @since 2021.06.0
 */
public abstract class AbstractIntValidator<T> implements ConstraintValidator<Int, T> {

  @Override
  public boolean isValid(Int anInt, @Nullable T value) {
    return value == null || compare(anInt, value);
  }

  abstract boolean compare(Int anInt, T value);
}
