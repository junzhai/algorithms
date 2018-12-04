package com.leetcode.countDifferentPalindromicSubsequences_730;

import com.pattern.DP;

@DP
@com.pattern.Histogram
/**
 * Barely passed，几乎超时
 */
public class Histogram extends Solution {
    @Override
    public int countPalindromicSubsequences(String S) {
        int len = S.length(), m = (int) Math.pow(10, 9) + 7, ret = 0;
        int[][] pos = new int[4][len], countChar = new int[len][4];
        int[] total = new int[4];
        for (int i = 0; i < len; i++) {
            int index = S.charAt(i) - 'a';
            pos[index][total[index]] = i;
            total[index] += 1;
            if (i > 0) {
                System.arraycopy(countChar[i - 1], 0, countChar[i], 0, 4);
            }
            countChar[i][index] += 1;
        }

        for (int i = 0; i < 4; i++) {
            if (total[i] > 0) {
                ret += 1;
            }
        }

        int[] countPalin = new int[len], one = new int[len], p = new int[4];
        int[][] delta = new int[len][len];
        for (int i = 0; i < len; i++) {
            int index = S.charAt(i) - 'a';
            for (int col = p[index] + 1; col < total[index]; col++) {
                int deltaSum = 0;
                for (int row = p[index]; row > 0; row--) {
                    int v = col + 1 < total[index] ? delta[pos[index][row - 1]][pos[index][col + 1]] : 0;
                    delta[pos[index][row]][pos[index][col]] = v;
                    deltaSum += v;
                    deltaSum %= m;
                }

                int n = col + 1 < total[index] ? pos[index][col + 1] : len;
                int oneSum = col + 1 < total[index] ? 0 : 1;
                for (int k = pos[index][col] + 1; k < n; k++) {
                    oneSum += countPalin[k];
                    oneSum %= m;
                }

                int oneDelta = (oneSum - one[pos[index][col]]) % m;
                delta[pos[index][0]][pos[index][col]] = oneDelta;

                one[pos[index][col]] += oneDelta % m;
                one[pos[index][col]] %= m;

                deltaSum += oneDelta;
                deltaSum %= m;

                countPalin[pos[index][col]] += deltaSum;
                countPalin[pos[index][col]] %= m;

                long a = (long) deltaSum * unique(countChar, index, pos[index][p[index]], pos[index][col]);
                int b = (int) Math.floorMod(a, m);
                ret += b;
                ret %= m;
            }

            p[index] += 1;
        }

        return ret;
    }

    private int unique(int[][] countChar, int index, int b, int e) {
        int ret = 1;
        for (int k = 0; k < 4; k++) {
            if (k == index && countChar[e][k] - countChar[b][k] > 1
                    || k != index && countChar[e][k] - countChar[b][k] > 0) {
                ret += 1;
            }
        }
        return ret;
    }
}
