package com.leetcode.algorithms.xxx_countofRangeSum_327;

public class BruteForce extends Solution {
    @Override
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length, ret = 0;
        long[] sum = new long[len];
        for (int i = 0; i < len; i++) {
            sum[i] = (i == 0 ? 0 : sum[i - 1]) + nums[i];
        }

        long l = lower, u = upper;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (sum[j] <= u && sum[j] >= l) {
                    ret += 1;
                }
            }
            l += nums[i];
            u += nums[i];
        }
        return ret;
    }
}
