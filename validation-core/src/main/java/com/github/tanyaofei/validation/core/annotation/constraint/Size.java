package com.github.tanyaofei.validation.core.annotation.constraint;


import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.size.SizeListValidatorForArray;
import com.github.tanyaofei.validation.core.validator.size.SizeListValidatorForCollection;
import com.github.tanyaofei.validation.core.validator.size.SizeValidatorForArray;
import com.github.tanyaofei.validation.core.validator.size.SizeValidatorForCollection;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验集合元素数量, 不校验 null 值
 * <p>支持类型: {@link java.util.Collection}</p>
 *
 * @author 谭耀飞
 * @since 2020.11.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validateBy = {
    SizeValidatorForCollection.class,
    SizeValidatorForArray.class
})
@Repeatable(Size.List.class)
public @interface Size {

  /**
   * @return 最小数量
   */
  long min() default 0;

  /**
   * @return 最大数量
   */
  long max() default Long.MAX_VALUE;

  /**
   * @return 异常信息
   */
  String message() default "";

  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.FIELD, ElementType.PARAMETER})
  @Constraint(validateBy = {
      SizeListValidatorForCollection.class,
      SizeListValidatorForArray.class
  })
  @interface List {

    Size[] value();

  }


}
