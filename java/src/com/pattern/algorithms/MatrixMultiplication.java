package com.pattern.algorithms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface MatrixMultiplication {
    String desc() default "矩阵乘法";

    String[] problems() default {
            "924. Minimize Malware Spread （矩阵乘法计算图中顶点的连通性）"
    };
}
