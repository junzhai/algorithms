package com.leetcode.premium.splitArrayWithEqualSum_548;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * O(n)
 */
public class LinearScan extends Solution {
    @Override
    public boolean splitArray(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        Map<Integer, Set<Integer>> dp2 = new HashMap<>(), dp3 = new HashMap<>();
        for (int i = 1, s = nums[0]; i < nums.length; i++) {
            if (dp3.containsKey(s)) {
                Set<Integer> steps = dp3.get(s);
                for (int step : steps) {
                    if (s + nums[i] + step == total) {
                        return true;
                    }
                }
            }

            if (dp2.containsKey(s)) {
                Set<Integer> steps = dp2.get(s);
                for (int step : steps) {
                    int expected = s + nums[i] + step;
                    if (!dp3.containsKey(expected)) {
                        dp3.put(expected, new HashSet<>());
                    }
                    dp3.get(expected).add(step);
                }
            }

            int expected = s * 2 + nums[i];
            if (!dp2.containsKey(expected)) {
                dp2.put(expected, new HashSet<>());
            }
            dp2.get(expected).add(s);

            s += nums[i];
        }

        return false;
    }
}
