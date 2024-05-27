package com.pattern.algorithms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface KMP {
    String desc() default "String KMP 算法, 最长 prefix == suffix in String pattern";

    String[] problems() default {
            "28",
            "44. Wildcard Matching. (KMP with variations)",
            "936. Stamping The Sequence",
            "HackerRank: The Grid Search"
    };
}
