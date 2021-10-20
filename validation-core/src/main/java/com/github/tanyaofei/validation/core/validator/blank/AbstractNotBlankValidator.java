package com.github.tanyaofei.validation.core.validator.blank;


import com.github.tanyaofei.validation.core.annotation.constraint.NotBlank;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;

/**
 * @author 谭耀飞
 * @since 2021.03.0
 */
public abstract class AbstractNotBlankValidator<T> implements
    ConstraintValidator<NotBlank, T> {

  @Override
  final
  public boolean isValid(NotBlank notBlank, T value) {
    return value == null ? notBlank.nullable() : compare(value);
  }

  /**
   * 比较值
   *
   * @param value 值
   * @return 是否通过校验
   */
  abstract boolean compare(T value);
}
