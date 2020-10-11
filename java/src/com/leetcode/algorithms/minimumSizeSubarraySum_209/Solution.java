package com.leetcode.algorithms.minimumSizeSubarraySum_209;

import org.junit.Assert;

abstract public class Solution {
    abstract public int minSubArrayLen(int s, int[] nums);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new Window(),
                new BinarySearch()
        };

        int ret;

        for (Solution s : solutions) {
            ret = s.minSubArrayLen(100, new int[]{});
            Assert.assertEquals(0, ret);

            ret = s.minSubArrayLen(4, new int[]{1, 4, 4});
            Assert.assertEquals(1, ret);

            ret = s.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
            Assert.assertEquals(2, ret);
        }
    }
}
