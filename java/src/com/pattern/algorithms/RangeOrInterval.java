package com.pattern.algorithms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface RangeOrInterval {
    String desc() default "Range/interval start/end point count, accumulate max range/interval ends...";

    String[] problems() default {
            "798. Smallest Rotation with Highest Score",
            "1288. Remove Covered Intervals (accumulate max range end)"
    };
}
