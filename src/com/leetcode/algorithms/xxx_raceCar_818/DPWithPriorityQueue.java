package com.leetcode.algorithms.xxx_raceCar_818;

import com.leetcode.algorithms.pattern.DP;

import java.util.Arrays;
import java.util.PriorityQueue;

@DP
public class DPWithPriorityQueue extends Solution {
    @Override
    public int racecar(int target) {
        int max = 0;
        for (int speed = 1; max <= target; speed <<= 1) {
            max += speed;
        }
        int[] dp = new int[max + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = -2;

        boolean[] direction = new boolean[max + 1], inQueue = new boolean[max + 1];
        inQueue[0] = true;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(0);

        while (!q.isEmpty()) {
            int cur = q.poll();
            inQueue[cur] = false;
            for (int speed = 1, op = dp[cur] + (direction[cur] ? 1 : 2), pos = cur; pos + speed <= max; ) {
                op += 1;
                pos += speed;
                speed <<= 1;
                if (op < dp[pos]) {
                    dp[pos] = op;
                    direction[pos] = false;
                    if (!inQueue[pos]) {
                        q.offer(pos);
                        inQueue[pos] = true;
                    }
                }
            }

            for (int speed = -1, op = dp[cur] + (direction[cur] ? 2 : 1), pos = cur; pos + speed > 0; ) {
                op += 1;
                pos += speed;
                speed <<= 1;
                if (op < dp[pos] || op == dp[pos] && !direction[pos]) {
                    dp[pos] = op;
                    direction[pos] = true;
                    if (!inQueue[pos]) {
                        q.offer(pos);
                        inQueue[pos] = true;
                    }
                }
            }
        }
        return dp[target];
    }
}