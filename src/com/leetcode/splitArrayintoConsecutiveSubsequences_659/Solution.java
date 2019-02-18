package com.leetcode.splitArrayintoConsecutiveSubsequences_659;

import org.junit.Assert;

public class Solution {
    public boolean isPossible(int[] nums) {
        int[] count = new int[nums.length];
        int b = 0, len = 0, v = 0, i = 0;
        while (i < nums.length) {
            int cur = nums[i], c = 1;
            while (i + 1 < nums.length && nums[i + 1] == cur) {
                i += 1;
                c += 1;
            }

            if (len > 0 && v + 1 < cur) {
                for (int j = 0; j < len; j++) {
                    if (count[b + j] < 3) {
                        return false;
                    }
                }
                b = 0;
                len = 0;
            }

            for (int j = 0; j < len - c; j++) {
                if (count[b + j] < 3) {
                    return false;
                }
            }

            if (c < len) {
                b += len - c;
            }

            for (int j = 0; j < c; j++) {
                count[b + j] += 1;
            }
            len = c;
            v = cur;
            i += 1;
        }

        for (int j = 0; j < len; j++) {
            if (count[b + j] < 3) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean ret;

        ret = s.isPossible(new int[]{1});
        Assert.assertEquals(false, ret);

        ret = s.isPossible(new int[]{1, 2, 4});
        Assert.assertEquals(false, ret);

        ret = s.isPossible(new int[]{1, 2, 3});
        Assert.assertEquals(true, ret);

        ret = s.isPossible(new int[]{1, 2, 3, 3, 4, 5});
        Assert.assertEquals(true, ret);

        ret = s.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5});
        Assert.assertEquals(true, ret);

        ret = s.isPossible(new int[]{1, 2, 3, 4, 4, 5});
        Assert.assertEquals(false, ret);
    }
}
