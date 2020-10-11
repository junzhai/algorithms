package com.leetcode.algorithms.splitArrayLargestSum_410;

import com.leetcode.algorithms.pattern.DP;
import org.junit.Assert;

@DP
public class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[m][n];
        for (int i = 0, s = 0; i < n - m + 1; i++) {
            s += nums[i];
            dp[0][i] = s;
        }

        for (int i = 1, max = nums[0]; i < m; i++) {
            max = Math.max(max, nums[i]);
            dp[i][i] = max;
            for (int j = i + 1; j <= n - m + i; j++) {
                int l = nums[j], v = Integer.MAX_VALUE;
                for (int k = j - 1; k >= i - 1; k--) {
                    if (l >= dp[i - 1][k]) {
                        v = Math.min(v, l);
                        break;
                    } else {
                        v = dp[i - 1][k];
                    }
                    l += nums[k];
                }
                dp[i][j] = v;
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;

        ret = s.splitArray(new int[]{2, 3, 1, 2, 4, 3}, 5);
        Assert.assertEquals(4, ret);

        ret = s.splitArray(new int[]{1, 2147483647}, 2);
        Assert.assertEquals(2147483647, ret);

        ret = s.splitArray(new int[]{7, 2, 5, 10, 8}, 2);
        Assert.assertEquals(18, ret);
    }
}
