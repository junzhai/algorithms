package com.leetcode.algorithms.validPermutationsForDISequence_903;

import com.pattern.DP;

@DP
// 限制发散。
public class DP1 extends Solution {
    @Override
    public int numPermsDISequence(String S) {
        int m = (int) Math.pow(10, 9) + 7;
        int[] s = new int[S.length() + 1];
        s[0] = 1;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == 'D') {
                for (int k = i, sum = 0; k >= 0; k--) {
                    sum += s[k];
                    sum %= m;
                    s[k] = sum;
                }
            } else {
                for (int k = 0, sum = 0; k <= i + 1; k++) {
                    int tmp = sum;
                    sum += s[k];
                    sum %= m;
                    s[k] = tmp;
                }
            }
        }

        int ret = 0;
        for (int v : s) {
            ret += v;
            ret %= m;
        }

        return ret;
    }
}
