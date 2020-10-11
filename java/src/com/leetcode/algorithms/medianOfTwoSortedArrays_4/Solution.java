package com.leetcode.algorithms.medianOfTwoSortedArrays_4;

import org.junit.Assert;

abstract public class Solution {
    abstract public double findMedianSortedArrays(int[] nums1, int[] nums2);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new BinarySearch(),
                new TotalNumber()
        };

        for (Solution s : solutions) {
            double ret;

            ret = s.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
            Assert.assertEquals(ret, 2, 0);

            ret = s.findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4});
            Assert.assertEquals(ret, 2.5, 0);

            ret = s.findMedianSortedArrays(new int[]{1}, new int[]{1});
            Assert.assertEquals(ret, 1, 0);

            ret = s.findMedianSortedArrays(new int[]{100000}, new int[]{100001});
            Assert.assertEquals(ret, 100000.5, 0);

            ret = s.findMedianSortedArrays(new int[]{2, 3, 4}, new int[]{1});
            Assert.assertEquals(ret, 2.5, 0);
        }
    }
}
