package com.leetcode.algorithms.bestTimetoBuyandSellStockIV_188;

public class DirectCalculateUsingArray extends Solution {
    @Override
    public int maxProfit(int k, int[] prices) {
        if (k < 1 || prices.length == 0) {
            return 0;
        }

        int len = prices.length, low = prices[0], high = 0, ret = 0, count = 0, l = 0;
        int[] profit = new int[len];
        for (int i = 1; i < len; i++) {
            if (prices[i] < prices[i - 1]) {
                if (prices[i - 1] > low) {
                    if (high > low) {
                        profit[l++] = high - low;
                    }
                    high = prices[i - 1];
                    ret += high - low;
                    profit[l++] = high - low;
                    count += 1;
                }
                low = prices[i];
            }
        }

        if (prices[len - 1] > low) {
            if (high > low) {
                profit[l++] = high - low;
            }
            ret += prices[len - 1] - low;
            profit[l++] = prices[len - 1] - low;
            count += 1;
        }

        for (int i = 0, b = 0; i < count - k; i++) {
            int min = profit[b], picked = b;
            for (int j = b + 1; j < l; j++) {
                if (profit[j] < min) {
                    min = profit[j];
                    picked = j;
                }
            }

            ret -= min;
            if (picked == l - 1) {
                l -= 2;
            } else if (picked == b) {
                b += 2;
            } else if (picked == b + 1) {
                b += 2;
                profit[b] = profit[picked - 1] + profit[picked + 1] - profit[picked];
            } else {
                profit[picked - 1] = profit[picked - 1] + profit[picked + 1] - profit[picked];
                System.arraycopy(profit, picked + 2, profit, picked, l - picked - 2);
                l -= 2;
            }
        }
        return ret;
    }
}
