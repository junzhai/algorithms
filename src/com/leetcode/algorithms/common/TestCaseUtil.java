package com.leetcode.algorithms.common;

import java.util.Random;

public class TestCaseUtil {
    private static final Random r = new Random();

    public static String randomString(int charCount, int len) {
        char[] buf = new char[len];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = (char) ('a' + r.nextInt(charCount));
        }
        return String.valueOf(buf);
    }
}
