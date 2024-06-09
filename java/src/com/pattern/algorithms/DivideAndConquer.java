package com.pattern.algorithms;

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
            "493. Reverse Pairs",
            "152. Maximum Product Subarray",
            "395. Longest Substring with At Least K Repeating Characters",
            "442. Find All Duplicates in an Array（非最优解法）",
            "1074. Number of Submatrices That Sum to Target",
            "codewars - Closest pair of points in linearithmic time"
    };
}
