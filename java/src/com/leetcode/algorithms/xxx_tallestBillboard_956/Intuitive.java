package com.leetcode.algorithms.xxx_tallestBillboard_956;

import java.util.Arrays;

public class Intuitive extends Solution {
    @Override
    public int tallestBillboard(int[] rods) {
        int len = rods.length;
        if (len == 0) {
            return 0;
        }

        int sum = 0;
        for (int r : rods) {
            sum += r;
        }

        int l = sum >>> 1;

        int[][] c = new int[l + 1][0];
        c[0] = new int[]{0};
        for (int i = 0; i < len; i++) {
            for (int j = l - rods[i]; j >= 0; j--) {
                int k = j + rods[i];
                if (c[j].length > 0) {
                    copy(c, j, k, i);
                }
            }
        }

        if (sum % 2 == 0 && c[sum >>> 1].length > 0) {
            return sum >>> 1;
        }

        for (int i = l; i >= 0; i--) {
            if (c[i].length < 2) {
                continue;
            }

            int remain = sum - (i << 1);
            if (c[remain].length < 1) {
                continue;
            }

            if (match(c[remain], c[i])) {
                return i;
            }
        }

        return 0;
    }

    private void copy(int[][] c, int j, int k, int i) {
        int m = 1 << i, lj = c[j].length, lk = c[k].length;
        int[] tmp = Arrays.copyOf(c[j], lj + lk);
        for (int ii = 0; ii < lj; ii++) {
            tmp[ii] |= m;
        }
        System.arraycopy(c[k], 0, tmp, lj, lk);
        c[k] = tmp;
    }

    private boolean match(int[] a, int[] b) {
        int[] outer = a.length > b.length ? b : a;
        for (int i : outer) {
            for (int j : b) {
                if ((i & j) == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
