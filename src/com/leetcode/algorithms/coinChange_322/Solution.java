package com.leetcode.algorithms.coinChange_322;

import org.junit.Assert;

abstract public class Solution {
    abstract public int coinChange(int[] coins, int amount);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
//                new BruteForce(),
//                new DPTopDown(),
                new DPBottomUp()
        };

        for (Solution s : solutions) {
            int ret;

            ret = s.coinChange(new int[]{1, 2147483647}, 2);
            Assert.assertEquals(2, ret);

            ret = s.coinChange(new int[]{456, 117, 5, 145}, 1459);
            Assert.assertEquals(23, ret);

            ret = s.coinChange(new int[]{159, 342, 471, 125, 269, 151, 310, 485, 471, 356}, 6229);
            Assert.assertEquals(14, ret);

            ret = s.coinChange(new int[]{139, 442, 147, 461, 244, 225, 28, 378, 371}, 9914);
            Assert.assertEquals(22, ret);

            ret = s.coinChange(new int[]{186, 419, 83, 408}, 6249);
            Assert.assertEquals(20, ret);

            ret = s.coinChange(new int[]{2, 5, 10, 1}, 27);
            Assert.assertEquals(4, ret);

            ret = s.coinChange(new int[]{130, 129, 400, 289, 230, 135}, 8270);
            Assert.assertEquals(22, ret);

            ret = s.coinChange(new int[]{493, 416, 144, 164, 314, 25}, 5607);
            Assert.assertEquals(14, ret);

            ret = s.coinChange(new int[]{2, 5, 10, 1}, 27);
            Assert.assertEquals(4, ret);

            ret = s.coinChange(new int[]{1}, 0);
            Assert.assertEquals(0, ret);
        }
    }
}
