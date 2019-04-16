package com.leetcode.algorithms.binaryStringWithSubstringsRepresenting1ToN_1016;

import org.junit.Assert;

public class Solution {
    public boolean queryString(String S, int N) {
        int len = S.length(), m = 0x80000000, d = 32;
        while ((N & m) == 0) {
            m >>>= 1;
            d -= 1;
        }
        int n = N - m;

        if (n + 1 > len) {
            return false;
        }

        boolean[] visited = new boolean[n + 1];
        int c = 0;
        for (int i = 0; i + d <= len; i++) {
            if (S.charAt(i) == '0') {
                continue;
            }
            int v = Integer.parseInt(S.substring(i, i + d), 2);
            if (v <= N && !visited[v - m]) {
                c += 1;
                visited[v - m] = true;
            }
        }
        if (c != n + 1) {
            return false;
        }

        N = m - 1;
        m = Math.max(m >>> 1, n);
        n = N - m;
        if (n > 0) {
            d -= 1;
            if (n + 1 > len) {
                return false;
            }

            visited = new boolean[n + 1];
            c = 0;
            for (int i = 0; i + d <= len; i++) {
                if (S.charAt(i) == '0') {
                    continue;
                }
                int v = Integer.parseInt(S.substring(i, i + d), 2);
                if (v <= N && v >= m && !visited[v - m]) {
                    c += 1;
                    visited[v - m] = true;
                }
            }
            if (c != n + 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean ret;

        ret = s.queryString(
                "11111110011110011001001100000001101101000000111100111110001101101011010110001001100011111001111011011001111110111100010110100011101000101011101101000111111000110001011000010000100000111000111001111000010010101110000010011001011111101110001001000110101110001011111010111010101101011100010011010111110010100101010011011010001100100001011011111000001001111101111010000111110010000001010000011000001101111111011100011101000011000010100000000100010010101011111000110001100001100011011010011011000011000111",
                25);
        Assert.assertTrue(ret);

        ret = s.queryString(
                "100011110111101001001111111010111011000101000100011001000000000000001101000001111001000010011111110101100000101000100011100111100101000000010111011001000111011011010101011101010111011000100010001011001011110101010011000101000100101010110111110001101100001110011001110001111010100111000001101101110011",
                15);
        Assert.assertTrue(ret);

        ret = s.queryString("0110", 4);
        Assert.assertFalse(ret);

        ret = s.queryString("0110", 3);
        Assert.assertTrue(ret);
    }
}
