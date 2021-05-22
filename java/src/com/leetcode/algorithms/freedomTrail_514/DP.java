package com.leetcode.algorithms.freedomTrail_514;

import java.util.Arrays;

@com.pattern.algorithms.DP
public class DP extends Solution {
    @Override
    public int findRotateSteps(String ring, String key) {
        int[][] r = new int[26][0];
        int max = 0, rl = ring.length(), kl = key.length();
        for (int i = 0; i < rl; i++) {
            int index = ring.charAt(i) - 'a';
            int[] arry = r[index];
            arry = Arrays.copyOf(arry, arry.length + 1);
            arry[arry.length - 1] = i;
            r[index] = arry;
            max = Math.max(max, arry.length);
        }

        int[] dp0 = new int[max], dp1 = new int[max], pps = r[key.charAt(0) - 'a'];
        for (int i = 0; i < pps.length; i++) {
            dp0[i] = dist(0, pps[i], rl);
        }

        for (int i = 1; i < kl; i++) {
            int[] ps = r[key.charAt(i) - 'a'];
            for (int j = 0; j < ps.length; j++) {
                dp1[j] = Integer.MAX_VALUE;
                for (int k = 0; k < pps.length; k++) {
                    dp1[j] = Math.min(dp1[j], dp0[k] + dist(pps[k], ps[j], rl));
                }
            }
            pps = ps;
            int[] tmp = dp0;
            dp0 = dp1;
            dp1 = tmp;
        }

        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < pps.length; i++) {
            ret = Math.min(ret, dp0[i]);
        }

        return ret + kl;
    }

    private int dist(int a, int b, int len) {
        int t = Math.abs(a - b);
        return Math.min(t, len - t);
    }
}
