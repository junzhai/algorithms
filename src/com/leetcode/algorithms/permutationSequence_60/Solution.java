package com.leetcode.algorithms.permutationSequence_60;

import org.junit.Assert;

public class Solution {
    public String getPermutation(int n, int k) {
        String ret = "";
        int total = n;
        boolean[] nums = new boolean[n];

        while (total > 0) {
            int i = 1, m = 1;
            while (i < n && k > m) {
                i += 1;
                m *= i;
            }

            ret += getFirst(nums, total - i);

            int diff = m / i, c = 1;
            while (k > diff) {
                k -= diff;
                c += 1;
            }

            ret += get(nums, c);
            total = i - 1;
        }

        return ret;
    }

    private String get(boolean[] nums, int n) {
        for (int i = 0, c = 0; i < nums.length; i++) {
            if (nums[i]) {
                continue;
            }
            c += 1;
            if (c == n) {
                nums[i] = true;
                return (i + 1) + "";
            }
        }
        throw new IllegalStateException();
    }

    private String getFirst(boolean[] nums, int n) {
        String ret = "";
        for (int i = 0, c = 0; i < nums.length && c < n; i++) {
            if (nums[i]) {
                continue;
            }
            nums[i] = true;
            ret += (i + 1) + "";
            c += 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ret;

        ret = s.getPermutation(4, 24);
        Assert.assertEquals("4321", ret);

        ret = s.getPermutation(4, 9);
        Assert.assertEquals("2314", ret);

        ret = s.getPermutation(4, 1);
        Assert.assertEquals("1234", ret);

        ret = s.getPermutation(3, 5);
        Assert.assertEquals("312", ret);

        ret = s.getPermutation(3, 6);
        Assert.assertEquals("321", ret);

        ret = s.getPermutation(3, 1);
        Assert.assertEquals("123", ret);

        ret = s.getPermutation(3, 3);
        Assert.assertEquals("213", ret);

        ret = s.getPermutation(3, 4);
        Assert.assertEquals("231", ret);
    }
}
