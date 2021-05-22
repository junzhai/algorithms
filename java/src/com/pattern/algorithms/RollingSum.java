package com.pattern.algorithms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface RollingSum {
    String desc() default "Rolling sum 的特性";

    String[] problems() default {
            "134. Gas Station（保持正向rolling sum大于0，相当于寻找最大反向rolling sum值）",
            "1074. Number of Submatrices That Sum to Target"
    };
}
