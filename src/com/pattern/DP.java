package com.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface DP {
    String desc() default "不同形态的动态规划（迭代）";

    int[] problems() default {
            913,
            312,
            115,
            124
    };
}
