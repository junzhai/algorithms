package com.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface BackTracking {
    String desc() default "回溯，附加条件";

    String[] problems() default {
            "691. Stickers to Spell Word",
    };
}
