package com.github.tanyaofei.validation.core.annotation.constraint;

import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.time.PastOrPresentValidatorForLocalDate;
import com.github.tanyaofei.validation.core.validator.time.PastOrPresentValidatorForLocalDateTime;
import com.github.tanyaofei.validation.core.validator.time.PastOrPresentValidatorForLocalTime;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验时间为过去时间或当前时间, 不校验 null 值
 * <ul>支持以下类型
 *   <li>{@link java.time.LocalTime}</li>
 *   <li>{@link java.time.LocalDate}</li>
 *   <li>{@link java.time.LocalDateTime}</li>
 * </ul>
 *
 * @author 谭耀飞
 * @since 2020.11.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validateBy = {
    PastOrPresentValidatorForLocalTime.class,
    PastOrPresentValidatorForLocalDate.class,
    PastOrPresentValidatorForLocalDateTime.class
})
public @interface PastOrPresent {

  /**
   * @return 异常信息
   */
  String message() default "";

}
