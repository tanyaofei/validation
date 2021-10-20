package com.github.tanyaofei.validation.core.annotation.constraint;


import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.positive.PositiveOrZeroValidatorForBigDecimal;
import com.github.tanyaofei.validation.core.validator.positive.PositiveOrZeroValidatorForByte;
import com.github.tanyaofei.validation.core.validator.positive.PositiveOrZeroValidatorForDouble;
import com.github.tanyaofei.validation.core.validator.positive.PositiveOrZeroValidatorForFloat;
import com.github.tanyaofei.validation.core.validator.positive.PositiveOrZeroValidatorForInteger;
import com.github.tanyaofei.validation.core.validator.positive.PositiveOrZeroValidatorForLong;
import com.github.tanyaofei.validation.core.validator.positive.PositiveOrZeroValidatorForShort;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验值为正数或 0, 不校验 null 值
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
    PositiveOrZeroValidatorForLong.class,
    PositiveOrZeroValidatorForByte.class,
    PositiveOrZeroValidatorForShort.class,
    PositiveOrZeroValidatorForFloat.class,
    PositiveOrZeroValidatorForDouble.class,
    PositiveOrZeroValidatorForInteger.class,
    PositiveOrZeroValidatorForBigDecimal.class
})
public @interface PositiveOrZero {

  /**
   * @return 异常信息
   */
  String message();

}
