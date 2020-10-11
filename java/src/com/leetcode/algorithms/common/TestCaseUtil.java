package com.leetcode.algorithms.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public static List<List<String>> array2List(String[][] input) {
        List<List<String>> ret = new ArrayList<>();
        for (String[] i : input) {
            ret.add(Arrays.asList(i));
        }
        return ret;
    }

    public static <T> List<List<T>> array2List(T[][] input) {
        List<List<T>> ret = new ArrayList<>();
        for (T[] i : input) {
            ret.add(Arrays.asList(i));
        }
        return ret;
    }
}
