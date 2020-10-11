package com.leetcode.algorithms.rectangleAreaII_850;

import org.junit.Assert;

abstract public class Solution {
    abstract public int rectangleArea(int[][] rectangles);

    public static void main(String[] args) {
        Solution s = new UsingAreaTree();
        int ret;
        ret = s.rectangleArea(new int[][]{{0, 0, 1, 1}, {2, 2, 3, 3}});
        Assert.assertEquals(2, ret);

        ret = s.rectangleArea(new int[][]{{0, 0, 1000000000, 1000000000}});
        Assert.assertEquals(49, ret);
    }

}
