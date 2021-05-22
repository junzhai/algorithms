package com.pattern.algorithms;

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
            "864. Shortest Path to Get All Keys（搜索重入的比较标准有讲究：位置加持有的钥匙）",
            "1210. Minimum Moves to Reach Target with Rotations（索重入的比较标准有讲究：蛇头位置加方向）",
            "97. Interleaving String",
            "934. Shortest Bridge",
            "871. Minimum Number of Refueliøng Stops",
            "1125. Smallest Sufficient Team",
            "1091. Shortest Path in Binary Matrix",
            "433. Minimum Genetic Mutation",
            "576. Out of Boundary Paths",
            "787. Cheapest Flights Within K Stops",
            "127. Word Ladder",
            "45. Jump Game II"
    };
}
