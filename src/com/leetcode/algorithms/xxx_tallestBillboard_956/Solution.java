package com.leetcode.algorithms.xxx_tallestBillboard_956;

import org.junit.Assert;

abstract public class Solution {
    abstract public int tallestBillboard(int[] rods);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new Intuitive(),
                new BFSandDP(),
                new BFSandDP2()
        };

        int ret;
        for (Solution s : solutions) {
            ret = s.tallestBillboard(new int[]{96, 112, 101, 100, 104, 93, 106, 99, 114, 81, 94});
            Assert.assertEquals(503, ret);

            ret = s.tallestBillboard(new int[]{1, 2});
            Assert.assertEquals(0, ret);

            ret = s.tallestBillboard(new int[]{1, 2, 3, 6});
            Assert.assertEquals(6, ret);

            ret = s.tallestBillboard(new int[]{1, 2, 3, 4, 5, 6});
            Assert.assertEquals(10, ret);

            ret = s.tallestBillboard(new int[]{3, 4, 3, 3, 2});
            Assert.assertEquals(6, ret);

            ret = s.tallestBillboard(new int[]{2, 4, 8, 16});
            Assert.assertEquals(0, ret);

            ret = s.tallestBillboard(new int[]{
                    12, 8, 7, 5, 9, 7, 7, 10, 6, 10, 8, 5, 6, 700, 700, 700, 700, 700, 700, 700});
            Assert.assertEquals(2150, ret);

            ret = s.tallestBillboard(new int[]{
                    90, 91, 93, 81, 86, 84, 95, 79, 89, 96, 91, 87, 83, 87, 89, 96, 105, 86, 93, 99});
            Assert.assertEquals(900, ret);

            ret = s.tallestBillboard(new int[]{
                    33, 30, 41, 34, 37, 29, 26, 31, 42, 33, 38, 27, 33, 31, 35, 900, 900, 900, 900, 900});
            Assert.assertEquals(2050, ret);
        }
    }
}
