package com.github.tanyaofei.validation.core.annotation.constraint;


import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.min.MinValidatorForBigDecimal;
import com.github.tanyaofei.validation.core.validator.min.MinValidatorForByte;
import com.github.tanyaofei.validation.core.validator.min.MinValidatorForDouble;
import com.github.tanyaofei.validation.core.validator.min.MinValidatorForFloat;
import com.github.tanyaofei.validation.core.validator.min.MinValidatorForInteger;
import com.github.tanyaofei.validation.core.validator.min.MinValidatorForLong;
import com.github.tanyaofei.validation.core.validator.min.MinValidatorForShort;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验最小值, 不校验 null 值
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
 * @see DecimalMin  如果需要指定最小值为一个小数, 则使用该注解
 * @since 2020.11.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validateBy = {
    MinValidatorForLong.class,
    MinValidatorForByte.class,
    MinValidatorForShort.class,
    MinValidatorForFloat.class,
    MinValidatorForDouble.class,
    MinValidatorForInteger.class,
    MinValidatorForBigDecimal.class
})
public @interface Min {

  /**
   * @return 最小值, 值可以大于等于这个值
   */
  long value();

  /**
   * @return 异常信息
   */
  String message() default "";


}
