package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface DivideAndConquer {
    public String desc() default "分治，常有划分方法：二分，Quick Sort pivoting, ....";

    public String[] problems() default {
            "53. Maximum Subarray",
            "327. Count of Range Sum",
            "1044. Longest Duplicate Substring",
            "493. Reverse Pairs"
    };
}
