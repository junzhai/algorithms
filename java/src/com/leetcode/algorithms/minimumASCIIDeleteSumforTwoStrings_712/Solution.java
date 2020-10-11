package com.leetcode.algorithms.minimumASCIIDeleteSumforTwoStrings_712;

import org.junit.Assert;

abstract public class Solution {
    abstract public int minimumDeleteSum(String s1, String s2);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new MatchPrefixLessMemory(),
                new MatchPrefix(),
                new Recursive()
        };

        int ret;

        for (Solution s : solutions) {
            ret = s.minimumDeleteSum("kslcclpmfd", "guvjxozrjvzhe");
            Assert.assertEquals(2521, ret);

            ret = s.minimumDeleteSum("delete", "leet");
            Assert.assertEquals(403, ret);

            ret = s.minimumDeleteSum("sea", "eat");
            Assert.assertEquals(231, ret);
        }
    }
}
