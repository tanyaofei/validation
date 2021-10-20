package com.github.tanyaofei.validation.core.validator;

import org.springframework.lang.Nullable;
import org.springframework.validation.Errors;

/**
 * 实现自定义校验要继承 {@link AbstractValidator}
 *
 * @author 谭耀飞
 * @since 2020.11.0
 */
public final class CommonValidator extends AbstractValidator {

  @Override
  public boolean supports(Class<?> clazz) {
    return true;
  }


  @Override
  public void complexValidate(@Nullable Object target, Errors errors) {
    // do nothing
  }

}
