package com.leetcode.premium.splitArrayWithEqualSum_548;

import java.util.HashSet;
import java.util.Set;

/**
 * O(n^2)
 */
public class ScanMid extends Solution {
    @Override
    public boolean splitArray(int[] nums) {
        int len = nums.length;
        int[] sum = new int[len];
        for (int i = 0, s = 0; i < len; i++) {
            sum[i] = s;
            s += nums[i];
        }

        for (int m = 3; m < len - 3; m++) {
            Set<Integer> steps = new HashSet<>();
            for (int i = 1; i < m - 1; i++) {
                if (sum[i] == sum[m] - sum[i] - nums[i]) {
                    steps.add(sum[i]);
                }
            }

            for (int i = m + 2; i < len - 1; i++) {
                int step = sum[len - 1] - sum[i] - nums[i] + nums[len - 1];
                if (step == sum[i] - sum[m] - nums[m] && steps.contains(step)) {
                    return true;
                }
            }
        }
        return false;
    }
}
