package com.leetcode.algorithms.numbersWithSameConsecutiveDifferences_967;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> ret = new ArrayList<>();
        for (int i = N > 1 ? 1 : 0; i < 10; i++) {
            helper(N, K, 1, i, i, ret);
        }

        int[] r = new int[ret.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = ret.get(i);
        }
        return r;
    }

    private void helper(int N, int K, int i, int v, int d, List<Integer> ret) {
        if (i == N) {
            ret.add(v);
            return;
        }

        if (K == 0) {
            helper(N, K, i + 1, v * 10 + d, d, ret);
            return;
        }

        if (d >= K) {
            helper(N, K, i + 1, v * 10 + d - K, d - K, ret);
        }

        if (d + K < 10) {
            helper(N, K, i + 1, v * 10 + d + K, d + K, ret);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ret;

        ret = s.numsSameConsecDiff(2, 0);
        Assert.assertEquals(9, ret.length);

        ret = s.numsSameConsecDiff(1, 0);
        Assert.assertEquals(10, ret.length);

        ret = s.numsSameConsecDiff(3, 7);
        Assert.assertEquals(5, ret.length);
    }

}
