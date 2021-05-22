package com.leetcode.algorithms.stickerstoSpellWord_691;

import com.pattern.algorithms.BackTracking;

@BackTracking
public class BruteForce extends Solution {
    @Override
    public int minStickers(String[] stickers, String target) {
        int len = stickers.length;
        int[][] s = new int[len][26];
        int[] sum = new int[26];
        for (int i = 0; i < len; i++) {
            String ss = stickers[i];
            for (int j = 0; j < ss.length(); j++) {
                int index = ss.charAt(j) - 'a';
                s[i][index] += 1;
                sum[index] += 1;
            }
        }

        int[] t = new int[26];
        for (int i = 0; i < target.length(); i++) {
            t[target.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (t[i] > 0 && sum[i] == 0) {
                return -1;
            }
        }

        int[] ret = new int[1];
        ret[0] = Integer.MAX_VALUE;
        helper(new String[15], 0, stickers, s, target, t, 0, 0, ret);
        return ret[0];
    }

    private void helper(String[] path, int l,
                        String[] stickers, int[][] s, String target, int[] t, int index, int count, int[] ret) {
        int len = target.length();
        while (index < len && t[target.charAt(index) - 'a'] == 0) {
            index += 1;
        }
        if (index >= len) {
            ret[0] = Math.min(ret[0], count);
            for (int i = 0; i < l; i++) {
                System.out.print(path[i] + ", ");
            }
            System.out.println();
            return;
        }
        int i = target.charAt(index) - 'a';
        for (int j = 0; j < s.length; j++) {
            int[] ss = s[j];
            if (ss[i] > 0) {
                int[] nt = new int[26];
                for (int k = 0; k < 26; k++) {
                    if (ss[k] >= t[k]) {
                        nt[k] = 0;
                    } else {
                        nt[k] = t[k] - ss[k];
                    }
                }
                path[l] = stickers[j];
                helper(path, l + 1, stickers, s, target, nt, index + 1, count + 1, ret);
            }
        }
    }
}
