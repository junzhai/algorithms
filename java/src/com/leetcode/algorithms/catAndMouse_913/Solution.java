package com.leetcode.algorithms.catAndMouse_913;

import org.junit.Assert;

@com.pattern.algorithms.DP
abstract public class Solution {
    abstract public int catMouseGame(int[][] graph);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
//                new NewGraph(),
                new DP(),
        };

        for (Solution s : solutions) {
            int ret;

            ret = s.catMouseGame(new int[][]{
                    {2, 3, 4}, {2, 4}, {0, 1, 4}, {0, 4}, {0, 1, 2, 3}
            });
            Assert.assertEquals(ret, 2);

            ret = s.catMouseGame(new int[][]{
                    {2, 3}, {2}, {0, 1}, {0, 4}, {3}
            });
            Assert.assertEquals(ret, 2);

            ret = s.catMouseGame(new int[][]{
                    {2, 9, 14},
                    {2, 5, 7},
                    {0, 1, 3, 8, 9, 11, 14},
                    {2, 12},
                    {5, 11, 18},
                    {1, 4, 18},
                    {9, 17, 19},
                    {1, 11, 12, 13, 14, 17, 19},
                    {2, 16, 17},
                    {0, 2, 6, 12, 14, 18},
                    {14},
                    {2, 4, 7},
                    {3, 7, 9, 13},
                    {7, 12, 14},
                    {0, 2, 7, 9, 10, 13, 17},
                    {18},
                    {8, 19},
                    {6, 7, 8, 14, 19},
                    {4, 5, 9, 15},
                    {6, 7, 16, 17}
            });
            Assert.assertEquals(ret, 0);

            ret = s.catMouseGame(new int[][]{{2, 5}, {3}, {0, 4, 5}, {1, 4, 5}, {2, 3}, {0, 2, 3}});
            Assert.assertEquals(ret, 0);

            ret = s.catMouseGame(new int[][]{{5}, {4}, {3}, {2, 5}, {1, 5}, {0, 3, 4}});
            Assert.assertEquals(ret, 2);
        }
    }
}
