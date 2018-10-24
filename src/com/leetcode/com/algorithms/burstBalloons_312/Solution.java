package com.leetcode.com.algorithms.burstBalloons_312;

import org.junit.Assert;

abstract public class Solution {
    abstract public int maxCoins(int[] nums);


    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
//                new LastBurstDP(),
                new LastBurstIterativeDP(),
//                new SimpleDP(),
//                new Iterative(),
        };

        for (Solution s : solutions) {
            int ret;

            ret = s.maxCoins(new int[]{6, 2, 8, 5});
            Assert.assertEquals(ret, 372);

            ret = s.maxCoins(new int[]{8, 2, 6, 8, 9, 8, 1, 4, 1, 5, 3, 0, 7, 7, 0, 4, 2, 2, 5});
            Assert.assertEquals(ret, 3630);

            ret = s.maxCoins(new int[]{8, 2, 6, 8, 9, 8, 1, 4});
            Assert.assertEquals(ret, 1960);


            ret = s.maxCoins(new int[]{8, 3, 4, 3, 5, 0, 5, 6, 6, 2, 8, 5, 6, 2, 3, 8, 3, 5, 1, 0, 2});
            Assert.assertEquals(ret, 3394);

            ret = s.maxCoins(new int[]{});
            Assert.assertEquals(ret, 0);

            ret = s.maxCoins(new int[]{3, 1, 5, 8});
            Assert.assertEquals(ret, 167);

            ret = s.maxCoins(new int[]{42, 23, 62, 2, 89, 97, 26, 82, 47, 23, 9, 2, 9, 11, 53, 49, 40, 3, 88, 76, 63,
                    11, 79, 37, 52, 91, 5, 44, 71, 69, 20, 5, 74, 41, 70, 68, 26, 16, 62, 53, 47, 46, 26, 27, 99, 72,
                    4, 40, 77, 74, 89, 19, 26, 7, 30, 79, 49, 75, 51, 28, 47, 26, 55, 81, 82, 15, 21, 89, 51, 10, 0,
                    50, 31, 32, 38, 7, 99, 13, 23, 98, 68, 9, 54, 15, 34, 52, 58, 48, 66, 75, 6, 15, 91, 33, 15, 37,
                    25, 98, 98, 77, 60, 16, 82, 89, 48, 43, 1, 85, 39, 99, 95, 86, 45, 90, 73, 45, 93, 99, 39, 57,
                    32, 47, 35, 79, 25, 54, 98, 34, 60, 90, 38, 40, 5, 5, 96, 21, 18, 93, 69, 38, 85, 49, 15, 77, 84,
                    70, 52, 87, 73, 15, 65});
            Assert.assertEquals(ret, 53234968);
        }
    }
}
