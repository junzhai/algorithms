package com.leetcode.algorithms.xxx_countofRangeSum_327;

import com.leetcode.algorithms.pattern.BinaryIndexedTree;

import java.util.Arrays;

@BinaryIndexedTree
public class RollingSuminBIT extends Solution {
    @Override
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length, ret = 0, l = 0;
        long[] sum = new long[len];

        for (int i = 0; i < len; i++) {
            sum[i] = (i == 0 ? 0 : sum[i - 1]) + nums[i];
        }

        Arrays.sort(sum);

        int[] bit = new int[len + 1];
        long s = 0;
        for (int i = 0; i < len; i++) {
            s += nums[i];
            update(bit, Arrays.binarySearch(sum, s), 1);
        }

        int p = Arrays.binarySearch(sum, upper);
        if (p < 0) {
            p = -p - 2;
        } else {
            while (p + 1 < len && sum[p + 1] == sum[p]) {
                p += 1;
            }
        }

        ret += query(bit, p);

        p = Arrays.binarySearch(sum, lower);
        if (p < 0) {
            p = -p - 2;
        } else {
            while (p >= 0 && sum[p] == lower) {
                p -= 1;
            }
        }

        ret -= query(bit, p);

        s = 0;
        for (int i = 0; i < len; i++) {
            s += nums[i];
            update(bit, Arrays.binarySearch(sum, s), -1);

            p = Arrays.binarySearch(sum, s + upper);
            if (p < 0) {
                p = -p - 2;
            } else {
                while (p + 1 < len && sum[p + 1] == sum[p]) {
                    p += 1;
                }
            }

            ret += query(bit, p);

            p = Arrays.binarySearch(sum, s + lower);
            if (p < 0) {
                p = -p - 2;
            } else {
                while (p >= 0 && sum[p] == s + lower) {
                    p -= 1;
                }
            }

            ret -= query(bit, p);
        }
        return ret;
    }

    private void update(int[] bit, int index, int v) {
        int len = bit.length, i = index + 1;
        while (i < len) {
            bit[i] += v;
            i += i & -i;
        }
    }

    private int query(int[] bit, int index) {
        int i = index + 1, ret = 0;
        while (i > 0) {
            ret += bit[i];
            i -= i & -i;
        }
        return ret;
    }
}
