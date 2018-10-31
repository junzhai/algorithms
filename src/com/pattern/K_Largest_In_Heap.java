package com.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface K_Largest_In_Heap {
    String desc() default "Using heap to maintain K largest incoming elements";

    int[] problems() default {
            215
    };
}
