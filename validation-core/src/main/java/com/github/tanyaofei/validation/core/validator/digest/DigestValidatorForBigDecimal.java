package com.github.tanyaofei.validation.core.validator.digest;

import com.github.tanyaofei.validation.core.annotation.ValidateSupport;
import com.github.tanyaofei.validation.core.annotation.constraint.Digest;

import java.math.BigDecimal;

/**
 * @author 谭耀飞
 * @since 2021.03.0
 */
@ValidateSupport(BigDecimal.class)
public class DigestValidatorForBigDecimal extends AbstractDigestValidator<BigDecimal> {

  @Override
  boolean compare(Digest digest, BigDecimal value) {
    return value.scale() <= digest.value();
  }

}
