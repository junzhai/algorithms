package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface MergeSort {
    String desc() default "Divide then merge，是一种分治策略";

    String[] problems() default {
            "315. Count of Smaller Numbers After Self",
            "327. Count of Range Sum（利用归并过程做一些事情）"
    };
}
