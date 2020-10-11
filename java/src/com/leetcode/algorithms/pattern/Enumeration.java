package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface Enumeration {
    public String desc() default "遍历所有可能，不记录任何中间结果。有时可能更快。";

    public String[] problems() default {
            "873. Length of Longest Fibonacci Subsequence",
            "18. Four Sum"
    };
}
