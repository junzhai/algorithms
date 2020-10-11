package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface CuckooHashIdea {
    public String desc() default "用类似Cuckoo Hash的思想，一个元素挤出下一个元素。";

    public String[] problems() default {
            "442. Find All Duplicates in an Array",
            "41. First Missing Positive"
    };
}
