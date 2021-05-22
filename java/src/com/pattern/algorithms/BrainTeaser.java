package com.pattern.algorithms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface BrainTeaser {
    String desc() default "趣味题";

    String[] problems() default {
        "1041. Robot Bounded In Circle"
    };
}
