package com.leetcode.algorithms.medianOfTwoSortedArrays_4;

import java.util.Arrays;

public class BinarySearch extends Solution {
    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            int m = nums2.length / 2;
            if (nums2.length % 2 == 0) {
                return (nums2[m - 1] + nums2[m]) / 2.0;
            }
            return nums2[m];
        }
        if (nums2.length == 0) {
            int m = nums1.length / 2;
            if (nums1.length % 2 == 0) {
                return (nums1[m - 1] + nums1[m]) / 2.0;
            }
            return nums1[m];
        }
        int target = (nums1.length + nums2.length) / 2;
        int lo1 = 0, hi1 = nums1.length - 1, lo2 = 0, hi2 = nums2.length - 1;
        boolean even = (nums1.length + nums2.length) % 2 == 0;
        while (lo1 <= hi1) {
            int m = (lo1 + hi1) / 2;
            int p = Arrays.binarySearch(nums2, lo2, hi2 + 1, nums1[m]);
            p = p >= 0 ? p : -p - 2;
            int mc = m + 1 + p + 1;
            if (mc == target) {
                if (even) {
                    return (nums1[m] + next(nums1, m, nums2, p)) / 2.0;
                } else {
                    return next(nums1, m, nums2, p);
                }
            }
            if (mc < target) {
                if (p == nums2.length - 1) {
                    m = m + target - mc;
                    if (even) {
                        return (nums1[m] + nums1[m + 1]) / 2.0;
                    } else {
                        return nums1[m + 1];
                    }
                }
                lo1 = m + 1;
                lo2 = p + 1;
            } else {
                if (p == -1) {
                    if (even) {
                        return (nums1[target - 1] + nums1[target]) / 2.0;
                    } else {
                        return nums1[target];
                    }
                }
                hi1 = m - 1;
                hi2 = p;
            }
        }

        int mc = hi1 + 1 + lo2;
        int m = lo2 + target - mc - 1;
        if (even) {
            return (nums2[m] + next(nums1, hi1, nums2, m)) / 2.0;
        }
        return next(nums1, hi1, nums2, m);
    }

    private int next(int[] nums1, int i1, int[] nums2, int i2) {
        if (i2 + 1 >= nums2.length) {
            return nums1[i1 + 1];
        }

        if (i1 + 1 >= nums1.length) {
            return nums2[i2 + 1];
        }

        return Math.min(nums2[i2 + 1], nums1[i1 + 1]);
    }
}
