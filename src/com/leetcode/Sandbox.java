package com.leetcode;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Sandbox {
    public int numSimilarGroups(String[] A) {
        boolean[] v = new boolean[A.length];
        Queue<String> q = new LinkedList<>();
        int ret = 0;
        for (int i = 0; i < A.length; i++) {
            if (!v[i]) {
                ret += 1;
                q.offer(A[i]);
                v[i] = true;
                while (!q.isEmpty()) {
                    String s = q.poll();
                    for (int j = 0; j < A.length; j++) {
                        if (!v[j] && check(s, A[j])) {
                            q.offer(A[j]);
                            v[j] = true;
                        }
                    }
                }
            }
        }
        return ret;
    }

    public int numSimilarGroups2(String[] A) {
        int[] union = new int[A.length];
        Arrays.fill(union, -1);
        int ret = A.length;

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int p = i, p1 = j;
                while (union[p] != -1) {
                    p = union[p];
                }
                while (union[p1] != -1) {
                    p1 = union[p1];
                }

                if (p1 == p) {
                    continue;
                }

                if (check(A[i], A[j])) {
                    if (p > p1) {
                        union[p] = p1;
                        ret -= 1;
                    } else if (p < p1) {
                        union[p1] = p;
                        ret -= 1;
                    }
                }
            }
        }
        return ret;
    }

    private boolean check(String a, String b) {
        int diff = 0;
        for (int k = 0; k < a.length(); k++) {
            if (a.charAt(k) != b.charAt(k)) {
                diff += 1;
            }
        }

        return diff == 2 || diff == 0;
    }

    public int numSimilarGroups1(String[] A) {
        int[] union = new int[A.length];
        Arrays.fill(union, -1);

        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            m.put(A[i], i);
        }
        int ret = m.size();

        for (String key : m.keySet()) {
            int p = m.get(key);
            char[] arr = key.toCharArray();
            for (int j = 0; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    char t = arr[j];
                    arr[j] = arr[k];
                    arr[k] = t;
                    String ns = String.valueOf(arr);
                    if (m.containsKey(ns)) {
                        int p1 = m.get(ns);
                        while (union[p] != -1) {
                            p = union[p];
                        }
                        while (union[p1] != -1) {
                            p1 = union[p1];
                        }

                        if (p > p1) {
                            union[p] = p1;
                            ret -= 1;
                        } else if (p < p1) {
                            union[p1] = p;
                            ret -= 1;
                        }
                    }
                    t = arr[j];
                    arr[j] = arr[k];
                    arr[k] = t;
                }
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        Sandbox s = new Sandbox();
        int ret;

        ret = s.numSimilarGroups(new String[]{"aa", "aa", "aa"});
        Assert.assertEquals(1, ret);

        ret = s.numSimilarGroups(new String[]{"tars", "rats", "arts", "star"});
        Assert.assertEquals(2, ret);

    }
}