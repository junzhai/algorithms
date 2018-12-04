package com.leetcode.countDifferentPalindromicSubsequences_730;

public class BruteForce extends Solution {
    @Override
    public int countPalindromicSubsequences(String S) {
        int l = S.length(), m = (int) Math.pow(10, 9) + 7;
        int[][] roll = new int[l][4];
        for (int i = 0; i < l; i++) {
            int index = S.charAt(i) - 'a';
            if (i > 0) {
                System.arraycopy(roll[i - 1], 0, roll[i], 0, 4);
            }
            roll[i][index] += 1;
        }

        int[] ret = new int[1];
        helper(S, 0, S.length() - 1, ret, roll, "");
        return ret[0];
    }

    private void helper(String S, int b, int e, int[] count, int[][] roll, String path) {
        if (b > e) {
            return;
        }
        if (b == e) {
            count[0] += 1;
            System.out.println(path + S.charAt(b) + new StringBuilder(path).reverse().toString());
            return;
        }

        for (char i = 'a'; i <= 'd'; i++) {
            int index = i - 'a';
            if (b > 0) {
                if (roll[e][index] - roll[b - 1][index] > 0) {
                    count[0] += 1;
                    System.out.println(path + i + new StringBuilder(path).reverse().toString());
                }
            } else {
                if (roll[e][index] > 0) {
                    count[0] += 1;
                    System.out.println(path + i + new StringBuilder(path).reverse().toString());
                }
            }
        }

        for (char c = 'a'; c <= 'd'; c++) {
            int f = S.indexOf(c, b);
            if (f <= e && f >= b) {
                int l = S.lastIndexOf(c, e);
                if (f < l) {
                    count[0] += 1;
                    System.out.println(path + c + c + new StringBuilder(path).reverse().toString());
                    helper(S, f + 1, l - 1, count, roll, path + c);
                }
            }
        }
    }
}
