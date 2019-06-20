package com.leetcode.algorithms.xxx_raceCar_818;

import com.leetcode.algorithms.pattern.DP;

@DP
/**
 * 没有证明
 */
public class UseDP4 extends Solution {
    @Override
    public int racecar(int target) {
        int[] dp = new int[target + 1];

        for (int i = 1; i <= target; i++) {
            int speed = 1, op = 0, pos = 0;
            while (pos + speed < i) {
                pos += speed;
                speed <<= 1;
                op += 1;
            }

            if (pos + speed == i) {
                dp[i] = op + 1;
                continue;
            }

            dp[i] = op + 1 + 1 + dp[speed + pos - i];
            dp[i] = Math.min(dp[i], op + 1 + 1 + dp[i - pos]);
            speed = 1;
            for (int j = 1; j < op; j++, speed <<= 1) {
                pos -= speed;
                dp[i] = Math.min(dp[i], op + 1 + j + 1 + dp[i - pos]);
            }
        }
        return dp[target];
    }
}