package com.broky.EnumClass;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

/**
 * @author 13roky
 * @date 2021-05-14 9:43
 */
@Retention(RetentionPolicy.SOURCE)
@Target({FIELD, METHOD})
public @interface MyAnnotations {
    MyAnnotation[] value();
}
