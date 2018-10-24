package com.leetcode.com.algorithms.burstBalloons_312;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstBurstIterativeDP extends Solution {
    @Override
    public int maxCoins(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> in = new HashMap<>(), out = new HashMap<>();
        for (int n : nums) {
            in.put(Arrays.hashCode(new int[]{n}), n);
        }

        for (int i = 2; i <= nums.length; i++) {
            combination(nums, 0, i, 0, new int[i - 1], new int[i], in, out);
            in.clear();
            Map<Integer, Integer> p = in;
            in = out;
            out = p;
        }
        return in.entrySet().iterator().next().getValue();
    }

    private void combination(int[] nums,
                             int s,
                             int t,
                             int k,
                             int[] inKey,
                             int[] outKey,
                             Map<Integer, Integer> in,
                             Map<Integer, Integer> out) {
        if (k == t) {
            int max = 0;
            for (int i = 0; i < t; i++) {
                int m = (i > 0 ? outKey[i - 1] : 1) * outKey[i] * (i + 1 < t ? outKey[i + 1] : 1);
                System.arraycopy(outKey, 0, inKey, 0, i);
                System.arraycopy(outKey, i + 1, inKey, i, t - 1 - i);
                max = Math.max(max, in.get(Arrays.hashCode(inKey)) + m);
            }
            out.put(Arrays.hashCode(outKey), max);
            return;
        }

        for (int i = s; i <= nums.length - t + k; i++) {
            outKey[k] = nums[i];
            combination(nums, i + 1, t, k + 1, inKey, outKey, in, out);
        }
    }
}
