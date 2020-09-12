package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface BackTracking {
    String desc() default "回溯，附加条件，进行各种优化";

    String[] problems() default {
            "691. Stickers to Spell Word",
            "474. Ones and Zeroes",
            "753. Cracking the Safe",
            "864. Shortest Path to Get All Keys",
            "488. Zuma Game",
            "306. Additive Number",
            "216. Combination Sum III (problem domain is small and DP is expensive)"
    };
}
