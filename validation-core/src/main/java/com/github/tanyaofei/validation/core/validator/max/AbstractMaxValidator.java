package com.github.tanyaofei.validation.core.validator.max;


import com.github.tanyaofei.validation.core.annotation.constraint.Max;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
public abstract class AbstractMaxValidator<T> implements ConstraintValidator<Max, T> {

  @Override
  final
  public boolean isValid(Max max, T value) {
    return value == null || compare(max, value);
  }

  /**
   * 比较值
   *
   * @param max   最大值
   * @param value 值
   * @return 是否通过校验
   */
  abstract boolean compare(Max max, T value);

}
