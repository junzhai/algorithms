package com.pattern.algorithms;

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
            "713. Subarray Product Less Than K (滑动窗口本质上可能就是一种动态规划)",
            "992. Subarrays with K Different Integers",
            "1695. Maximum Erasure Value",
            "1004. Max Consecutive Ones III (本质上就是动态规划)"
    };
}
