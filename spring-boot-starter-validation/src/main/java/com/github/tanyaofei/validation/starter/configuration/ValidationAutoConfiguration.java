package com.github.tanyaofei.validation.starter.configuration;

import com.github.tanyaofei.validation.core.ConstraintValidationAspect;
import com.github.tanyaofei.validation.core.ConstraintValidatorMapper;
import com.github.tanyaofei.validation.core.LazyConstraintValidatorMapper;
import com.github.tanyaofei.validation.core.validator.CommonValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 谭耀飞
 * @since 2021.04.0
 */
@Configuration
public class ValidationAutoConfiguration {

  @Bean
  public ConstraintValidatorMapper constraintValidatorMapper() {
    return new LazyConstraintValidatorMapper();
  }

  @Bean
  public CommonValidator commonValidator() {
    return new CommonValidator();
  }

  @Bean
  public ConstraintValidationAspect constraintValidationAspect(ApplicationContext applicationContext) {
    return new ConstraintValidationAspect(applicationContext);
  }

}
