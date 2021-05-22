package com.pattern.algorithms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface MorrisTraversal {
    String desc() default "穿线树遍历";

    String[] problems() default {
            "501. Find Mode in Binary Search Tree",
    };
}
