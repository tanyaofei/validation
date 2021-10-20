package com.github.tanyaofei.validation.core.validator.telephone;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Telephone;

import java.util.regex.Pattern;

/**
 * @author 谭耀飞
 * @since 2020.12.0
 */
@ValidateSupport(String.class)
public class TelephoneValidatorForString extends AbstractTelephoneValidator<String> {

  /**
   * 中国手机号码严格模式
   */
  private static final Pattern CN_STRICT_PATTERN = Pattern.compile(
      "^(?:(?:\\+|00)86)?1(?:(?:3[\\d])|4[5-7|9]|(?:5[0-3|5-9])|(?:6[5-7])|(?:7[0-8])|(?:8[\\d])|(?:9[1|8|9]))\\d{8}$");

  /**
   * 中国手机号码非严格模式
   */
  private static final Pattern CN_LOOSE_PATTERN = Pattern.compile("^(?:(?:\\+|00)86)?1\\d{10}$");

  @Override
  boolean compare(Telephone telephone, String value) {
    switch (telephone.strategy()) {
      case CHINA_STRICT:
        return CN_STRICT_PATTERN.matcher(value).matches();
      case CHINA_LOOSE:
        return CN_LOOSE_PATTERN.matcher(value).matches();
    }

    // never happen
    throw new IllegalArgumentException("Unsupport telephone strategy: " + telephone.strategy());
  }

}
