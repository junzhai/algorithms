package com.leetcode.algorithms.findK_thSmallestPairDistance_719;

import com.leetcode.util.LargeCaseUtil;
import org.junit.Assert;

abstract public class Solution {
    abstract public int smallestDistancePair(int[] nums, int k);

    public static void main(String[] args) {
        Solution s = new UseBinarySearch();
        int ret;

        ret = s.smallestDistancePair(new int[]{2, 2, 0, 1, 1, 0, 0, 1, 2, 0}, 2);
        Assert.assertEquals(0, ret);

        ret = s.smallestDistancePair(new int[]{1, 3, 1}, 1);
        Assert.assertEquals(0, ret);

        ret = s.smallestDistancePair(new int[]{9, 10, 7, 10, 6, 1, 5, 4, 9, 8}, 18);
        Assert.assertEquals(2, ret);

        ret = s.smallestDistancePair(new int[]{38, 33, 57, 65, 13, 2, 86, 75, 4, 56}, 26);
        Assert.assertEquals(36, ret);

        int[] input = LargeCaseUtil.readArray("src/com/leetcode/algorithms/findK_thSmallestPairDistance_719/case19");
        long start = System.currentTimeMillis();
        ret = s.smallestDistancePair(input, 25000000);
        System.out.println("Time used: " + (System.currentTimeMillis() - start));
        Assert.assertEquals(292051, ret);


    }
}
