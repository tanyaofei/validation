package com.github.tanyaofei.validation.core.validator.pattern;

import com.github.tanyaofei.validation.core.annotation.constraint.Pattern;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;
import org.springframework.lang.Nullable;

/**
 * @author 谭耀飞
 * @since 2021.06.0
 */
public abstract class AbstractPatternValidator<T> implements ConstraintValidator<Pattern, T> {

  @Override
  final
  public boolean isValid(Pattern pattern, @Nullable T value) {
    return value == null || compare(pattern, value);
  }

  abstract boolean compare(Pattern pattern, T value);

}
