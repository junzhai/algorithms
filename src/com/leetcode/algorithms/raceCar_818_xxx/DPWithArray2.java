package com.leetcode.algorithms.raceCar_818_xxx;

import com.leetcode.algorithms.pattern.DP;

import java.util.Arrays;

@DP
public class DPWithArray2 extends Solution {
    @Override
    public int racecar(int target) {
        int max = target + target / 2;
        int[] dp = new int[max + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = -2;

        boolean[] forward = new boolean[max + 1], backward = new boolean[max + 1], direction = new boolean[max + 1];
        boolean forwarding = true, done = false;
        while (!done) {
            done = true;
            if (forwarding) {
                for (int i = 0; i <= max; i++) {
                    if (forward[i]) {
                        continue;
                    }

                    for (int speed = 1, p = i, op = dp[i] + (direction[i] ? 1 : 2); p + speed <= max; speed <<= 1) {
                        op += 1;
                        p += speed;
                        if (op <= dp[p]) {
                            dp[p] = op;
                            direction[p] = false;
                            backward[p] = false;
                            done = false;
                        }
                    }
                    forward[i] = true;
                }
            } else {
                for (int i = max; i > 0; i--) {
                    if (backward[i]) {
                        continue;
                    }

                    for (int speed = -1, p = i, op = dp[i] + (direction[i] ? 2 : 1); p + speed > 0; speed <<= 1) {
                        op += 1;
                        p += speed;
                        if (op <= dp[p]) {
                            dp[p] = op;
                            direction[p] = true;
                            forward[p] = false;
                            done = false;
                        }
                    }
                    backward[i] = true;
                }
            }
            forwarding = !forwarding;
        }
        return dp[target];
    }
}