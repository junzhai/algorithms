package com.pattern.algorithms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Retention(RUNTIME)
@Target({TYPE, METHOD})
public @interface TreeSet {
    String desc() default "";

    String[] problems() default {
            "2612. Minimum Reverse Operations (精细优化的BFS)"
    };
}
