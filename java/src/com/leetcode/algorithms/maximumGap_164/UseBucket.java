package com.leetcode.algorithms.maximumGap_164;

import com.leetcode.algorithms.pattern.RadixSort;

@RadixSort
public class UseBucket extends Solution {

    @Override
    public int maximumGap(int[] nums) {
        return bucketSort(nums, 0, nums.length - 1, 0x40000000);
    }

    private int bucketSort(int[] n, int left, int right, int m) {
        if (left >= right || m == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE, max = 0, l = left, r = right;
        while (l <= r) {
            if ((n[l] & m) == 0) {
                max = Math.max(max, n[l]);
                l += 1;
                continue;
            }

            if ((n[r] & m) != 0) {
                min = Math.min(min, n[r]);
                r -= 1;
                continue;
            }

            int tmp = n[l];
            n[l] = n[r];
            n[r] = tmp;
        }

        int ret = l - left > 0 && right - l + 1 > 0 ? min - max : 0;
        ret = Math.max(ret, bucketSort(n, left, l - 1, m >>> 1));
        ret = Math.max(ret, bucketSort(n, l, right, m >>> 1));
        return ret;
    }
}
