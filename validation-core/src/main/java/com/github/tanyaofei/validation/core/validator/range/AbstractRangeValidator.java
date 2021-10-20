package com.github.tanyaofei.validation.core.validator.range;

import com.github.tanyaofei.validation.core.annotation.constraint.Range;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;
import org.springframework.lang.Nullable;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
public abstract class AbstractRangeValidator<T> implements ConstraintValidator<Range, T> {

  @Override
  final
  public boolean isValid(Range range, @Nullable T value) {
    return value == null || compare(range, value);
  }

  /**
   * 比较值
   *
   * @param range 范围
   * @param value 值
   * @return 是否通过校验
   */
  abstract boolean compare(Range range, T value);
}
