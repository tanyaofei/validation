package com.github.tanyaofei.validation.core.annotation.constraint;


import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.range.RangeValidatorForBigDecimal;
import com.github.tanyaofei.validation.core.validator.range.RangeValidatorForByte;
import com.github.tanyaofei.validation.core.validator.range.RangeValidatorForDouble;
import com.github.tanyaofei.validation.core.validator.range.RangeValidatorForFloat;
import com.github.tanyaofei.validation.core.validator.range.RangeValidatorForInteger;
import com.github.tanyaofei.validation.core.validator.range.RangeValidatorForLong;
import com.github.tanyaofei.validation.core.validator.range.RangeValidatorForShort;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验值的大小范围, 不校验 null 值
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
 * @since 2020.12.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validateBy = {
    RangeValidatorForByte.class,
    RangeValidatorForLong.class,
    RangeValidatorForShort.class,
    RangeValidatorForFloat.class,
    RangeValidatorForDouble.class,
    RangeValidatorForInteger.class,
    RangeValidatorForBigDecimal.class
})
public @interface Range {

  /**
   * @return 最小值
   */
  long min() default Long.MIN_VALUE;

  /**
   * @return 最大值
   */
  long max() default Long.MAX_VALUE;

  /**
   * @return 异常信息
   */
  String message();

}
