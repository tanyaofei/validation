package com.github.tanyaofei.validation.core.validator.positive;


import com.github.tanyaofei.validation.core.annotation.constraint.PositiveOrZero;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
public abstract class AbstractPositiveOrZeroValidator<T> implements
    ConstraintValidator<PositiveOrZero, T> {

  @Override
  final
  public boolean isValid(PositiveOrZero positive, T value) {
    return value == null || compare(value);
  }

  /**
   * 比较方法实现
   *
   * @param value 校验值
   * @return 是否合法
   */
  abstract boolean compare(T value);
}
