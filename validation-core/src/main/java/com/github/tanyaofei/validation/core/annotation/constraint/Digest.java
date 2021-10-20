package com.github.tanyaofei.validation.core.annotation.constraint;

import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.digest.DigestValidatorForBigDecimal;

import java.lang.annotation.*;

/**
 * 校验 {@code BigDecimal} 小数位数最多多少位
 *
 * @author 谭耀飞
 * @since 2021.03.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validateBy = DigestValidatorForBigDecimal.class)
public @interface Digest {

  /**
   * @return 最多多少位小数
   */
  int value();

  /**
   * @return 异常信息
   */
  String message() default "";

}
