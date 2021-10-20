package com.github.tanyaofei.validation.core.annotation.constraint;


import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.negitave.NegativeValidatorForBigDecimal;
import com.github.tanyaofei.validation.core.validator.negitave.NegativeValidatorForByte;
import com.github.tanyaofei.validation.core.validator.negitave.NegativeValidatorForDouble;
import com.github.tanyaofei.validation.core.validator.negitave.NegativeValidatorForFloat;
import com.github.tanyaofei.validation.core.validator.negitave.NegativeValidatorForInteger;
import com.github.tanyaofei.validation.core.validator.negitave.NegativeValidatorForLong;
import com.github.tanyaofei.validation.core.validator.negitave.NegativeValidatorForShort;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验值为负数, 不校验 null 值
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
    NegativeValidatorForByte.class,
    NegativeValidatorForLong.class,
    NegativeValidatorForShort.class,
    NegativeValidatorForFloat.class,
    NegativeValidatorForDouble.class,
    NegativeValidatorForInteger.class,
    NegativeValidatorForBigDecimal.class
})
public @interface Negative {

  /**
   * @return 异常信息
   */
  String message();

}
