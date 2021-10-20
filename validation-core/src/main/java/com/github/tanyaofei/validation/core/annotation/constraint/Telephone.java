package com.github.tanyaofei.validation.core.annotation.constraint;


import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.telephone.TelephoneStrategy;
import com.github.tanyaofei.validation.core.validator.telephone.TelephoneValidatorForString;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验字符串为手机号码格式
 * <p>支持类型: {@link String}</p>
 *
 * @author 谭耀飞
 * @since 2020.12.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validateBy = {
    TelephoneValidatorForString.class
})
public @interface Telephone {

  /**
   * @return 异常信息
   */
  String message() default "";

  /**
   * @return 校验策略, 默认中国号码严格模式
   */
  TelephoneStrategy strategy() default TelephoneStrategy.CHINA_STRICT;

}
