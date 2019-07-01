package com.leetcode.algorithms.KClosestPointstoOrigin_973;

import org.junit.Assert;

abstract public class Solution {
    abstract public int[][] kClosest(int[][] points, int K);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new UseHeap(),
                new UseQuickSelect()
        };
        int[][] ret;

        for (Solution s : solutions) {
            ret = s.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
            Assert.assertEquals(-2, ret[0][0]);
            Assert.assertEquals(2, ret[0][1]);

            //[[3,3},{-2,4]]
            ret = s.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        }
    }
}
