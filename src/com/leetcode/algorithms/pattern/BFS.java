package com.leetcode.algorithms.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface BFS {
    String desc() default "广度优先搜索，使用 1/2 queue";

    String[] problems() default {
            "785. Is Graph Bipartite?",
            "773. Sliding Puzzle",
            "864. Shortest Path to Get All Keys（搜索重入的比较标准有讲究：位置加持有的钥匙）"
    };
}
