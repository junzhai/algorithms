package com.leetcode.algorithms.xxx_countofRangeSum_327;

import java.util.Arrays;

public class LowerBoundinArray extends Solution {
    @Override
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length, diff = upper - lower, ret = 0, l = 1;
        long sum = 0, lb = lower;
        long[] lbs = new long[len];
        lbs[0] = lower;

        for (int i = 0; i < len; i++) {
            sum += nums[i];
            int p = Arrays.binarySearch(lbs, 0, l, sum);
            if (p < 0) {
                p = -p - 1;
            } else {
                while (p < l && lbs[p] == sum) {
                    p += 1;
                }
            }

            int p1 = Arrays.binarySearch(lbs, 0, l, sum - diff);
            if (p1 < 0) {
                p1 = -p1 - 1;
            } else {
                while (p1 > 0 && lbs[p1 - 1] == sum - diff) {
                    p1 -= 1;
                }
            }

            ret += p - p1;
            lb += nums[i];

            p = Arrays.binarySearch(lbs, 0, l, lb);
            if (p < 0) {
                p = -p - 1;
            } else {
                while (p < l && lbs[p] == lb) {
                    p += 1;
                }
            }

            if (i < len - 1) {
                System.arraycopy(lbs, p, lbs, p + 1, l - p);
                lbs[p] = lb;
                l += 1;
            }
        }
        return ret;
    }
}
