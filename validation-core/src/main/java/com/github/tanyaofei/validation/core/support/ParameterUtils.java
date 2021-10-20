package com.github.tanyaofei.validation.core.support;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author 谭耀飞
 * @since 2021.02.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ParameterUtils {

  public static final Set<Class<?>> BASIC_CLASSES = new HashSet<>();

  static {
    BASIC_CLASSES.add(Short.class);
    BASIC_CLASSES.add(Byte.class);
    BASIC_CLASSES.add(Integer.class);
    BASIC_CLASSES.add(Long.class);
    BASIC_CLASSES.add(Float.class);
    BASIC_CLASSES.add(Double.class);
    BASIC_CLASSES.add(String.class);
    BASIC_CLASSES.add(BigDecimal.class);
    BASIC_CLASSES.add(BigInteger.class);
    BASIC_CLASSES.add(LocalDate.class);
    BASIC_CLASSES.add(LocalTime.class);
    BASIC_CLASSES.add(LocalDateTime.class);
  }


  /**
   * 判断一个类是否基础类
   *
   * @param clazz 类
   * @return 一个类是否基础类
   */
  public static boolean isBasicClass(Class<?> clazz) {
    return BASIC_CLASSES.contains(clazz);
  }

  /**
   * 判断一个对象的类是否基础类
   *
   * @param target 对象
   * @return 该对象的类是否基础类
   */
  public static boolean isBasicObject(Object target) {
    return isBasicClass(target.getClass());
  }


}
