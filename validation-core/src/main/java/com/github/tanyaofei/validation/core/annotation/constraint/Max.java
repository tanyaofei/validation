package com.github.tanyaofei.validation.core.annotation.constraint;


import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.max.MaxValidatorForBigDecimal;
import com.github.tanyaofei.validation.core.validator.max.MaxValidatorForByte;
import com.github.tanyaofei.validation.core.validator.max.MaxValidatorForDouble;
import com.github.tanyaofei.validation.core.validator.max.MaxValidatorForFloat;
import com.github.tanyaofei.validation.core.validator.max.MaxValidatorForInteger;
import com.github.tanyaofei.validation.core.validator.max.MaxValidatorForLong;
import com.github.tanyaofei.validation.core.validator.max.MaxValidatorForShort;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验最大值, 不校验 null 值
 * <ul>支持以下类型
 *   <li>{@link Long}</li>
 *   <li>{@link Byte}</li>
 *   <li>{@link Short}</li>
 *   <li>{@link Float}</li>
 *   <li>{@link Double}</li>
 *   <li>{@link Integer}</li>
 *   <li>{@link java.math.BigDecimal}</li>
 * </ul>
 *
 * @author 谭耀飞
 * @see DecimalMax  如果需要指定最大值为一个小数, 则使用该注解
 * @since 2020.11.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validateBy = {
    MaxValidatorForLong.class,
    MaxValidatorForByte.class,
    MaxValidatorForShort.class,
    MaxValidatorForFloat.class,
    MaxValidatorForDouble.class,
    MaxValidatorForInteger.class,
    MaxValidatorForBigDecimal.class
})
public @interface Max {

  /**
   * @return 最小值, 值可以大于等于这个值
   */
  long value();

  /**
   * @return 异常信息
   */
  String message() default "";

}
