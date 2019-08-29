package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface MinMaxHeap {
    String desc() default "Using heap to maintain K largest incoming elements";

    String[] problems() default {
            "215",
            "502. IPO"
    };
}
