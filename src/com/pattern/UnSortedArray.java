package com.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface UnSortedArray {
    String desc() default "顺序处理每一个值。新值驱动一个动作";

    String[] problems() default {
            "761 小的新值抹去大的旧值，对抹去的旧值进行不同的处理",
            "315. Count of Smaller Numbers After Self",
            "42. Trapping Rain Water",
            "218. The Skyline Problem",
    };
}
