package com.leetcode.com.algorithms.maximalRectangle_85;

public class Histogram extends Solution {
    @Override
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        if (r == 0) {
            return 0;
        }

        int ret = 0, c = matrix[0].length;
        int[] h = new int[c], buf = new int[c], s = new int[c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '0') {
                    h[j] = 0;
                } else {
                    h[j] += 1;
                }
            }
            ret = Math.max(ret, findMax(h, buf, s));
        }
        return ret;
    }

    private int findMax(int[] h, int[] buf, int[] s) {
        int l = 0, ret = 0;
        for (int i = 0; i < h.length; i++) {
            int ss = i;
            for (int j = l - 1; j >= 0; j--) {
                if (h[i] > buf[j]) {
                    buf[j + 1] = h[i];
                    s[j + 1] = ss;
                    l = j + 2;
                    break;
                } else if (h[i] < buf[j]) {
                    ret = Math.max(ret, (i - s[j]) * buf[j]);
                    ss = s[j];
                    l = j;
                } else {
                    break;
                }
            }
            if (l == 0) {
                buf[0] = h[i];
                s[0] = ss;
                l = 1;
            }
        }

        int len = h.length;
        for (int i = 0; i < l; i++) {
            ret = Math.max(ret, (len - s[i]) * buf[i]);
        }
        return ret;
    }
}
