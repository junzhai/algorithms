package com.leetcode;

import org.junit.Assert;

public class Sandbox {
    public int maxRotateFunction(int[] A) {
        int f = 0, sum = 0, n = A.length;
        for (int i = 0; i < A.length; i++) {
            f += i * A[i];
            sum += A[i];
        }

        int max = f;
        for (int i = A.length - 1; i > 0; i--) {
            f += (sum - (A[i] * n));
            max = Math.max(max, f);
        }

        return max;
    }

    public static void main(String[] args) {
        Sandbox s = new Sandbox();
        int ret;

        ret = s.maxRotateFunction(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        Assert.assertEquals(330, ret);

        ret = s.maxRotateFunction(new int[]{4, 3, 2, 6});
        Assert.assertEquals(26, ret);
    }
}