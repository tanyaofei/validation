package com.github.tanyaofei.validation.core.validator.decimalmin;


import com.github.tanyaofei.validation.core.annotation.constraint.DecimalMin;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;
import org.springframework.lang.Nullable;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
public abstract class AbstractDecimalMinValidator<T> implements
    ConstraintValidator<DecimalMin, T> {

  @Override
  final
  public boolean isValid(DecimalMin decimalMin, @Nullable T value) {
    return value == null || compare(decimalMin, value);
  }

  /**
   * 比较值
   *
   * @param decimalMin 最小值
   * @param value      值
   * @return 是否通过校验
   */
  abstract boolean compare(DecimalMin decimalMin, T value);
}
