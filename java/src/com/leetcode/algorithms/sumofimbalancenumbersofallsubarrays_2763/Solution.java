package com.leetcode.algorithms.sumofimbalancenumbersofallsubarrays_2763;

import org.junit.Assert;

abstract public class Solution {

    abstract public int sumImbalanceNumbers(int[] nums);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{new OverKilled(), new Simplified()};
        int ret;

        for (Solution s : solutions) {
            ret = s.sumImbalanceNumbers(new int[]{1, 5, 3, 2, 4});
            Assert.assertEquals(7, ret);

            ret = s.sumImbalanceNumbers(new int[]{2, 3, 1, 4});
            Assert.assertEquals(3, ret);

            ret = s.sumImbalanceNumbers(new int[]{1, 3, 3, 3, 5});
            Assert.assertEquals(8, ret);

            ret = s.sumImbalanceNumbers(new int[]{1, 3, 1});
            Assert.assertEquals(3, ret);

            ret = s.sumImbalanceNumbers(new int[]{1, 3, 2});
            Assert.assertEquals(1, ret);
        }
    }
}