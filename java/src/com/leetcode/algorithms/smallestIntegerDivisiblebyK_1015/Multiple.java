package com.leetcode.algorithms.smallestIntegerDivisiblebyK_1015;

public class Multiple extends Solution {
    @Override
    public int smallestRepunitDivByK(int K) {
        int len = 0;
        int[] k = new int[6];
        while (K > 0) {
            k[len++] = K % 10;
            K /= 10;
        }

        int[] d = new int[10];
        for (int i = 0; i < 10; i++) {
            d[i] = -1;
            for (int j = 0; j < 10; j++) {
                if ((i + j * k[0]) % 10 == 1) {
                    d[i] = j;
                    break;
                }
            }
        }

        int ret = 0, adv = 0;
        int[] dp = new int[len];

        while (true) {
            for (int i = ret - 1; i >= Math.max(0, ret - len + 1); i--) {
                adv += dp[i % len] * k[ret - i];
            }
            if (adv == 0 && ret >= len) {
                break;
            }
            int r = adv % 10;
            if (d[r] == -1) {
                return -1;
            }
            dp[ret % len] = d[r];
            ret += 1;
            adv += d[r] * k[0];
            adv /= 10;
        }
        return ret;
    }
}
