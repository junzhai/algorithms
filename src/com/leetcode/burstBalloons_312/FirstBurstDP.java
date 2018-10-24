package com.leetcode.burstBalloons_312;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstBurstDP extends Solution {
    @Override
    public int maxCoins(int[] nums) {
        int l = nums.length;
        int[] val = new int[l + 2], next = new int[l + 2], pre = new int[l + 2];
        val[0] = 1;
        val[l + 1] = 1;
        System.arraycopy(nums, 0, val, 1, l);
        for (int i = 0; i < l + 2; i++) {
            next[i] = i + 1;
            pre[i] = i - 1;
        }
        next[l + 1] = -1;

        Map<Integer, Integer> a = new HashMap<>();
        int ret = inner(val, next, pre, a);


        return ret;
    }

    private int inner(int[] val, int[] next, int[] pre, Map<Integer, Integer> dp) {
        int l = val.length - 2;
        if (next[0] < 1 || next[0] > l) {
            return 0;
        }

        int k = Arrays.hashCode(val);
        if (dp.containsKey(k)) {
            return dp.get(k);
        }

        int ret = 0, i = 0;
        while (next[i] >= 1 && next[i] <= l) {
            i = next[i];
            int v = val[i], nx = next[i], pr = pre[i];

            pre[nx] = pr;
            next[pr] = nx;
            val[i] = -1;

            int g = v * val[nx] * val[pr];
            g += inner(val, next, pre, dp);
            ret = Math.max(ret, g);

            pre[nx] = i;
            next[pr] = i;
            val[i] = v;
        }
        dp.put(k, ret);
        return ret;
    }
}
