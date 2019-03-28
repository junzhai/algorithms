package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface DP {
    public String desc() default "不同形态的动态规划（迭代），不能发散。迭代过程中注意收集多种信息。";

    public String[] problems() default {
            "913",
            "312",
            "115",
            "124",
            "338. Counting Bits （主动扩散）",
            "549. Binary Tree Longest Consecutive Sequence II （树的父子迭代）",
            "903. Valid Permutations for DI Sequence （迭代并限制发散）",
            "730. Count Different Palindromic Subsequences  （Histogram 且迭代）",
            "62. Unique Paths",
            "542. 01 Matrix",
            "756. Pyramid Transition Matrix",
            "309. Best Time to Buy and Sell Stock with Cooldown",
            "375. Guess Number Higher or Lower II",
            "790. Domino and Tromino Tiling",
            "486. Predict the Winner",
            "873. Length of Longest Fibonacci Subsequence",
            "920. Number of Music Playlists"
    };
}
