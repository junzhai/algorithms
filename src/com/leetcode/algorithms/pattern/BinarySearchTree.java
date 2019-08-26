package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface BinarySearchTree {
    String desc() default "binary search tree, red black tree, AVL, TreeMap";

    String[] problems() default {
            "699. Falling Squares",
            "327. Count of Range Sum"
    };
}
