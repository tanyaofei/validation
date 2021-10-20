package com.github.tanyaofei.validation.core.validator.length;

import com.github.tanyaofei.validation.core.annotation.constraint.Length;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;
import org.springframework.lang.Nullable;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
public abstract class AbstractLengthValidator<T> implements
    ConstraintValidator<Length, T> {

  @Override
  final
  public boolean isValid(Length length, @Nullable T value) {
    return value == null || compare(length, value);
  }

  /**
   * 判断是否合法
   *
   * @param length 长度注解
   * @param value  校验值
   * @return 是否合法
   */
  abstract boolean compare(Length length, @Nullable T value);
}
