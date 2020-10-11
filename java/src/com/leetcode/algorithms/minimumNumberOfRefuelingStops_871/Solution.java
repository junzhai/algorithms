package com.leetcode.algorithms.minimumNumberOfRefuelingStops_871;

import org.junit.Assert;

public abstract class Solution {
    public abstract int minRefuelStops(int target, int startFuel, int[][] stations);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new Scan(),
                new UsingDP(),
                new UsingDP(),
                new UsingBFS()
        };

        int ret;
        for (Solution s : solutions) {
            ret = s.minRefuelStops(100, 50, new int[][]{{25, 30}});
            Assert.assertEquals(-1, ret);

            ret = s.minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}});
            Assert.assertEquals(2, ret);

            ret = s.minRefuelStops(1000, 83, new int[][]{
                    {47, 220}, {65, 1}, {98, 113}, {126, 196}, {186, 218}, {320, 205}, {686, 317},
                    {707, 325}, {754, 104}, {781, 105}
            });
            Assert.assertEquals(4, ret);

            ret = s.minRefuelStops(200, 50, new int[][]{{25, 25}, {50, 100}, {100, 100}, {150, 40}});
            Assert.assertEquals(2, ret);

            ret = s.minRefuelStops(100, 50, new int[][]{{25, 25}, {50, 50}});
            Assert.assertEquals(1, ret);
        }
    }
}
