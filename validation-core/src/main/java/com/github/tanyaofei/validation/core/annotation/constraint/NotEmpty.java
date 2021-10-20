package com.github.tanyaofei.validation.core.annotation.constraint;


import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.empty.NotEmptyValidatorForCharSequence;
import com.github.tanyaofei.validation.core.validator.empty.NotEmptyValidatorForCollection;
import com.github.tanyaofei.validation.core.validator.empty.NotEmptyValidatorForString;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验集合或字符串不能为空, 默认不可为 null
 * <ul>支持以下类型
 *   <li>{@link String}</li>
 *   <li>{@link CharSequence}</li>
 *   <li>{@link java.util.Collection}</li>
 * </ul>
 *
 * @author 谭耀飞
 * @since 2020.11.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validateBy = {
    NotEmptyValidatorForString.class,
    NotEmptyValidatorForCollection.class,
    NotEmptyValidatorForCharSequence.class
})
public @interface NotEmpty {

  /**
   * @return 是否可以为 null
   */
  boolean nullable() default false;

  /**
   * @return 异常信息
   */
  String message() default "";

}
