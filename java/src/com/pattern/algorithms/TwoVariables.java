package com.pattern.algorithms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface TwoVariables {
    String desc() default "双变量，避免正交，夹挤出一个小范围";

    String[] problems() default {
            "318. Maximum Product of Word Lengths"
    };
}
