package com.leetcode.algorithms.FourSum_18;

import org.junit.Assert;

import java.util.List;

abstract public class Solution {
    abstract public List<List<Integer>> fourSum(int[] nums, int target);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new Solution1(),
                new DP(),
                new DP2(),
                new Sum3Sum2()
        };

        List<List<Integer>> ret;

        for (Solution s : solutions) {
            ret = s.fourSum(new int[]{0}, 0);
            Assert.assertEquals(0, ret.size());

            ret = s.fourSum(new int[]{-1, -5, -5, -3, 2, 5, 0, 4}, -7);
            Assert.assertEquals(2, ret.size());

            ret = s.fourSum(new int[]{5, 5, 3, 5, 1, -5, 1, -2}, 4);
            Assert.assertEquals(1, ret.size());

            ret = s.fourSum(new int[]{}, 0);
            Assert.assertEquals(0, ret.size());

            ret = s.fourSum(new int[]{-5, 5, 4, -3, 0, 0, 4, -2}, 4);
            Assert.assertEquals(2, ret.size());

            ret = s.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0);
            Assert.assertEquals(8, ret.size());

            ret = s.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
            Assert.assertEquals(3, ret.size());

            ret = s.fourSum(new int[]{0, 0, 0, 0}, 0);
            Assert.assertEquals(1, ret.size());
        }
    }
}
