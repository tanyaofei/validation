package com.github.tanyaofei.validation.core.annotation.constraint;


import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.positive.PositiveValidatorForBigDecimal;
import com.github.tanyaofei.validation.core.validator.positive.PositiveValidatorForByte;
import com.github.tanyaofei.validation.core.validator.positive.PositiveValidatorForDouble;
import com.github.tanyaofei.validation.core.validator.positive.PositiveValidatorForFloat;
import com.github.tanyaofei.validation.core.validator.positive.PositiveValidatorForInteger;
import com.github.tanyaofei.validation.core.validator.positive.PositiveValidatorForLong;
import com.github.tanyaofei.validation.core.validator.positive.PositiveValidatorForShort;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验值为正数, 不校验 null 值
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
    PositiveValidatorForLong.class,
    PositiveValidatorForByte.class,
    PositiveValidatorForShort.class,
    PositiveValidatorForFloat.class,
    PositiveValidatorForDouble.class,
    PositiveValidatorForInteger.class,
    PositiveValidatorForBigDecimal.class
})
public @interface Positive {

  /**
   * @return 异常信息
   */
  String message();

}
