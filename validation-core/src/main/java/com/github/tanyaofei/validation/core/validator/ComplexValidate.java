package com.github.tanyaofei.validation.core.validator;

import org.springframework.lang.Nullable;
import org.springframework.validation.Errors;

/**
 * @author 谭耀飞
 * @since 2020.11.0
 */
public interface ComplexValidate {

  /**
   * 复杂校验实现
   *
   * @param target 校验DTO
   * @param errors 异常对象
   */
  void complexValidate(@Nullable Object target, Errors errors);

}
