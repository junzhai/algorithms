package com.leetcode.champagneTower_799;

import org.junit.Assert;

import java.util.Arrays;

public class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] dp1 = new double[100], dp2 = new double[100];
        int[] c1 = new int[100], c2 = new int[100];
        int total = 0;
        for (int i = 0, s = 1; i <= query_row; i++, s <<= 1) {
            double t = 0.0;
            if (poured > total) {
                double amt = Math.min(poured - total, s);
                total += amt;
                t = amt / s;
            }

            boolean overflow = false;
            for (int j = 0; j <= Math.min(query_glass, i); j++) {
                if (j == 0 || j == i) {
                    c2[j] = 1;
                    dp1[j] += t;
                } else {
                    c2[j] = c1[j - 1] + c1[j];
                    dp1[j] += t * c2[j];
                    if (dp1[j] > 1) {
                        overflow = true;
                        double x = (dp1[j] - 1) / 2;
                        dp1[j] = 1;
                        dp2[j] += x;
                        dp2[j + 1] += x;
                    }
                }
            }

            if (i == query_row) {
                return dp1[query_glass];
            }

            if (t == 0 && !overflow) {
                return 0.0;
            }

            double[] tmp = dp1;
            dp1 = dp2;
            dp2 = tmp;
            Arrays.fill(dp2, 0.0);

            int[] ttmp = c1;
            c1 = c2;
            c2 = ttmp;
            Arrays.fill(c2, 0);
        }

        throw new IllegalStateException();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        double ret;

        ret = s.champagneTower(200, 15, 11);
        Assert.assertEquals(1, ret, 0.0);

        ret = s.champagneTower(8, 3, 0);
        Assert.assertEquals(0.125, ret, 0.0);

        ret = s.champagneTower(2, 1, 1);
        Assert.assertEquals(0.5, ret, 0.0);

        ret = s.champagneTower(1, 1, 1);
        Assert.assertEquals(0.0, ret, 0.0);

        ret = s.champagneTower(1000000000, 99, 99);
        Assert.assertEquals(0.0, ret, 0.0);
    }
}
