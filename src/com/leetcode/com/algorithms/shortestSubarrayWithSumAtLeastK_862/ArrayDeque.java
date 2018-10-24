package com.leetcode.com.algorithms.shortestSubarrayWithSumAtLeastK_862;

public class ArrayDeque extends Solution {
    @Override
    public int shortestSubarray(int[] A, int K) {
        final int[] sum = new int[A.length + 1];
        sum[0] = 0;
        for (int i = 0, s = 0; i < A.length; i++) {
            s += A[i];
            sum[i + 1] = s;
        }

        int[] q = new int[A.length + 1];
        q[0] = 0;
        int h = 0, t = 1, min = A.length + 1;
        for (int i = 1; i < sum.length; i++) {
            while (h < t && sum[q[h]] <= sum[i] - K) {
                min = Math.min(min, i - q[h]);
                h += 1;
            }

            while (h < t && sum[q[t - 1]] >= sum[i]) {
                t -= 1;
            }

            q[t++] = i;
        }

        return min > A.length ? -1 : min;
    }
}
