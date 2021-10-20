package com.github.tanyaofei.validation.core.annotation.constraint;

import com.github.tanyaofei.validation.core.annotation.Constraint;
import com.github.tanyaofei.validation.core.validator.decimalmin.DecimalMinValidatorForBigDecimal;
import com.github.tanyaofei.validation.core.validator.decimalmin.DecimalMinValidatorForDouble;
import com.github.tanyaofei.validation.core.validator.decimalmin.DecimalMinValidatorForFloat;

import java.lang.annotation.*;

/**
 * 校验浮点数值的最小值, 不校验 null 值<br/><br/>
 * <p>此校验注解与 {@link com.github.tanyaofei.validation.core.annotation.constraint.Min} 不同的之处有以下:</p>
 * <table>
 *   <tr><th>功能</th><th>{@link DecimalMin}</th>  <th>{@link com.github.tanyaofei.validation.core.annotation.constraint.Min}</th></tr>
 *   <tr><td>支持类型</td><td>支持{@link Float}, {@link Double}, {@link java.math.BigDecimal}</td> <td>支持{@link Integer}, {@link Long}, {@link Byte}, {@link Short}, {@link Float}, {@link Double}, {@link java.math.BigDecimal}</td></tr>
 *    <tr><td>指定值</td><td>允许指定浮点数的最小值, 如 @DecimalMin(value="1.2")</td><td>仅可以指定整型值的最小值, 如 @Min(value=1)</td></tr>
 * </table>
 *  @author 谭耀飞
 *  @since 2020.12.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validateBy = {
    DecimalMinValidatorForFloat.class,
    DecimalMinValidatorForDouble.class,
    DecimalMinValidatorForBigDecimal.class
})
public @interface DecimalMin {

  /**
   * @return 最小值, 值可以大于等于这个值
   */
  String value();

  /**
   * @return 异常信息
   */
  String message() default "";


}
