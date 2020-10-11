package com.leetcode.algorithms.premium.rangeSumQuery2D_Mutable_308;

import org.junit.Assert;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 0, 1, 4, 2}};
        NumMatrix[] solutions = new NumMatrix[]{
                new BinaryIndexTree(matrix),
                new SegmentTree(matrix)
        };

        for (NumMatrix s : solutions) {
            Assert.assertEquals(10, s.sumRegion(0, 0, 0, 4));
            Assert.assertEquals(7, s.sumRegion(0, 2, 0, 4));
            s.update(0, 3, 2);
            Assert.assertEquals(5, s.sumRegion(0, 2, 0, 4));
        }

        matrix = new int[][]{{3}, {0}, {1}, {4}, {2}};
        solutions = new NumMatrix[]{
                new BinaryIndexTree(matrix),
                new SegmentTree(matrix)
        };
        for (NumMatrix s : solutions) {
            Assert.assertEquals(10, s.sumRegion(0, 0, 4, 0));
            Assert.assertEquals(7, s.sumRegion(2, 0, 4, 0));
            s.update(3, 0, 2);
            Assert.assertEquals(5, s.sumRegion(2, 0, 4, 0));
        }

        matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        solutions = new NumMatrix[]{
                new BinaryIndexTree(matrix),
                new SegmentTree(matrix)
        };

        for (NumMatrix s : solutions) {
            Assert.assertEquals(8, s.sumRegion(2, 1, 4, 3));
            s.update(3, 2, 2);
            Assert.assertEquals(10, s.sumRegion(2, 1, 4, 3));
        }
    }
}
