package com.leetcode.algorithms.stickerstoSpellWord_691;

import com.pattern.BackTracking;

import java.util.Arrays;

@BackTracking
public class BackTrack extends Solution {
    @Override
    public int minStickers(String[] stickers, String target) {
        int[] order = new int[26];
        Arrays.fill(order, -1);
        int len = 0;
        for (int i = 0; i < target.length(); i++) {
            int index = target.charAt(i) - 'a';
            if (order[index] < 0) {
                order[index] = len++;
            }
        }

        int[] t = new int[len];
        for (int i = 0; i < target.length(); i++) {
            t[order[target.charAt(i) - 'a']] += 1;
        }

        int[][] s = new int[stickers.length][len];
        boolean[] sum = new boolean[len];
        for (int i = 0; i < stickers.length; i++) {
            String ss = stickers[i];
            for (int j = 0; j < ss.length(); j++) {
                int index = order[ss.charAt(j) - 'a'];
                if (index >= 0) {
                    s[i][index] += 1;
                    sum[index] = true;
                }
            }
        }

        boolean[] remain = new boolean[stickers.length];
        Arrays.fill(remain, true);
        int kk = stickers.length;
        for (int i = 0; i < stickers.length; i++) {
            if (remain[i]) {
                for (int j = 0; j < stickers.length; j++) {
                    if (remain[j] && i != j) {
                        if (cover(s[i], s[j])) {
                            remain[j] = false;
                            kk -= 1;
                        }
                    }
                }
            }
        }

        int[][] sss = new int[kk][len];
        for (int i = 0, ii = 0; i < remain.length; i++) {
            if (remain[i]) {
                sss[ii++] = s[i];
            }
        }

        for (int i = 0; i < len; i++) {
            if (t[i] > 0 && !sum[i]) {
                return -1;
            }
        }

        int[] ret = new int[1];
        ret[0] = Integer.MAX_VALUE;
        helper(sss, t, 0, new int[target.length()], 0, t[0], ret);
        return ret[0];
    }

    private boolean cover(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i]) {
                return false;
            }
        }
        return true;
    }

    private void helper(int[][] s, int[] t, int index, int[] path, int count, int remain, int[] ret) {
        // MOST IMPORTANT !!!!
        if (count >= ret[0]) {
            return;
        }

        while (remain <= 0) {
            index += 1;
            if (index >= t.length) {
                break;
            }
            remain = t[index];
            for (int i = 0; i < count; i++) {
                remain -= s[path[i]][index];
                if (remain <= 0) {
                    break;
                }
            }
        }
        if (index >= t.length) {
            ret[0] = Math.min(ret[0], count);
            return;
        }

        for (int i = 0; i < s.length; i++) {
            if (s[i][index] > 0) {
                path[count] = i;
                helper(s, t, index, path, count + 1, remain - s[i][index], ret);
            }
        }
    }
}
