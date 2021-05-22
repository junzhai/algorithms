package com.pattern.algorithms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface DFS {
    String desc() default "树或图的深度优先搜索，并记录结果（动态规划），停机条件可以有变化。";

    String[] problems() default {
            "785. Is Graph Bipartite?",
            "22. Generate Parentheses",
            "140. Word Break II",
            "695. Max Area of Island",
            "797. All Paths From Source to Target",
            "968. Binary Tree Cameras",
            "464. Can I Win",
            "1192. Critical Connections in a Network（环，可用边或顶点作为停机条件）",
            "741. Cherry Pickup（状态设定有技巧）",
            "79. Word Search",
            "133. Clone Graph",
            "417. Pacific Atlantic Water Flow",
            "329. Longest Increasing Path in a Matrix"
    };
}
