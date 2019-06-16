package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface SlidingWindow {
    String desc() default "滑动窗口，多种方法计算滑动窗口的变化。";

    String[] problems() default {
            "904. Fruit Into Baskets",
            "209. Minimum Size Subarray Sum",
            "1052. Grumpy Bookstore Owner",
            "713. Subarray Product Less Than K (滑动窗口本质上可能就是一种动态规划)"
    };
}
