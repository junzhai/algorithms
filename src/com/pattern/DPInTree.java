package com.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface DPInTree {
    String desc() default "树中的动态规划";

    String[] problems() default {
            "742. Closest Leaf in a Binary Tree",
    };
}
