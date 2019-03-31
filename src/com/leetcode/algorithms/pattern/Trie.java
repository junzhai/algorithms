package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface Trie {
    String desc() default "Trie/Suffix tree,插入变种字串";

    String[] problems() default {
            "982. Triples with Bitwise AND Equal To Zero",
            "745. Prefix and Suffix Search （插入变种字串，'二维Trie树'）"
    };
}