package com.leetcode.algorithms.guesstheWord_843;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UseSet extends Solution {
    @Override
    public void findSecretWord(String[] wordlist, Master master) {
        Set<Integer> remaining = new HashSet<>();
        int len = wordlist.length, min = len, pick = 0;
        int[][] relation = new int[len][len];
        int[] count = new int[7];
        for (int i = 0; i < len; i++) {
            relation[i][i] = 6;
            for (int j = i + 1; j < len; j++) {
                int c = comp(wordlist[i], wordlist[j]);
                relation[i][j] = c;
                relation[j][i] = c;
            }
            remaining.add(i);
            int max = 0;
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    int index = relation[i][j];
                    count[index] += 1;
                    max = Math.max(max, count[index]);
                }
            }
            Arrays.fill(count, 0);
            if (max < min) {
                min = max;
                pick = i;
            }
        }

        for (int i = 0; i < 10; i++) {
            int t = master.guess(wordlist[pick]);
            if (t == 6) {
                break;
            }

            Iterator<Integer> it = remaining.iterator();
            while (it.hasNext()) {
                int j = it.next();
                if (pick == j || relation[pick][j] != t) {
                    it.remove();
                }
            }

            min = len;
            for (int j : remaining) {
                int max = 0;
                Arrays.fill(count, 0);
                for (int k : remaining) {
                    if (j != k) {
                        int index = relation[j][k];
                        count[index] += 1;
                        max = Math.max(max, count[index]);
                    }
                }
                if (max < min) {
                    min = max;
                    pick = j;
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
