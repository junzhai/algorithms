package com.pattern.algorithms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface Heap {
    String desc() default "Using heap to maintain K largest incoming elements";

    String[] problems() default {
            "215",
            "502. IPO",
            "871. Minimum Number of Refueling Stops",
            "1094. Car Pooling",
            "391. Perfect Rectangle"
    };
}
