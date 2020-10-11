package com.leetcode.algorithms.soupServings_808;

import org.junit.Assert;

abstract public class Solution {
    abstract public double soupServings(int N);

    public static void main(String[] args) {
//        Solution s1 = new UseBFS();
        Solution s = new UseDP();
//        Solution s = new BFSWithCircularQueue();
        double ret;

        ret = s.soupServings(0);
        Assert.assertEquals(0.5, ret, 0.000001);

        ret = s.soupServings(50);
        Assert.assertEquals(0.625, ret, 0.000001);

        ret = s.soupServings(75);
        Assert.assertEquals(0.65625, ret, 0.000001);

        ret = s.soupServings(100);
        Assert.assertEquals(0.71875, ret, 0.000001);

        ret = s.soupServings(101);
        Assert.assertEquals(0.742187, ret, 0.000001);

        ret = s.soupServings(150);
        Assert.assertEquals(0.7578125, ret, 0.000001);

        ret = s.soupServings(800);
        Assert.assertEquals(0.961617, ret, 0.000001);

        ret = s.soupServings(4799);
        Assert.assertEquals(0.999994, ret, 0.000001);

        ret = s.soupServings(5570);
        Assert.assertEquals(1, ret, 0.000001);

        ret = s.soupServings(33727875);
        Assert.assertEquals(1, ret, 0.000001);

        ret = s.soupServings(660295675);
        Assert.assertEquals(1, ret, 0.000001);

    }
}
