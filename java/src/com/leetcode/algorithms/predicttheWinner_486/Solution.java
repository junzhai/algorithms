package com.leetcode.algorithms.predicttheWinner_486;

import com.pattern.algorithms.DP;
import org.junit.Assert;

@DP
public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i + 1 < len; i++) {
            dp[i][i + 1] = Math.abs(nums[i] - nums[i + 1]);
        }

        for (int i = 2; i < len; i++) {
            for (int j = 0; j + i < len; j++) {
                dp[j][j + i] = Math.max(nums[j + i] - dp[j][j + i - 1], nums[j] - dp[j + 1][j + i]);
            }
        }

        return dp[0][len - 1] >= 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean ret;

        ret = s.PredictTheWinner(new int[]{2, 4, 55, 6, 8});
        Assert.assertEquals(false, ret);
    }
}
