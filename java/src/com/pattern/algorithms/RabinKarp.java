package com.pattern.algorithms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface RabinKarp {
    String desc() default "String matching algorithm";

    String[] problems() default {
        "1044. Longest Duplicate Substring"
    };
}
