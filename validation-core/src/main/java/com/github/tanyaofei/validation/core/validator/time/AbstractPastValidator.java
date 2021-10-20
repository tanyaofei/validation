package com.github.tanyaofei.validation.core.validator.time;

import com.github.tanyaofei.validation.core.annotation.constraint.Past;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;
import org.springframework.lang.Nullable;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
public abstract class AbstractPastValidator<T> implements ConstraintValidator<Past, T> {

  @Override
  public boolean isValid(Past past, @Nullable T value) {
    return value == null || compare(value);
  }

  /**
   * 比较值
   *
   * @param value 值
   * @return 校验是否通过
   */
  abstract boolean compare(T value);

}
