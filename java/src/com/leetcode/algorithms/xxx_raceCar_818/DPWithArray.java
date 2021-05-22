package com.leetcode.algorithms.xxx_raceCar_818;

import com.pattern.algorithms.DP;

import java.util.Arrays;

@DP
public class DPWithArray extends Solution {
    @Override
    public int racecar(int target) {
        int max = 0;
        for (int speed = 1; max <= target; speed <<= 1) {
            max += speed;
        }
        int[] dp = new int[max + 1], direction = new int[max + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = -2;
        direction[0] = 1;

        boolean[] processed = new boolean[max + 1];

        for (int i = 0; i <= max; i++) {
            if (processed[i]) {
                continue;
            }

            int ni = i;
            for (int speed = -1, p = i, op = dp[i] + ((direction[i] & 1) > 0 ? 1 : 2); p + speed > 0; speed <<= 1) {
                op += 1;
                p += speed;
                if (op < dp[p]) {
                    dp[p] = op;
                    direction[p] = 2;
                    processed[p] = false;
                    ni = p;
                } else if (op == dp[p] && direction[p] == 1) {
                    direction[p] |= 2;
                    processed[p] = false;
                    ni = p;
                }
            }

            for (int speed = 1, p = i, op = dp[i] + ((direction[i] & 2) > 0 ? 1 : 2); p + speed <= max; speed <<= 1) {
                op += 1;
                p += speed;
                if (op < dp[p]) {
                    dp[p] = op;
                    direction[p] = 1;
                    processed[p] = false;
                } else if (op == dp[p] && direction[p] == 2) {
                    direction[p] |= 1;
                    processed[p] = false;
                }
            }
            processed[i] = true;
            if (ni < i) {
                i = ni - 1;
            }
        }
        return dp[target];
    }
}