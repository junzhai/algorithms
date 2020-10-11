package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface QuickSortSelect {
    String desc() default "Derived from quick sort. Pivoting/partition process is the key." +
            "通常成为一种分治方法";

    String[] problems() default {
            "973. K Closest Points to Origin",
            "502. IPO (Take advantage of pivoting/partition)",
            "1044. Longest Duplicate Substring"
    };
}
