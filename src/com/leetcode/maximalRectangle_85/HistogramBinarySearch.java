package com.leetcode.maximalRectangle_85;

import java.util.Arrays;

public class HistogramBinarySearch extends Solution {
    @Override
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        if (r == 0) {
            return 0;
        }

        int ret = 0, c = matrix[0].length;
        if (c <= r) {
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
        } else {
            int[] h = new int[r], buf = new int[r], s = new int[r];
            for (int i = 0; i < c; i++) {
                for (int j = 0; j < r; j++) {
                    if (matrix[j][i] == '0') {
                        h[j] = 0;
                    } else {
                        h[j] += 1;
                    }
                }
                ret = Math.max(ret, findMax(h, buf, s));
            }
        }
        return ret;
    }

    private int findMax(int[] h, int[] buf, int[] s) {
        int l = 0, ret = 0;
        for (int i = 0; i < h.length; i++) {
            int p = Arrays.binarySearch(buf, 0, l, h[i]);
            if (p >= 0) {
                for (int j = p + 1; j < l; j++) {
                    ret = Math.max(ret, (i - s[j]) * buf[j]);
                }
            } else {
                p = -p - 1;
                for (int j = p; j < l; j++) {
                    ret = Math.max(ret, (i - s[j]) * buf[j]);
                }
                buf[p] = h[i];
                if (p >= l) {
                    s[p] = i;
                }
            }
            l = p + 1;
        }

        int len = h.length;
        for (int i = 0; i < l; i++) {
            ret = Math.max(ret, (len - s[i]) * buf[i]);
        }
        return ret;
    }
}
