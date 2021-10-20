package com.github.tanyaofei.validation.core.validator.negitave;


import com.github.tanyaofei.validation.core.annotation.constraint.NegativeOrZero;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;
import org.springframework.lang.Nullable;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
public abstract class AbstractNegativeOrZeroValidator<T> implements
    ConstraintValidator<NegativeOrZero, T> {

  @Override
  final
  public boolean isValid(NegativeOrZero negativeOrZero, @Nullable T value) {
    return value == null || compare(value);
  }

  /**
   * 比较值
   *
   * @param value 校验值
   * @return 是否合法
   */
  abstract boolean compare(T value);

}
