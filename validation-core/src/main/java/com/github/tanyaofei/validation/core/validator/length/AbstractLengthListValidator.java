package com.github.tanyaofei.validation.core.validator.length;


import com.github.tanyaofei.validation.core.annotation.constraint.Length.List;
import com.github.tanyaofei.validation.core.validator.ConstraintValidator;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
public abstract class AbstractLengthListValidator<T> implements
    ConstraintValidator<List, T> {

  @Override
  final
  public boolean isValid(List list, T value) {
    return value == null || compare(list, value);
  }

  /**
   * 判断是否合法
   *
   * @param list  长度注解
   * @param value 校验值
   * @return 是否合法
   */
  abstract boolean compare(List list, T value);
}
