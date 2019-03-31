package com.leetcode.algorithms.minimumSizeSubarraySum_209;

import java.util.Arrays;

public class BinarySearch extends Solution {
    @Override
    public int minSubArrayLen(int s, int[] nums) {
        int ret = Integer.MAX_VALUE, len = nums.length;
        int[] rolling = new int[len];
        for (int i = 0, sum = 0; i < len; i++) {
            sum += nums[i];
            rolling[i] = sum;
        }

        for (int i = len - 1; i >= 0; i--) {
            if (rolling[i] < s) {
                break;
            }
            int diff = rolling[i] - s;
            int p = Arrays.binarySearch(rolling, diff);
            if (p >= 0) {
                ret = Math.min(ret, i - p);
            } else {
                p = -p - 1;
                ret = Math.min(ret, i - p + 1);
            }
        }

        return ret == Integer.MAX_VALUE ? 0 : ret;
    }
}
