package com.github.tanyaofei.validation.core.validator.email;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Email;

import java.util.regex.Pattern;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(String.class)
public class EmailValidatorForString extends AbstractEmailValidator<String> {

  /**
   * <p>邮箱正则</p>
   * <p>允许账号名称带数字, 中文, 和三个特殊字符: ".", "_", "="</p>
   * <p>如:tan.yao_fei-1995@qq_1-23.com</p>
   */
  private static final Pattern EMAIL_PATTERN = Pattern
      .compile("^[A-Za-z0-9\\u4e00-\\u9fa5_.-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");

  @Override
  boolean compare(Email email, String value) {
    return !value.isEmpty() && !value.isBlank() && EMAIL_PATTERN.matcher(value).matches();
  }

}
