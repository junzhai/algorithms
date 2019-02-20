package com.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface BinaryIndexedTree {
    String desc() default "1D, 2D, ...";

    String[] problems() default {
            "308. Range Sum Query 2D - Mutable",
    };
}
