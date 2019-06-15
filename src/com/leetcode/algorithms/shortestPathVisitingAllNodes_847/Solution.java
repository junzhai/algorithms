package com.leetcode.algorithms.shortestPathVisitingAllNodes_847;

import org.junit.Assert;

abstract public class Solution {
    abstract public int shortestPathLength(int[][] graph);

    public static void main(String[] args) {
        Solution s = new UseDP();

        int ret;


        ret = s.shortestPathLength(new int[][]{
                {1, 2, 3},
                {0},
                {0},
                {0}
        });
        Assert.assertEquals(4, ret);

        ret = s.shortestPathLength(new int[][]{
                {1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}
        });
        Assert.assertEquals(4, ret);

        ret = s.shortestPathLength(new int[][]{
                {1, 2, 4}, {0}, {0, 3}, {2, 4}, {0, 3}
        });
        Assert.assertEquals(4, ret);

        ret = s.shortestPathLength(new int[][]{
                {2, 3}, {7}, {0, 6}, {0, 4, 7}, {3, 8}, {7}, {2}, {5, 3, 1}, {4}
        });
        Assert.assertEquals(11, ret);

        ret = s.shortestPathLength(new int[][]{
                {2, 5, 7}, {2, 4}, {0, 1}, {5}, {5, 6, 1}, {4, 10, 8, 0, 3}, {4, 9}, {0}, {5}, {6}, {5}
        });
        Assert.assertEquals(13, ret);

        ret = s.shortestPathLength(new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
                {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
                {0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11},
                {0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11},
                {0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11},
                {0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11},
                {0, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11},
                {0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11},
                {0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11},
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11},
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11},
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        });
        Assert.assertEquals(11, ret);
    }
}
