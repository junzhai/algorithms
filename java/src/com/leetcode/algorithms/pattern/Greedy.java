package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface Greedy {
    String desc() default "贪心算法是一种思想";

    String[] problems() default {
            "316. Remove Duplicate Letters (find minimum character from left)"
    };
}
