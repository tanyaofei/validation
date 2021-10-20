package com.github.tanyaofei.validation.core.validator.telephone;

import com.github.tanyaofei.validation.core.annotation.constraint.Telephone;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;
import org.springframework.lang.Nullable;

/**
 * @author 谭耀飞
 * @since 2021.06.0
 */
public abstract
class AbstractTelephoneValidator<T> implements ConstraintValidator<Telephone, T> {

  @Override
  final
  public boolean isValid(Telephone telephone, @Nullable T value) {
    return value == null || compare(telephone, value);
  }

  abstract boolean compare(Telephone telephone, T value);

}
