package com.leetcode.algorithms.xxx_raceCar_818;

import org.junit.Assert;

abstract public class Solution {
    abstract public int racecar(int target);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new DPWithPriorityQueue(),
                new DPWithArray(),
                new DPWithArray2(),
                new UseDP3(),
                new UseDP4()
        };

        int ret;

        for (Solution s : solutions) {
            ret = s.racecar(4);
            Assert.assertEquals(5, ret);

            ret = s.racecar(20);
            Assert.assertEquals(12, ret);

            ret = s.racecar(50);
            Assert.assertEquals(16, ret);

            ret = s.racecar(388);
            Assert.assertEquals(23, ret);

            ret = s.racecar(12);
            Assert.assertEquals(7, ret);

            ret = s.racecar(26);
            Assert.assertEquals(13, ret);

//            ret = s.racecar(432);
//            Assert.assertEquals(25, ret);

            ret = s.racecar(9);
            Assert.assertEquals(8, ret);

            ret = s.racecar(5);
            Assert.assertEquals(7, ret);


            ret = s.racecar(3);
            Assert.assertEquals(2, ret);

            ret = s.racecar(6);
            Assert.assertEquals(5, ret);
        }
    }
}