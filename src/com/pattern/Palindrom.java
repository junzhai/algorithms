package com.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface Palindrom {
    String desc() default "处理Palindrom的一般方法";

    String[] problems() default {
            "730. Count Different Palindromic Subsequences",
    };
}
