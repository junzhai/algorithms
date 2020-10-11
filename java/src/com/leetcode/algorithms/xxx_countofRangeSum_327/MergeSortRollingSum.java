package com.leetcode.algorithms.xxx_countofRangeSum_327;

import com.leetcode.algorithms.pattern.DivideAndConquer;
import com.leetcode.algorithms.pattern.MergeSort;

@MergeSort
@DivideAndConquer
public class MergeSortRollingSum extends Solution {
    @Override
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        long[] sum = new long[len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        return mergeSort(sum, 0, len, lower, upper);
    }

    private int mergeSort(long[] sum, int l, int r, int lower, int upper) {
        if (l >= r) {
            return 0;
        }

        int m = (l + r) / 2, ret = mergeSort(sum, l, m, lower, upper) + mergeSort(sum, m + 1, r, lower, upper);
        long[] tmp = new long[r - l + 1];
        int len = 0;
        for (int i = l, lp = m + 1, up = m + 1, j = m + 1; i <= m; i++) {
            while (lp <= r && sum[lp] - sum[i] < lower) {
                lp += 1;
            }
            while (up <= r && sum[up] - sum[i] <= upper) {
                up += 1;
            }
            ret += up - lp;

            while (j <= r && sum[j] < sum[i]) {
                tmp[len++] = sum[j++];
            }
            tmp[len++] = sum[i];
        }
        System.arraycopy(tmp, 0, sum, l, len);
        return ret;
    }
}
