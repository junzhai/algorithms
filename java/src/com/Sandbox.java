package com;

import java.util.ArrayList;
import java.util.List;

public class Sandbox {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        int[][] c = new int[n][n];
        helper(c, 0, ret);
        return ret;
    }

    private void helper(int[][] c, int r, List<List<String>> ret) {
        int n = c.length;
        if (r == n) {
            List<String> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String row = "";
                for (int j = 0; j < n; j++) {
                    row += c[i][j] == 8 ? "Q" : ".";
                }
                l.add(row);
            }
            ret.add(l);
            return;
        }

        if (r < n - 1) {
            for (int i = 0; i < n; i++) {
                if (c[r][i] > 7 || c[r][i] < 1) {
                    continue;
                }

                if ((c[r][i] & 1) > 0) {
                    c[r + 1][i] |= 1;
                }
                if ((c[r][i] & 2) > 0 && i + 1 < n) {
                    c[r + 1][i + 1] |= 2;
                }
                if ((c[r][i] & 4) > 0 && i - 1 >= 0) {
                    c[r + 1][i - 1] |= 4;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (c[r][i] == 0) {
                c[r][i] = 8;
                c[r + 1][i] |= 1;
                if (i + 1 < n) {
                    c[r + 1][i + 1] |= 2;
                }
                if (i - 1 >= 0) {
                    c[r + 1][i - 1] |= 4;
                }

                helper(c, r + 1, ret);

                c[r][i] = 0;
                c[r + 1][i] ^= 1;
                if (i + 1 < n) {
                    c[r + 1][i + 1] ^= 2;
                }
                if (i - 1 >= 0) {
                    c[r + 1][i - 1] ^= 4;
                }
            }
        }
    }

    public static void main(String[] args) {
        Sandbox s = new Sandbox();
        List<List<String>> ret = s.solveNQueens(4);
    }
}