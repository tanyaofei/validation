package com.github.tanyaofei.validation.core.validator;

import org.springframework.lang.Nullable;

import java.lang.annotation.Annotation;
import java.lang.invoke.MethodType;

/**
 * 以字段为对象校验的校验器
 *
 * @author 谭耀飞
 * @since 2020.11.0
 */
public interface ConstraintValidator<A extends Annotation, T> {

  /**
   * isValid 方法的 MethodType, 用户方法句柄调用
   *
   * @see #isValid(Annotation, Object)
   */
  MethodType IS_VALID_METHOD_TYPE = MethodType.methodType(boolean.class, Annotation.class, Object.class);

  /**
   * isValid 方法的方法名称, 用户方法句柄调用
   *
   * @see #isValid(Annotation, Object)
   */
  String IS_VALID_METHOD_NAME = "isValid";

  /**
   * 判断是否合法
   *
   * @param a     约束注解
   * @param value 校验值
   * @return 是否合法
   */
  boolean isValid(A a, @Nullable T value);
}
