package com.leetcode.sumofDistancesinTree_834;

import org.junit.Assert;

abstract public class Solution {
    abstract public int[] sumOfDistancesInTree(int N, int[][] edges);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new DFS(),
                new DFSWithPath()
        };

        int[] ret;
        for (Solution s : solutions) {
            ret = s.sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}});
            Assert.assertArrayEquals(new int[]{8, 12, 6, 10, 10, 10}, ret);
        }
    }
}
