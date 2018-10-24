package com.leetcode.shortestSubarrayWithSumAtLeastK_862;

import java.util.Arrays;
import java.util.Comparator;

public class JumpingSlidingWindow extends Solution {
    @Override
    public int shortestSubarray(int[] A, int K) {
        final int[] sum = new int[A.length];
        for (int i = 0, s = 0; i < A.length; i++) {
            s += A[i];
            sum[i] = s;
        }

        Integer[] tmp = new Integer[A.length + 1];
        tmp[0] = -1;
        int len = 1;

        int[] jump = new int[A.length];
        Arrays.fill(jump, A.length);
        if (A[A.length - 1] < 0) {
            jump[A.length - 1] = A.length - 1;
        }

        for (int i = 0; i < A.length; i++) {
            int a = Arrays.binarySearch(tmp, 0, len, sum[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return (o1 == -1 ? 0 : sum[o1]) - o2;
                }
            });

            if (a >= 0) {
                while (a < len && sum[a] == sum[i]) {
                    a += 1;
                }
            } else {
                a = -(a + 1);
            }
            for (int k = a; k < len; k++) {
                jump[tmp[k] + 1] = i;
            }
            tmp[a] = i;
            len = a + 1;
        }

        int s = 0, b = 0, e = A.length - 1, min = A.length + 1;
        for (int i = 0; i < A.length; i++) {
            s += A[i];
            if (s <= 0) {
                b = i + 1;
                s = 0;
                continue;
            }
            if (s >= K) {
                e = i;
                min = Math.min(min, e - b + 1);
                break;
            }
        }
        if (b >= A.length) {
            return -1;
        }

        while (min > 1 && b < A.length - 1) {
            int nb = b + 1;
            while (nb < A.length && jump[nb] <= e) {
                nb = jump[nb] + 1;
            }

            for (int i = b; i < nb; i++) {
                s -= A[i];
            }
            b = nb;
            int ne = Math.min(min - 2 + b, A.length - 1);
            for (int i = Math.max(e, b); i < A.length && i - b + 1 < min; i++) {
                if (i > e) {
                    s += A[i];
                }
                if (s >= K) {
                    ne = i;
                    min = Math.min(min, ne - b + 1);
                    break;
                }
            }
            e = ne;
        }

        return min > A.length ? -1 : min;
    }
}
