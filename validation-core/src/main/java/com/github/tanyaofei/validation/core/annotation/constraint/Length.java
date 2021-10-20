package com.github.tanyaofei.validation.core.annotation.constraint;

import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.length.LengthListValidatorForCharSequence;
import com.github.tanyaofei.validation.core.validator.length.LengthListValidatorForNumber;
import com.github.tanyaofei.validation.core.validator.length.LengthListValidatorForString;
import com.github.tanyaofei.validation.core.validator.length.LengthValidatorForCharSequence;
import com.github.tanyaofei.validation.core.validator.length.LengthValidatorForNumber;
import com.github.tanyaofei.validation.core.validator.length.LengthValidatorForString;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验值的长度, 不校验 null 值
 * <ul>支持以下类型
 *   <li>{@link String}</li>
 *   <li>{@link Numeric}</li>
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
    LengthValidatorForString.class,
    LengthValidatorForNumber.class,
    LengthValidatorForCharSequence.class
})
@Repeatable(Length.List.class)
public @interface Length {

  /**
   * @return 最小尺寸
   */
  long min() default 0L;

  /**
   * @return 最大尺寸
   */
  long max() default Long.MAX_VALUE;

  /**
   * @return 异常信息
   */
  String message();

  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.FIELD, ElementType.PARAMETER})
  @Constraint(validateBy = {
      LengthListValidatorForString.class,
      LengthListValidatorForNumber.class,
      LengthListValidatorForCharSequence.class
  })
  @interface List {

    Length[] value();

  }


}
