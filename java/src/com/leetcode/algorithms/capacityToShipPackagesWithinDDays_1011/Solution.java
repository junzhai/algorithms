package com.leetcode.algorithms.capacityToShipPackagesWithinDDays_1011;

import org.junit.Assert;

abstract public class Solution {
    abstract public int shipWithinDays(int[] weights, int D);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new TryCapacity(),
                new UseDP(),
                new BinarySearch()
        };

        int ret;

        for (Solution s : solutions) {
            ret = s.shipWithinDays(new int[]{147, 73, 265, 305, 191, 152, 192, 293, 309, 292, 182, 157, 381, 287, 73,
                    162, 313, 366, 346, 47}, 10);
            Assert.assertEquals(602, ret);

            ret = s.shipWithinDays(new int[]{9, 2, 4, 1, 3, 8, 10, 7, 6, 5}, 5);
            Assert.assertEquals(15, ret);

            ret = s.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3);
            Assert.assertEquals(6, ret);

            ret = s.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4);
            Assert.assertEquals(3, ret);

            ret = s.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
            Assert.assertEquals(15, ret);
        }
    }
}
