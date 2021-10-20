package com.github.tanyaofei.validation.core.validator.telephone;

/**
 * @author 谭耀飞
 * @since 2021.06.0
 */
public enum TelephoneStrategy {

  /**
   * 中国区号码严格模式, 严格模式下非民众手机号(如 12, 13, 167 开头的服务号)不通过校验
   */
  CHINA_STRICT,

  /**
   * 中国区号码非严格模式, 只要是符合手机号码的长度即可
   */
  CHINA_LOOSE

}
