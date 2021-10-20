package com.github.tanyaofei.validation.core.annotation.constraint;


import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.repeat.NotRepeatValidatorForArray;
import com.github.tanyaofei.validation.core.validator.repeat.NotRepeatValidatorForList;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验列表里的元素不能有重复
 * <p>
 * 支持类型: {@link java.util.List} {@link Object[]}
 * </p>
 *
 * @author 谭耀飞
 * @since 2020.12.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validateBy = {
    NotRepeatValidatorForList.class,
    NotRepeatValidatorForArray.class
})
public @interface NotRepeat {

}
