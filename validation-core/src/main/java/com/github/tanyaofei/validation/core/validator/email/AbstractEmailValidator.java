package com.github.tanyaofei.validation.core.validator.email;

import com.github.tanyaofei.validation.core.annotation.constraint.Email;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;
import org.springframework.lang.Nullable;

/**
 * @author 谭耀飞
 * @since 2021.06.0
 */
public abstract class AbstractEmailValidator<T> implements ConstraintValidator<Email, T> {

  @Override
  final
  public boolean isValid(Email email, @Nullable T value) {
    return value == null || compare(email, value);
  }

  abstract boolean compare(Email email, T value);
}
