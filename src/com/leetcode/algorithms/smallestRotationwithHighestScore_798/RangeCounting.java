package com.leetcode.algorithms.smallestRotationwithHighestScore_798;

import com.leetcode.algorithms.pattern.RangeOrInterval;

import java.util.Arrays;

@RangeOrInterval
/**
 * NlogN
 */
public class RangeCounting extends Solution {
    @Override
    public int bestRotation(int[] A) {
        int len = A.length, l = len << 1;
        int[] s = new int[l], e = new int[l];
        l = 0;
        for (int i = 0; i < len; i++) {
            if (i < A[i]) {
                s[l] = i + 1;
                e[l] = i - A[i] + len;
                l += 1;
            } else {
                s[l] = 0;
                e[l] = i - A[i];
                l += 1;
                if (i < len - 1) {
                    s[l] = i + 1;
                    e[l] = len - 1;
                    l += 1;
                }
            }
        }

        Arrays.sort(s, 0, l);
        Arrays.sort(e, 0, l);

        int ret = 0, max = 0;
        for (int i = 0, si = 0, ei = 0; i < len; i++) {
            while (si < l && s[si] <= i) {
                si += 1;
            }
            while (ei < l && e[ei] < i) {
                ei += 1;
            }
            if (si - ei > max) {
                max = si - ei;
                ret = i;
            }
        }

        return ret;
    }
}
