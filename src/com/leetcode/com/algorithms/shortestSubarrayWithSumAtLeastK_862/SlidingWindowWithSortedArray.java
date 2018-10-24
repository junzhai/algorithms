package com.leetcode.com.algorithms.shortestSubarrayWithSumAtLeastK_862;

import java.util.Arrays;
import java.util.Comparator;

public class SlidingWindowWithSortedArray extends Solution {
    @Override
    public int shortestSubarray(int[] A, int K) {
        final int[] sum = new int[A.length];
        for (int i = 0, s = 0; i < A.length; i++) {
            s += A[i];
            sum[i] = s;
        }

        int b = 0, e = A.length - 1, min = A.length + 1, h = 0, t = 0;
        Integer[] buf = new Integer[A.length];
        for (int i = 0, s = 0; i < A.length; i++) {
            s += A[i];
            if (s <= 0) {
                s = 0;
                b = i + 1;
                t = 0;
                continue;
            }
            if (h == t) {
                buf[t++] = i;
            } else if (sum[i] > sum[buf[t - 1]]){
                buf[t++] = i;
            }
            if (s >= K) {
                e = i;
                min = e - b + 1;
                break;
            }
        }

        while (min > 1 && b < A.length - 1) {
            if (h < t && buf[h] == b) {
                h += 1;
            }
            b += 1;

            int ne = Math.min(min + b - 2, A.length - 1);
            if (ne > e) {
                if (h == t) {
                    buf[t++] = ne;
                } else if (sum[ne] > sum[buf[t - 1]]) {
                    buf[t++] = ne;
                }
            }
            e = ne;

            int pos = Arrays.binarySearch(buf, h, t, sum[b - 1] + K, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return sum[o1] - o2;
                }
            });

            pos = pos < 0 ? -pos - 1 : pos;
            if (pos < t) {
                e = buf[pos];
                min = e - b + 1;
                t = pos + 1;
            }
        }

        return min > A.length ? -1 : min;
    }
}
