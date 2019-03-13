package com.leetcode.algorithms.premium.maximumSizeSubarraySumEqualsk_325;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int ret = 0;
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(k, -1);
        for (int i = 0, s = 0; i < nums.length; i++) {
            s += nums[i];
            if (cache.containsKey(s)) {
                ret = Math.max(ret, i - cache.get(s));
            }
            if (!cache.containsKey(s + k)) {
                cache.put(s + k, i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;

        ret = s.maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1);
        Assert.assertEquals(2, ret);

        ret = s.maxSubArrayLen(new int[]{6}, 6);
        Assert.assertEquals(1, ret);

        ret = s.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3);
        Assert.assertEquals(4, ret);
    }
}
