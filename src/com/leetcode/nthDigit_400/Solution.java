package com.leetcode.nthDigit_400;

import org.junit.Assert;

public class Solution {
    public int findNthDigit(int n) {
        int d = 1, s = 1;
        long max = 9, t = max * d;
        while (n > t) {
            n -= t;
            d += 1;
            s *= 10;
            max *= 10;
            t = max * d;
        }

        int target = s + (int) Math.ceil((float) n / d) - 1;
        int c = n % d == 0 ? 0 : d - n % d;
        for (int i = 0; i < c; i++) {
            target /= 10;
        }

        return target % 10;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;

        ret = s.findNthDigit(1000000000);
        Assert.assertEquals(1, ret);

        ret = s.findNthDigit(10);
        Assert.assertEquals(1, ret);

        ret = s.findNthDigit(11);
        Assert.assertEquals(0, ret);
    }
}