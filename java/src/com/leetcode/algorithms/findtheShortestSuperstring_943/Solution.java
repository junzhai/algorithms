package com.leetcode.algorithms.findtheShortestSuperstring_943;

import com.pattern.algorithms.DP;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

@DP
public class Solution {
    private static class Pair {
        int overlap;
        int[] path;

        Pair(int overlap, int[] path) {
            this.overlap = overlap;
            this.path = path;
        }
    }

    public String shortestSuperstring(String[] A) {
        int len = A.length, total = 0;
        char[][] a = new char[len][0];
        int[][] cv = new int[len][0], g = new int[len][len];
        for (int i = 0; i < len; i++) {
            a[i] = A[i].toCharArray();
            total += a[i].length;
            cv[i] = buildKMPcv(a[i]);
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    g[i][j] = findOverlap(a[i], a[j], cv[j]);
                }
            }
        }

        Map<Integer, Pair> maxOverlap = new HashMap<>();

        int key = (1 << len) - 1;
        Pair max = findMaxOverlap(maxOverlap, g, key);

        char[] ret = new char[total - max.overlap];
        int[] p = max.path;
        for (int i = 0, j = 0; i < p.length; i++) {
            char[] s = a[p[i]];
            System.arraycopy(s, 0, ret, j, s.length);
            j += s.length;
            if (i + 1 < p.length) {
                j -= g[p[i]][p[i + 1]];
            }
        }

        return new String(ret);
    }

    private int[] buildKMPcv(char[] a) {
        int len = a.length;
        int[] ret = new int[len];
        ret[0] = -1;
        for (int i = 1; i < len; i++) {
            int j = ret[i - 1];
            while (j >= 0 && a[j] != a[i - 1]) {
                j = ret[j];
            }
            ret[i] = j + 1;
        }
        return ret;
    }

    private int findOverlap(char[] a, char[] b, int[] cv) {
        int len = a.length, j = 0;
        for (int i = 0; i < len; i++) {
            if (a[i] == b[j]) {
                j += 1;
                continue;
            }
            j = cv[j];
            while (j >= 0 && a[i] != b[j]) {
                j = cv[j];
            }
            j += 1;
        }
        return j;
    }

    private Pair findMaxOverlap(Map<Integer, Pair> maxOverlap, int[][] g, int key) {
        if (maxOverlap.containsKey(key)) {
            return maxOverlap.get(key);
        }

        int len = g.length;
        Pair max = null;
        for (int i = 0, m = 1; i < len; i++, m <<= 1) {
            if ((key & m) > 0) {
                Pair v = findMaxOverlapFromString(maxOverlap, g, key - m, i, 0);
                if (max == null || v.overlap > max.overlap) {
                    max = v;
                }
            }
        }
        maxOverlap.put(key, max);
        return max;
    }

    private Pair findMaxOverlapFromString(Map<Integer, Pair> maxOverlap, int[][] g, int key, int index, int overlap) {
        if (key == 0) {
            return new Pair(overlap, new int[]{index});
        }

        int len = g.length;
        Pair max = null;
        for (int i = 0, m = 1; i < len; i++, m <<= 1) {
            if (g[index][i] > 0 && (key & m) > 0) {
                Pair v = findMaxOverlapFromString(maxOverlap, g, key - m, i, overlap + g[index][i]);
                if (max == null || v.overlap > max.overlap) {
                    max = v;
                }
            }
        }

        int v;
        if (max == null) {
            max = findMaxOverlap(maxOverlap, g, key);
            v = max.overlap + overlap;
        } else {
            v = max.overlap;
        }

        int[] p = max.path, np = new int[p.length + 1];
        np[0] = index;
        System.arraycopy(p, 0, np, 1, p.length);
        return new Pair(v, np);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ret;

        ret = s.shortestSuperstring(new String[]{"mah", "obr", "ahkh", "royy", "broy"});
        Assert.assertEquals(11, ret.length());

        ret = s.shortestSuperstring(new String[]{"qkawwbuy", "hectxljtrm", "bcexb",
                "rmnysxnqe", "wbuyhectx", "jtrmnysx", "wwbuyhect"});
        Assert.assertEquals(30, ret.length());
    }
}
