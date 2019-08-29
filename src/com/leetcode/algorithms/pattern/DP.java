package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface DP {
    public String desc() default "不同形态的动态规划（迭代），不能发散。"
            + "迭代过程中注意收集多种信息。"
            + "动态规划的核心是对中间状态的分类";

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
            "920. Number of Music Playlists",
            "410. Split Array Largest Sum",
            "940. Distinct Subsequences II",
            "514. Freedom Trail",
            "132. Palindrome Partitioning II",
            "983. Minimum Cost For Tickets",
            "808. Soup Servings",
            "446. Arithmetic Slices II - Subsequence",
            "718. Maximum Length of Repeated Subarray",
            "45. Jump Game II",
            "712. Minimum ASCII Delete Sum for Two Strings",
            "818. Race Car (Convolution, 回旋)",
            "435. Non-overlapping Intervals",
            "854. K-Similar Strings (路径不明的动态规划, similar to 943)",
            "740. Delete and Earn",
            "943. Find the Shortest Superstring (路径不明的动态规划, similar to 854)",
            "847. Shortest Path Visiting All Nodes (规划路径是树或图的后根遍历)",
            "713. Subarray Product Less Than K",
            "956. Tallest Billboard (动态规划的核心是对中间状态的分类)",
            "416. Partition Equal Subset Sum",
            "1039. Minimum Score Triangulation of Polygon",
            "926. Flip String to Monotone Increasing",
            "673. Number of Longest Increasing Subsequence",
            "992. Subarrays with K Different Integers",
            "53. Maximum Subarray",
            "837. New 21 Game",
            "1105. Filling Bookcase Shelves (动态规划隐含一种穷举)",
            "813. Largest Sum of Averages",
            "647. Palindromic Substrings",
            "139. Word Break",
            "91. Decode Ways"
    };
}
