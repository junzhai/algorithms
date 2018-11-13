package com.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface DFS {
    String desc() default "深度优先搜索";

    String[] problems() default {
            "785. Is Graph Bipartite?",
    };
}
