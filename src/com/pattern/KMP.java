package com.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface KMP {
    String desc() default "String KMP 算法, 最长 prefix == suffix in String pattern";

    int[] problems() default {
            28
    };
}
