package com.pattern.algorithms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Retention(RUNTIME)
@Target({TYPE})
public @interface MatrixExponentiation {
    String desc() default "Matrix Exponentiation Method";

    String[] problems() default {
            "CodeWars: TheMillionthFibonacciKata"
    };
}
