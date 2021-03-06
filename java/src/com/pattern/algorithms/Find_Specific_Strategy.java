package com.pattern.algorithms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface Find_Specific_Strategy {
    String desc() default "寻找一种具体方案，并证明";

    String[] problems() default {
            "621. Task Scheduler",
            "765. Couples Holding Hands",
            "630. Course Schedule III",
            "753. Cracking the Safe",
            "1338. Reduce Array Size to The Half",
            "767. Reorganize String",
            "406. Queue Reconstruction by Height",
            "667. Beautiful Arrangement II"
    };
}
