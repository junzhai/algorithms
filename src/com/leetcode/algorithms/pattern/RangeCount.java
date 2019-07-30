package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface RangeCount {
    String desc() default "Range/interval start/end point count";

    String[] problems() default {
            "798. Smallest Rotation with Highest Score"
    };
}
