package com.leetcode.algorithms.validTriangleNumber_611;

import org.junit.Assert;

abstract public class Solution {
    abstract public int triangleNumber(int[] nums);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new UsingBinaryIndexTree(),
                new Pivoting()
        };
        int ret;
        for (Solution s : solutions) {
            ret = s.triangleNumber(new int[]{2, 2, 3, 4});
            Assert.assertEquals(3, ret);
        }
    }
}
