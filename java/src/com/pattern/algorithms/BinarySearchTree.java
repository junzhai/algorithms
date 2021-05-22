package com.pattern.algorithms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface BinarySearchTree {
    String desc() default "binary search tree, red black tree, AVL, TreeMap." +
            "树的节点可以是一个值，一个区间，一块区域";

    String[] problems() default {
            "699. Falling Squares",
            "327. Count of Range Sum",
            "1044. Longest Duplicate Substring"
    };
}
