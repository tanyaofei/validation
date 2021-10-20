package com.github.tanyaofei.validation.core.validator.numeric;

import com.github.tanyaofei.validation.core.annotation.constraint.Numeric;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;
import org.springframework.lang.Nullable;

/**
 * @author 谭耀飞
 * @since 2021.06.0
 */
public abstract class AbstractNumericValidator<T> implements ConstraintValidator<Numeric, T> {

  @Override
  final
  public boolean isValid(Numeric numeric, @Nullable T value) {
    return value == null || compare(numeric, value);
  }

  abstract boolean compare(Numeric numeric, T value);
}
