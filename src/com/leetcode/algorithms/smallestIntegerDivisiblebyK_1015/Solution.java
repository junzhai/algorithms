package com.leetcode.algorithms.smallestIntegerDivisiblebyK_1015;

import org.junit.Assert;

abstract public class Solution {
    abstract public int smallestRepunitDivByK(int K);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new Multiple(),
                new Mod()
        };

        int ret;
        for (Solution s : solutions) {
            ret = s.smallestRepunitDivByK(1);
            Assert.assertEquals(1, ret);

            ret = s.smallestRepunitDivByK(201);
            Assert.assertEquals(33, ret);
        }
    }
}
