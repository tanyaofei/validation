package com.github.tanyaofei.validation.core.annotation;

import com.github.tanyaofei.validation.core.validator.AbstractValidator;
import com.github.tanyaofei.validation.core.validator.CommonValidator;

import java.lang.annotation.*;

/**
 * <ul>
 *   <li>在方法上： 校验入口, 将会进行 AOP 校验</li>
 *   <li>在方法参数上：将会对此参数对象进行校验</li>
 *   <li>在对象字段上： 标识该字段是一个对象或对象集合并将进行递归校验, 支持集合逐个元素校验</li>
 * </ul>
 *
 * @author tanyaofei
 * @since 2021.08.0
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
public @interface Valid {

  /**
   * @return 指定的校验器
   */
  Class<? extends AbstractValidator> validateBy() default CommonValidator.class;

}
