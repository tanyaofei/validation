package com.github.tanyaofei.validation.core.validator.digest;

import com.github.tanyaofei.validation.core.annotation.constraint.Digest;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;
import org.springframework.lang.Nullable;

/**
 * @author 谭耀飞
 * @since 2021.06.0
 */
public abstract class AbstractDigestValidator<T> implements ConstraintValidator<Digest, T> {

  @Override
  final
  public boolean isValid(Digest digest, @Nullable T value) {
    return value == null || compare(digest, value);
  }

  /**
   * 比较值
   *
   * @param decimalMin 最小值
   * @param value      值
   * @return 是否通过校验
   */
  abstract boolean compare(Digest decimalMin, T value);
}
