package com.github.tanyaofei.validation.core.annotation.constraint;


import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.negitave.NegativeOrZeroValidatorForBigDecimal;
import com.github.tanyaofei.validation.core.validator.negitave.NegativeOrZeroValidatorForByte;
import com.github.tanyaofei.validation.core.validator.negitave.NegativeOrZeroValidatorForDouble;
import com.github.tanyaofei.validation.core.validator.negitave.NegativeOrZeroValidatorForFloat;
import com.github.tanyaofei.validation.core.validator.negitave.NegativeOrZeroValidatorForInteger;
import com.github.tanyaofei.validation.core.validator.negitave.NegativeOrZeroValidatorForLong;
import com.github.tanyaofei.validation.core.validator.negitave.NegativeOrZeroValidatorForShort;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验值为负数或 0, 不校验 null 值
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
    NegativeOrZeroValidatorForByte.class,
    NegativeOrZeroValidatorForLong.class,
    NegativeOrZeroValidatorForFloat.class,
    NegativeOrZeroValidatorForShort.class,
    NegativeOrZeroValidatorForDouble.class,
    NegativeOrZeroValidatorForInteger.class,
    NegativeOrZeroValidatorForBigDecimal.class
})
public @interface NegativeOrZero {

  /**
   * @return 异常信息
   */
  String message() default "";

}
