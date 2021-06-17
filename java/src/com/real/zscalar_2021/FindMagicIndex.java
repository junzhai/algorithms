package com.real.zscalar_2021;

/**
 * A magic index in an array A[0 .. n-1] is defined to be an index such that A[i] = i. Given a sorted array of
 * distinct integers, write a method to find and return a magic index, if one exists, in array A.
 */
public class FindMagicIndex {
    public int solution(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == m) {
                return m;
            }

            if (nums[m] > m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
