package com.leetcode.algorithms.jumpGameII_45;

import com.pattern.algorithms.DP;
import org.junit.Assert;

@DP
public class Solution {
    public int jump(int[] nums) {
        int len = nums.length, jump = 0;
        for (int i = 0, upper = 0, newUpper = 0; newUpper < len - 1; i++) {
            if (i > upper) {
                upper = newUpper;
                newUpper = 0;
                jump += 1;
            }
            newUpper = Math.max(newUpper, i + nums[i]);
        }
        return jump + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;
        ret = s.jump(new int[]{2, 3, 1, 1, 4});
        Assert.assertEquals(2, ret);
    }
}
