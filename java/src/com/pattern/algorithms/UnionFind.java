package com.pattern.algorithms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface UnionFind {
    String desc() default "Union Find, 有不同形态";

    String[] problems() default {
            "839. Similar String Groups",
            "924. Minimize Malware Spread",
            "547. Friend Circles",
            "947. Most Stones Removed with Same Row or Column",
            "695. Max Area of Island",
            "959. Regions Cut By Slashes",
            "1202. Smallest String With Swaps",
            "886. Possible Bipartition",
            "399. Evaluate Division"
    };
}
