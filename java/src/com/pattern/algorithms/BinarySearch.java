package com.pattern.algorithms;

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
            "1011. Capacity To Ship Packages Within D Days",
            "1095. Find in Mountain Array (二分之后的动作多种多样)",
            "367. Valid Perfect Square",
            "378. Kth Smallest Element in a Sorted Matrix",
            "81. Search in Rotated Sorted Array II",
            "240. Search a 2D Matrix II",
            "875. Koko Eating Bananas",
            "441. Arranging Coinso",
            "483. Smallest Good Base",
            "668. Kth Smallest Number in Multiplication Table",
            "1201. Ugly Number III",
            "933. Number of Recent Calls",
            "74. Search a 2D Matrix",
            "754. Reach a Number"
    };
}
