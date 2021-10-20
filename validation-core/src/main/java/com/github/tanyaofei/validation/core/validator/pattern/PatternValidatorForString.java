package com.github.tanyaofei.validation.core.validator.pattern;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Pattern;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(String.class)
public class PatternValidatorForString extends AbstractPatternValidator<String> {

  @Override
  boolean compare(Pattern pattern, String value) {
    return java.util.regex.Pattern.matches(pattern.value(), value);
  }

}
