package com.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface FindUnion {
    String desc() default "Find Union";

    String[] problems() default {
            "839. Similar String Groups"
    };
}
