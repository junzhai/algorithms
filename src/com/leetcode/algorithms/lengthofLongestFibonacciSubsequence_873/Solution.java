package com.leetcode.algorithms.lengthofLongestFibonacciSubsequence_873;

import org.junit.Assert;

abstract public class Solution {
    abstract public int lenLongestFibSubseq(int[] A);

    public static void main(String[] args) {
//        Solution s = new DP();
//        Solution s = new Enum();
//        Solution s = new DP2();
        Solution s = new DP_2Sum();
        int ret;

        ret = s.lenLongestFibSubseq(new int[]{2,5,6,11,13,14,15,17,18,20,22,27,28,31,32,33,38,41,45,46,50,51,55,56,58,61,68,69,73,77,78,84,96,97,107,114,118,122,128,135,151,154,163,166,182,199,206,219,250,263,270,296,321,334,354,404,429,433,478,520,540,573,692,703,774,841,927,1121,1136,1252,1361,1500,1813,1839,2202,2427,2934,2975,3563,3927,4747,4814,5765,6354,7681,7789,9328,10281,12428,12603,15093,16635,20109,20392,24421,26916,32537,39514,52646,63935});
        Assert.assertEquals(18, ret);

        ret = s.lenLongestFibSubseq(new int[]{1, 3, 5});
        Assert.assertEquals(0, ret);

        ret = s.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        Assert.assertEquals(5, ret);

        ret = s.lenLongestFibSubseq(new int[]{2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50});
        Assert.assertEquals(5, ret);
    }
}
