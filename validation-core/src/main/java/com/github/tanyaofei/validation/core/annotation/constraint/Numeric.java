package com.github.tanyaofei.validation.core.annotation.constraint;

import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.numeric.NumericValidatorForString;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验值为有效的数值, 包括正负数的整形(可包含小数)
 * <p>该校验用于某些情况下无法使用 {@link java.math.BigDecimal} 来接收值而需要校验为有效的数值</p>
 *
 * @author 谭耀飞
 * @see Int 如果仅校验数值为整数 {@link Integer} 可使用这个注解
 * @since 2021.06.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validateBy = {
    NumericValidatorForString.class,
})
public @interface Numeric {

}
