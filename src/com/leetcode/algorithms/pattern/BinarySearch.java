package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface BinarySearch {
    String desc() default "binary search, change search target, doing multiple searches";

    String[] problems() default {
            "719. Find K-th Smallest Pair Distance",
            "1011. Capacity To Ship Packages Within D Days"
    };
}
