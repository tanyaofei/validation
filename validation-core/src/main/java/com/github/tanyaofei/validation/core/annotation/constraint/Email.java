package com.github.tanyaofei.validation.core.annotation.constraint;

import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.email.EmailValidatorForString;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验字符串符合邮箱格式, 不校验 null 值
 * <p>支持类型: {@link String}</p>
 *
 * @author 谭耀飞
 * @since 2020.12.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validateBy = {
    EmailValidatorForString.class
})
public @interface Email {

  /**
   * @return 异常信息
   */
  String message() default "";

}
