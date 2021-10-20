package com.github.tanyaofei.validation.core.annotation.constraint;

import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.integeric.IntValidatorForString;

import java.lang.annotation.*;

/**
 * 校验必须为可为负数的整型值
 * <p>该校验器用于支持某些情况下需要以 {@link String} 类型接收整形</p>
 *
 * @author 谭耀飞
 * @since 2021.06.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validateBy = {
    IntValidatorForString.class
})
public @interface Int {

}
