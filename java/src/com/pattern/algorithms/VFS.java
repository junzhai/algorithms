package com.pattern.algorithms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface VFS {
    String desc() default "Value first search: （使用堆进行遍历）";

    String[] problems() default {
            "778. Swim in Rising Water",
    };
}
