package com.pattern.algorithms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface UnSortedArrayHistogram {
    String desc() default "顺序处理每一个值。新值驱动一个动作;"
            + "Scan ordered elements once, dealing with unordered associations.";

    String[] problems() default {
            "761 小的新值抹去大的旧值，对抹去的旧值进行不同的处理",
            "315. Count of Smaller Numbers After Self",
            "42. Trapping Rain Water",
            "218. The Skyline Problem",
            "962. Maximum Width Ramp",
            "402. Remove K Digits",
            "496. Next Greater Element I",
            "85",
            "730. Count Different Palindromic Subsequences",
            "84. Largest Rectangle in Histogram",
            "739. Daily Temperatures",
            "456. 132 Pattern",
            "1081. Smallest Subsequence of Distinct Characters",
            "901. Online Stock Span",
            "452. Minimum Number of Arrows to Burst Balloons",
            "354. Russian Doll Envelopes"
    };
}
