package com.github.tanyaofei.validation.core.validator.empty;

import com.github.tanyaofei.validation.core.annotation.constraint.NotEmpty;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;
import org.springframework.lang.Nullable;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
public abstract class AbstractNotEmptyValidator<T> implements
    ConstraintValidator<NotEmpty, T> {

  @Override
  final
  public boolean isValid(NotEmpty notEmpty, @Nullable T value) {
    return value == null ? notEmpty.nullable() : compare(value);

  }

  /**
   * 校验值是否合法
   *
   * @param value 校验值
   * @return 是否合法
   */
  abstract boolean compare(T value);
}
