package com.leetcode.algorithms.minimumHeightTrees_310;

import org.junit.Assert;

import java.util.List;

abstract public class Solution {
    abstract public List<Integer> findMinHeightTrees(int n, int[][] edges);

    public static void main(String[] arg) {
        Solution[] solutions = new Solution[]{
//                new MultiplyMatrix(),
//                new ScanEdges(),
                new FindMaxPath()
        };
        List<Integer> ret;

        for (Solution s : solutions) {
            ret = s.findMinHeightTrees(1, new int[0][0]);
            Assert.assertEquals(1, ret.size());
            Assert.assertEquals(true, ret.contains(0));

            ret = s.findMinHeightTrees(7, new int[][]{{0, 1}, {1, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}});
            Assert.assertEquals(2, ret.size());
            Assert.assertEquals(true, ret.contains(1));
            Assert.assertEquals(true, ret.contains(2));
        }
    }
}
