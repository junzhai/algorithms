package com.leetcode.algorithms.medianOfTwoSortedArrays_4;

public class TotalNumber extends Solution {
    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length <= nums2.length) {
            return inner(nums1, nums2);
        }
        return inner(nums2, nums1);
    }

    public double inner(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return median(nums2);
        }

        if (nums2.length == 0) {
            return median(nums1);
        }

        int half = (nums1.length + nums2.length) / 2;
        int lo = 0, hi = nums1.length;
        while (lo <= hi) {
            int c1 = (lo + hi) / 2, c2 = half - c1;
            if (c1 == 0 && nums2[c2 - 1] > nums1[c1]) {
                lo = c1 + 1;
            } else if (c2 == 0 && nums1[c1 - 1] > nums2[c2]) {
                hi = c1 - 1;
            } else if (c1 > 0 && c2 < nums2.length && nums1[c1 - 1] > nums2[c2]) {
                hi = c1 - 1;
            } else if (c2 > 0 && c1 < nums1.length && nums2[c2 - 1] > nums1[c1]) {
                lo = c1 + 1;
            } else {
                return median(nums1, c1, nums2, c2);
            }
        }

        throw new IllegalStateException();
    }

    private double median(int[] nums) {
        int k = nums.length / 2;
        if (nums.length % 2 == 0) {
            return (nums[k - 1] + nums[k]) / 2.0;
        }
        return nums[k];
    }

    private double median(int[] nums1, int c1, int[] nums2, int c2) {
        int l1 = c1 == 0 ? Integer.MIN_VALUE : nums1[c1 - 1];
        int l2 = c2 == 0 ? Integer.MIN_VALUE : nums2[c2 - 1];
        int l = Math.max(l1, l2);
        int r1 = c1 < nums1.length ? nums1[c1] : Integer.MAX_VALUE;
        int r2 = c2 < nums2.length ? nums2[c2] : Integer.MAX_VALUE;
        int r = Math.min(r1, r2);

        boolean even = (nums1.length + nums2.length) % 2 == 0;
        return even ? (l + r) / 2.0 : r;
    }
}
