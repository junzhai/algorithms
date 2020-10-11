package com.leetcode.algorithms.coinChange_322;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BruteForce extends Solution {
    @Override
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Arrays.sort(coins);
        return inner(new HashMap<Integer, int[]>(), coins, coins.length - 1, amount);
    }

    public int inner(Map<Integer, int[]> s, int[] coins, int e, int amount) {
        if (s.containsKey(amount) && s.get(amount)[0] >= e) {
            return s.get(amount)[1];
        }

        int d = coins[e], mod = amount % d, c = amount / d;
        if (mod == 0) {
            s.put(amount, new int[]{e, c});
            return c;
        }

        int r = Integer.MAX_VALUE;
        for (long i = mod; i <= amount; i += d, c -= 1) {
            if (e >= 1) {
                int t = inner(s, coins, e - 1, (int) i);
                if (t > 0) {
                    r = Math.min(r, c + t);
                }
            }
        }

        r = r == Integer.MAX_VALUE ? -1 : r;
        s.put(amount, new int[]{e, r});
        return r;
    }
}
