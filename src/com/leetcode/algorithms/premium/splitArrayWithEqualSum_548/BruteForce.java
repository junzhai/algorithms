package com.leetcode.algorithms.premium.splitArrayWithEqualSum_548;

/**
 * O(n^3)
 */
public class BruteForce extends Solution {
    @Override
    public boolean splitArray(int[] nums) {
        int[] r = new int[nums.length];
        for (int i = 0, s = 0; i < nums.length; i++) {
            s += nums[i];
            r[i] = s;
        }

        for (int i = 1; i < nums.length - 5; i++) {
            for (int j = i + 2; j < nums.length - 3; j++) {
                for (int k = j + 2; k < nums.length - 1; k++) {
                    int s1 = r[i] - nums[i];
                    int s2 = r[j] - r[i] - nums[j];
                    int s3 = r[k] - r[j] - nums[k];
                    int s4 = r[nums.length - 1] - r[k];
                    if (s1 == s2 && s2 == s3 && s3 == s4) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
