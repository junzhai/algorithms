package com.leetcode.ooDesign.flipkartLogger;

public enum Level {
    DEBUG(0),
    INFO(1),
    WARN(2),
    ERROR(3),
    FATAL(4);

    int val;

    Level(int val) {
        this.val = val;
    }

    int value() {
        return val;
    }
}
