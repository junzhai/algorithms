package com.leetcode.validPermutationsForDISequence_903;

import java.util.Arrays;

// 发现迭代，但发散。Time Limit Exceeded
public class DP extends Solution {
    @Override
    public int numPermsDISequence(String S) {
        int[] s = new int[S.length()];
        s[0] = 2;
        char pre = S.charAt(0);
        int l = 0, max = 0;
        for (int i = 1; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (pre == ch) {
                s[l] += 1;
            } else {
                l += 1;
                s[l] = 2;
                pre = ch;
            }
            max = Math.max(max, s[l]);
        }

        long[][] bp = new long[S.length() + 1][max];
        Arrays.fill(bp[0], 1);
        for (int b = 1; b < bp.length; b++) {
            for (int p = 0; p < bp[b].length; p++) {
                if (p == 0) {
                    bp[b][p] = 1;
                } else {
                    bp[b][p] = bp[b][p - 1] + bp[b - 1][p];
                }
            }
        }

        boolean inc = S.charAt(0) == 'I';
        return helper(s[0], inc ? s[0] - 1 : 0, !inc, s, 1, l, bp, (int) Math.pow(10, 9) + 7);
    }

    private int helper(int total, int index, boolean inc, int[] s, int b, int e, long[][] bp, int m) {
        if (b > e) {
            return 1;
        }

        int count = s[b] - 1;
        if (b == e) {
            if (inc) {
                return (int) bp[total - index - 1][count];
            } else {
                return (int) bp[index][count];
            }
        }

        int ret = 0;
        if (inc) {
            for (int i = 0; i < total - index; i++) {
                long ff = bp[i][count - 1];
                ret += helper(total + count, index + i + count, false, s, b + 1, e, bp, m) * ff % m;
                ret %= m;
            }
        } else {
            for (int i = 0; i <= index; i++) {
                long ff = bp[i][count - 1];
                ret += helper(total + count, index - i, true, s, b + 1, e, bp, m) * ff % m;
                ret %= m;
            }
        }
        return ret % m;
    }
}
