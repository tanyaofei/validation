package com.github.tanyaofei.validation.core.validator.repeat;

import com.github.tanyaofei.validation.core.annotation.constraint.NotRepeat;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;

/**
 * @author 谭耀飞
 * @since 2021.03.0
 */
public abstract class AbstractNotRepeatValidator<T> implements
    ConstraintValidator<NotRepeat, T> {

  @Override
  final
  public boolean isValid(NotRepeat notRepeat, T value) {
    if (value == null) {
      return true;
    }

    return compare(value);
  }

  /**
   * 比较值
   *
   * @param value 值
   * @return 是否通过校验
   */
  abstract boolean compare(T value);
}
