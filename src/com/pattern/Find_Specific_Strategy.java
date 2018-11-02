package com.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface Find_Specific_Strategy {
    String desc() default "寻找一种具体方案";

    String[] problems() default {
            "621. Task Scheduler",
            "765. Couples Holding Hands"
    };
}
