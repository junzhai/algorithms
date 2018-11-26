package com.leetcode.validPermutationsForDISequence_903;

import org.junit.Assert;

// Time Limit Exceeded
public class BruteForce extends Solution {
    @Override
    public int numPermsDISequence(String S) {
        boolean[] selected = new boolean[S.length() + 1];
        int ret = 0;
        for (int i = 0; i < selected.length; i++) {
            selected[i] = true;
            ret += helper(S, 1, "", i, selected);
            selected[i] = false;
        }
        return ret;
    }

    private int helper(String S, int index, String a, int v, boolean[] selected) {
        String aa = a + v;
        if (index >= selected.length) {
            System.out.println(aa);
            return 1;
        }

        int ret = 0;
        char ch = S.charAt(index - 1);
        if (ch == 'D') {
            for (int i = 0; i < v; i++) {
                if (!selected[i]) {
                    selected[i] = true;
                    ret += helper(S, index + 1, aa, i, selected);
                    selected[i] = false;
                }
            }
        } else {
            for (int i = v + 1; i < selected.length; i++) {
                if (!selected[i]) {
                    selected[i] = true;
                    ret += helper(S, index + 1, aa, i, selected);
                    selected[i] = false;
                }
            }
        }
        return ret;
    }
}