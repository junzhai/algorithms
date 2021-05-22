package com.leetcode.algorithms.minimumScoreTriangulationofPolygon_1039;

import com.pattern.algorithms.DP;
import org.junit.Assert;

@DP
public class Solution {
    public int minScoreTriangulation(int[] A) {
        int len = A.length;
        int[][] dp = new int[len][len];
        for (int n = 3; n <= len; n++) {
            for (int i = 0; i <= len - n; i++) {
                int j = (i + n - 1) % len, v = A[i] * A[j], min = Integer.MAX_VALUE;
                for (int k = 1; k < n - 1; k++) {
                    int p = (i + k) % len;
                    min = Math.min(min, dp[i][p] + A[p] * v + dp[p][j]);
                }
                dp[i][j] = min;
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;
        ret = s.minScoreTriangulation(new int[]{3, 7, 4, 5});
        Assert.assertEquals(144, ret);

        ret = s.minScoreTriangulation(new int[]{1, 2, 3});
        Assert.assertEquals(6, ret);
    }
}
