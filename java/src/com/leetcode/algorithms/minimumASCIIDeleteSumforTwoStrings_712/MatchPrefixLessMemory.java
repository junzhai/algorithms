package com.leetcode.algorithms.minimumASCIIDeleteSumforTwoStrings_712;

import com.pattern.algorithms.DP;

import java.util.Arrays;

@DP
public class MatchPrefixLessMemory extends Solution {
    @Override
    public int minimumDeleteSum(String s1, String s2) {
        int len = s1.length(), total = 0;
        int[][] pos = new int[26][0];

        char[] ss1 = s1.toCharArray();
        for (int i = 0; i < len; i++) {
            total += (int) ss1[i];
            int index = ss1[i] - 'a';
            int[] a = pos[index];
            pos[index] = Arrays.copyOf(a, a.length + 1);
            pos[index][a.length] = i;
        }

        int[][] dp0 = new int[len][2], dp1 = new int[len][2];
        int l = 0;

        for (int i = 0; i < s2.length(); i++) {
            int ch = (int) s2.charAt(i);
            total += ch;
            int[] ps = pos[ch - 'a'];
            int a = 0, b = 0, ll = 0;
            while (a < l && b < ps.length) {
                if (dp0[a][0] < ps[b]) {
                    if (ll == 0 || dp0[a][1] > dp1[ll - 1][1]) {
                        dp1[ll][0] = dp0[a][0];
                        dp1[ll][1] = dp0[a][1];
                        ll += 1;
                    }
                    a += 1;
                } else if (dp0[a][0] == ps[b]) {
                    int v = Math.max(dp0[a][1], ch + (a > 0 ? dp0[a - 1][1] : 0));
                    if (ll == 0 || v > dp1[ll - 1][1]) {
                        dp1[ll][0] = ps[b];
                        dp1[ll][1] = v;
                        ll += 1;
                    }
                    a += 1;
                    b += 1;
                } else {
                    int v = ch + (a > 0 ? dp0[a - 1][1] : 0);
                    if (ll == 0 || v > dp1[ll - 1][1]) {
                        dp1[ll][0] = ps[b];
                        dp1[ll][1] = v;
                        ll += 1;
                    }
                    b += 1;
                }
            }
            while (a < l) {
                if (ll == 0 || dp0[a][1] > dp1[ll - 1][1]) {
                    dp1[ll][0] = dp0[a][0];
                    dp1[ll][1] = dp0[a][1];
                    ll += 1;
                }
                a += 1;
            }
            if (b < ps.length) {
                int v = ch + (l > 0 ? dp0[l - 1][1] : 0);
                if (ll == 0 || v > dp1[ll - 1][1]) {
                    dp1[ll][0] = ps[b];
                    dp1[ll][1] = v;
                    ll += 1;
                }
            }

            int[][] tmp = dp0;
            dp0 = dp1;
            l = ll;
            dp1 = tmp;
        }

        return total - (l > 0 ? (dp0[l - 1][1] << 1) : 0);
    }
}
