package com.github.tanyaofei.validation.core.validator.time;

import com.github.tanyaofei.validation.core.annotation.constraint.Future;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;
import org.springframework.lang.Nullable;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
public abstract class AbstractFutureValidator<T> implements ConstraintValidator<Future, T> {

  @Override
  public boolean isValid(Future future, @Nullable T value) {
    return value == null || compare(value);
  }

  /**
   * 比较值
   *
   * @param value 值
   * @return 校验是否通过
   */
  abstract boolean compare(T value);

}
