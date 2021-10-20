package com.github.tanyaofei.validation.core.validator.decimalmax;


import com.github.tanyaofei.validation.core.annotation.constraint.DecimalMax;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
public abstract class AbstractDecimalMaxValidator<T> implements
    ConstraintValidator<DecimalMax, T> {

  @Override
  final
  public boolean isValid(DecimalMax decimalMax, T value) {
    return value == null || compare(decimalMax, value);
  }

  /**
   * 比较值
   *
   * @param decimalMax 最大值
   * @param value      值
   * @return 是否通过校验
   */
  abstract boolean compare(DecimalMax decimalMax, T value);

}
