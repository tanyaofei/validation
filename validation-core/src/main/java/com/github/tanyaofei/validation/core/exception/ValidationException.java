package com.github.tanyaofei.validation.core.exception;

import lombok.Getter;
import lombok.ToString;

/**
 * 校验异常对象
 *
 * @author 谭耀飞
 * @since 2021.04.0
 **/

@Getter
@ToString
public class ValidationException extends RuntimeException {

  public ValidationException(String msg) {
    super(msg);
  }

  /**
   * 校验异常不需要爬栈
   *
   * @return this
   */
  @Override
  public synchronized Throwable fillInStackTrace() {
    return this;
  }

}
