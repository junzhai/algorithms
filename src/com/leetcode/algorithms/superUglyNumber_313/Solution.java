package com.leetcode.algorithms.superUglyNumber_313;

import org.junit.Assert;

abstract public class Solution {
    abstract public int nthSuperUglyNumber(int n, int[] primes);

    public static void main(String[] args) {
//        Solution s = new BruteForce();
        Solution s = new UseArray();
//        Solution s = new Heap();
        int ret;

        ret = s.nthSuperUglyNumber(250, new int[]{5, 17, 19, 23, 47, 53, 59, 61, 67, 71, 73, 89, 101, 107, 109, 113,
                131, 149, 157, 163, 167, 179, 181, 191, 199, 211, 223, 233, 239, 251});
        Assert.assertEquals(6365, ret);

        ret = s.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
        Assert.assertEquals(32, ret);

        ret = s.nthSuperUglyNumber(100000,
                new int[]{7, 19, 29, 37, 41, 47, 53, 59, 61, 79, 83, 89, 101, 103, 109, 127, 131, 137, 139, 157, 167,
                        179, 181, 199, 211, 229, 233, 239, 241, 251});

        ret = s.nthSuperUglyNumber(800,
                new int[]{37, 43, 59, 61, 67, 71, 79, 83, 89, 97, 101, 103, 113, 127, 131, 157, 163, 167, 173, 179,
                        191, 193, 197, 199, 211, 229, 233, 239, 251, 257});

        ret = s.nthSuperUglyNumber(700,
                new int[]{7, 11, 17, 23, 29, 31, 43, 47, 53, 67, 71, 73, 79, 89, 101, 113, 127, 131, 149, 151, 157,
                        163, 167, 179, 181, 199, 211, 223, 227, 251});
    }
}
