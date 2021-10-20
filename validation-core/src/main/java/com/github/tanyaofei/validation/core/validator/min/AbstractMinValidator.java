package com.github.tanyaofei.validation.core.validator.min;

import com.github.tanyaofei.validation.core.annotation.constraint.Min;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;
import org.springframework.lang.Nullable;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
public abstract class AbstractMinValidator<T> implements ConstraintValidator<Min, T> {

  @Override
  final
  public boolean isValid(Min min, @Nullable T value) {
    return value == null || compare(min, value);
  }

  /**
   * 比较值
   *
   * @param min   最小值
   * @param value 值
   * @return 是否通过校验
   */
  abstract boolean compare(Min min, T value);

}
