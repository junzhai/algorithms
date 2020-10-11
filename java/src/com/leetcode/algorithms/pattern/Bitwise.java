package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface Bitwise {
    String desc() default "bitwise operation, Java use 2's complement to represent negative number.";

    String[] problems() default {
            "854. K-Similar Strings",
            "1177. Can Make Palindrome from Substring",
            "433. Minimum Genetic Mutation",
            "421. Maximum XOR of Two Numbers in an Array",
            "1009. Complement of Base 10 Integer"
    };
}
