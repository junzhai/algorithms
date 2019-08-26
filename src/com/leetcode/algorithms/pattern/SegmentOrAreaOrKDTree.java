package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface SegmentOrAreaOrKDTree {
    String desc() default "1D, 2D, ... Tree node can hold different segment or area infomation." +
            "本质上是一种特殊的二分查找树";

    String[] problems() default {
            "308. Range Sum Query 2D - Mutable",
            "850. Rectangle Area II（父子节点区域不相交，更像二维的二叉查找树）",
            "327. Count of Range Sum（父节点区间或区域覆盖子节点）"
    };
}
