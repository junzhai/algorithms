package com.leetcode.algorithms.bestTimetoBuyandSellStockwithCooldown_309;


import com.leetcode.algorithms.pattern.DP;

import static org.junit.Assert.assertEquals;

@DP
public class Solution {
    public int maxProfit(int[] prices) {
        boolean pre = false;
        int[][] buf = new int[prices.length][2];
        int ret = 0, len = 0;
        for (int i = 1; i < prices.length; i++) {
            int d = prices[i] - prices[i - 1];
            if (d > 0) {
                if (pre) {
                    ret += cal(buf, len);
                    len = 0;
                }
                buf[len++][0] = d;
                pre = true;
            } else if (d < 0) {
                if (pre) {
                    buf[len - 1][1] = -d;
                } else {
                    ret += cal(buf, len);
                    len = 0;
                }
                pre = false;
            } else {
                ret += cal(buf, len);
                len = 0;
                pre = false;
            }
        }

        ret += cal(buf, len);
        return ret;
    }

    private int cal(int[][] buf, int len) {
        if (len <= 0) {
            return 0;
        }

        buf[len - 1][1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            buf[i][0] = Math.max(buf[i][0] + buf[i + 1][1], buf[i][0] - buf[i][1] + buf[i + 1][0]);
            buf[i][1] = Math.max(buf[i + 1][0], buf[i + 1][1]);
        }
        return Math.max(buf[0][0], buf[0][1]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;

        ret = s.maxProfit(new int[]{1, 4, 7, 5, 6, 2, 5, 1, 9, 7, 9, 7, 0, 6, 8});
        assertEquals(22, ret);

        ret = s.maxProfit(new int[]{5, 7, 2, 7, 3, 3, 5, 3, 0});
        assertEquals(7, ret);

        ret = s.maxProfit(new int[]{2, 1, 4, 5, 2, 9, 7});
        assertEquals(10, ret);
    }
}
