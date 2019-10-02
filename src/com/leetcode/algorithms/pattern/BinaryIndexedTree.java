package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface BinaryIndexedTree {
    String desc() default "Fenwick Tree, Partial Sum Tree, 1D, 2D, ...";

    String[] problems() default {
            "308. Range Sum Query 2D - Mutable",
            "611. Valid Triangle Number",
            "327. Count of Range Sum",
            "1172. Dinner Plate Stacks",
            "493. Reverse Pairs",
            "1169. Invalid Transactions"
    };
}
