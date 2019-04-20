package com.leetcode.algorithms.freedomTrail_514;

import java.util.Arrays;

/**
 * Time Limit Exceeded
 */
public class Backtrack extends Solution {
    @Override
    public int findRotateSteps(String ring, String key) {
        int[][] r = new int[26][0];
        for (int i = 0; i < ring.length(); i++) {
            int index = ring.charAt(i) - 'a';
            int[] arry = r[index];
            arry = Arrays.copyOf(arry, arry.length + 1);
            arry[arry.length - 1] = i;
            r[index] = arry;
        }

        char[] k = key.toCharArray();
        int ret = 0, kl = k.length, s = 0, sp = 0;
        int[] min = new int[1];
        for (int i = 0; i < kl; i++) {
            int[] ps = r[k[i] - 'a'];
            if (ps.length > 1) {
                continue;
            }
            min[0] = Integer.MAX_VALUE;
            helper(sp, k, s, i + 1, r, ring.length(), 0, min);
            ret += min[0];
            s = i + 1;
            sp = ps[0];
        }

        if (s < kl) {
            min[0] = Integer.MAX_VALUE;
            helper(sp, k, s, kl, r, ring.length(), 0, min);
            ret += min[0];
        }
        return ret + kl;
    }

    private void helper(int start, char[] key, int b, int e, int[][] ring, int rl, int step, int[] min) {
        if (b >= e) {
            min[0] = Math.min(min[0], step);
            return;
        }

        if (step >= min[0]) {
            return;
        }

        int index = key[b] - 'a';
        for (int p : ring[index]) {
            int t = Math.abs(start - p), s = Math.min(t, rl - t);
            helper(p, key, b + 1, e, ring, rl, step + s, min);
        }
    }
}
