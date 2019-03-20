package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface Histogram {
    String desc() default "Scan ordered elements once, dealing with unordered associations.";

    String[] problems() default {
            "85",
            "730. Count Different Palindromic Subsequences",
    };
}
