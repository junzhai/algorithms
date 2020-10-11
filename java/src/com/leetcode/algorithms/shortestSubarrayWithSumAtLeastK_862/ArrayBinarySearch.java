package com.leetcode.algorithms.shortestSubarrayWithSumAtLeastK_862;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayBinarySearch extends Solution {
    @Override
    public int shortestSubarray(int[] A, int K) {
        final int[] sum = new int[A.length + 1];
        sum[0] = 0;
        for (int i = 0, s = 0; i < A.length; i++) {
            s += A[i];
            sum[i + 1] = s;
        }

        Integer[] q = new Integer[A.length + 1];
        q[0] = 0;
        int h = 0, t = 1, min = A.length + 1;
        for (int i = 1; i < sum.length; i++) {
            int p = Arrays.binarySearch(q, h, t, sum[i] - K, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return sum[o1] - o2;
                }
            });
            p = p < 0 ? -p - 1 - 1 : p;
            if (p >= h) {
                min = Math.min(min, i - q[p]);
                h = p + 1;
            }

            if (h == t) {
                q[t++] = i;
                continue;
            }

            p = Arrays.binarySearch(q, h, t, sum[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return sum[o1] - o2;
                }
            });

            p = p < 0 ? -p - 1 : p;
            q[p] = i;
            t = p + 1;
        }

        return min > A.length ? -1 : min;
    }
}
