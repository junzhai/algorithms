package com.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface DP {
    String desc() default "不同形态的动态规划（迭代），不能发散";

    String[] problems() default {
            "913",
            "312",
            "115",
            "124",
            "338. Counting Bits （主动扩散）",
            "549. Binary Tree Longest Consecutive Sequence II （树的父子迭代）",
            "903. Valid Permutations for DI Sequence （迭代并限制发散）",
            "730. Count Different Palindromic Subsequences  （Histogram 且迭代）",
    };
}
