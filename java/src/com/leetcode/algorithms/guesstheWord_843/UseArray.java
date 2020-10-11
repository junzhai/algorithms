package com.leetcode.algorithms.guesstheWord_843;

import java.util.Arrays;

public class UseArray extends Solution {
    @Override
    public void findSecretWord(String[] wordlist, Master master) {
        int len = wordlist.length, min = len, pick = 0, rl = 0;
        int[][] relation = new int[len][len];
        int[] remaining = new int[len], count = new int[7];

        for (int i = 0; i < len; i++) {
            relation[i][i] = 6;
            for (int j = i + 1; j < len; j++) {
                int c = comp(wordlist[i], wordlist[j]);
                relation[i][j] = c;
                relation[j][i] = c;
            }

            remaining[rl++] = i;

            for (int j = 0; j < len; j++) {
                int index = relation[i][j];
                count[index] += 1;
            }

            int max = 0;
            for (int j = 0; j < 6; j++) {
                max = Math.max(max, count[j]);
            }

            Arrays.fill(count, 0);
            if (max < min) {
                min = max;
                pick = i;
            }
        }

        for (int i = 0; i < 10; i++) {
            int match = master.guess(wordlist[pick]);
            if (match == 6) {
                break;
            }

            int nrl = 0;
            for (int j = 0; j < rl; j++) {
                int index = remaining[j];
                if (relation[pick][index] == match) {
                    remaining[nrl++] = index;
                }
            }
            rl = nrl;

            min = rl;
            for (int j = 0; j < rl; j++) {
                int jj = remaining[j];
                Arrays.fill(count, 0);
                for (int k = 0; k < rl; k++) {
                    int kk = remaining[k];
                    int index = relation[jj][kk];
                    count[index] += 1;
                }
                int max = 0;
                for (int k = 0; k < 6; k++) {
                    max = Math.max(max, count[k]);
                }
                if (max < min) {
                    min = max;
                    pick = jj;
                }
            }
        }
    }

    private int comp(String a, String b) {
        int ret = 0;
        for (int i = 0; i < 6; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                ret += 1;
            }
        }
        return ret;
    }
}
