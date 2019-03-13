package com.leetcode.algorithms.superPalindromes_906;

import org.junit.Assert;

abstract public class Solution {
    abstract public int superpalindromesInRange(String L, String R);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new BruteForce(),
                new SuperPalindromCharacter()
        };
        int ret;

        for (Solution s : solutions) {
            ret = s.superpalindromesInRange("38455498359", "999999999999999999");
            Assert.assertEquals(45, ret);

            ret = s.superpalindromesInRange("398904669", "13479046850");
            Assert.assertEquals(6, ret);

            ret = s.superpalindromesInRange("92904622", "232747148");
            Assert.assertEquals(6, ret);

            ret = s.superpalindromesInRange("4", "1000");
            Assert.assertEquals(4, ret);
        }
    }
}