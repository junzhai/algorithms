package com.pattern.algorithms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface ExponentialSpeed {
    String desc() default "Try to do something in exponential speed";

    String[] problems() default {
            "sonatus_2021"
    };
}
