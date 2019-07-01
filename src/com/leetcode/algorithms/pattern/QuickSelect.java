package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface QuickSelect {
    String desc() default "Derived from quick sort. Pivoting/partition process is the key.";

    String[] problems() default {
            "973. K Closest Points to Origin",
    };
}
