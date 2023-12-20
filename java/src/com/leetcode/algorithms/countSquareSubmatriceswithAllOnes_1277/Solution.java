package com.leetcode.algorithms.countSquareSubmatriceswithAllOnes_1277;

import com.pattern.algorithms.DP;
import org.junit.Assert;

@DP
abstract class Solution {
    abstract public int countSquares(int[][] matrix);

    public static void main(String[] args) {
//        Solution s = new DP();
        Solution s = new DP_better();
        Assert.assertEquals(19, s.countSquares(new int[][]{
                {1, 1, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {0, 0, 1, 0, 1}}));
    }
}