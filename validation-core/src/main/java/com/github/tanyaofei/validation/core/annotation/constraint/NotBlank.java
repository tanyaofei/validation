package com.github.tanyaofei.validation.core.annotation.constraint;


import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.blank.NotBlankValidatorForCharSequence;
import com.github.tanyaofei.validation.core.validator.blank.NotBlankValidatorForString;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验字符串不为空(也不能为 null)
 * <ul>支持以下类型
 *   <li>{@link String}</li>
 *   <li>{@link CharSequence}</li>
 * </ul>
 *
 * @author 谭耀飞
 * @since 2020.11.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validateBy = {
    NotBlankValidatorForCharSequence.class,
    NotBlankValidatorForString.class
})
public @interface NotBlank {

  /**
   * @return 能否为 null
   */
  boolean nullable() default false;

  /**
   * @return 异常信息
   */
  String message() default "";

}
