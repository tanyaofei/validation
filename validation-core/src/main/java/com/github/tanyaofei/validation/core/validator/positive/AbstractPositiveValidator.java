package com.github.tanyaofei.validation.core.validator.positive;


import com.github.tanyaofei.validation.core.annotation.constraint.Positive;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
public abstract class AbstractPositiveValidator<T> implements
    ConstraintValidator<Positive, T> {

  @Override
  final
  public boolean isValid(Positive positive, T value) {
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
