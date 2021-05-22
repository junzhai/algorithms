package com.leetcode.algorithms.bestTimetoBuyandSellStockIV_188;

import com.pattern.algorithms.DP;

@DP
public class UseDP extends Solution {
    @Override
    public int maxProfit(int k, int[] prices) {
        if (k < 1) {
            return 0;
        }

        int len = 0;
        int[][] up = new int[prices.length / 2][2];
        for (int i = 1, b = 0; i <= prices.length; i++) {
            if (i == prices.length) {
                if (prices[prices.length - 1] > prices[b]) {
                    up[len++] = new int[]{prices[b], prices[prices.length - 1]};
                }
                continue;
            }

            if (prices[i] < prices[i - 1]) {
                if (prices[i - 1] > prices[b]) {
                    up[len++] = new int[]{prices[b], prices[i - 1]};
                }
                b = i;
            }
        }

        if (len == 0) {
            return 0;
        }

        if (len <= k) {
            int ret = 0;
            for (int i = 0; i < len; i++) {
                ret += up[i][1] - up[i][0];
            }
            return ret;
        }

        int[][] profit1 = new int[len][len];
        for (int i = 0; i < len; i++) {
            int low = up[i][0], maxProfit = up[i][1] - low;
            profit1[i][i] = maxProfit;
            for (int j = i + 1; j < len; j++) {
                low = Math.min(low, up[j][0]);
                maxProfit = Math.max(maxProfit, up[j][1] - low);
                profit1[i][j] = maxProfit;
            }
        }

        int[] dp0 = new int[len], dp1 = new int[len];
        System.arraycopy(profit1[0], 0, dp0, 0, len);

        for (int i = 2; i <= k; i++) {
            for (int j = 0; j < len; j++) {
                dp1[j] = 0;
                for (int l = 0; l <= j; l++) {
                    if (l < j && profit1[l] == profit1[l + 1]) {
                        continue;
                    }
                    dp1[j] = Math.max(dp1[j], (l > 0 ? dp0[l - 1] : 0) + profit1[l][j]);
                }
            }
            int[] tmp = dp0;
            dp0 = dp1;
            dp1 = tmp;
        }

        return dp0[len - 1];
    }
}
