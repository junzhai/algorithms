package com.leetcode.algorithms.smallestRotationwithHighestScore_798;

import org.junit.Assert;

abstract public class Solution {
    abstract public int bestRotation(int[] A) ;

    public static void main(String[] args) {
        Solution s = new Solution3();
        int ret;
        ret = s.bestRotation(new int[]{2,4,1,3,0});
        Assert.assertEquals(0, ret);
    }
}
