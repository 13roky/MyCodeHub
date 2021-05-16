package com.broky.EnumClass;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author 13roky
 * @date 2021-05-14 8:36
 */

@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.SOURCE)
@Target({FIELD, METHOD, TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotation {
    String value() default "test";
}
