package com.github.tanyaofei.validation.core.support;

import java.lang.annotation.Annotation;

import com.github.tanyaofei.validation.core.annotation.Constraint;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author 谭耀飞
 * @since 2021.05.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstraintUtils {

  /**
   * 判断一个注解是否约束注解
   *
   * @param annotation 注解
   * @return 是否约束注解
   */
  public static boolean isConstraint(Annotation annotation) {
    return annotation.annotationType().isAnnotationPresent(Constraint.class);
  }

}
