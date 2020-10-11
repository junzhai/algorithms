package com.leetcode.algorithms.minimumHeightTrees_310;

import java.util.ArrayList;
import java.util.List;

// DP base on maxtrix multiply. Exceed time limit
public class MultiplyMatrix extends Solution {
    @Override
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[][] dp = new int[n][n], tmp = new int[n][n], step = new int[n][n];
        for (int[] e : edges) {
            step[e[0]][e[1]] = 1;
            step[e[1]][e[0]] = 1;
            dp[e[0]][e[1]] = 1;
            dp[e[1]][e[0]] = 1;
            tmp[e[0]][e[1]] = 1;
            tmp[e[1]][e[0]] = 1;
        }

        List<Integer> ret = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            boolean found = true;
            for (int c = 0; c < n; c++) {
                if (r == c) {
                    continue;
                }

                if (tmp[r][c] == 0) {
                    found = false;
                    break;
                }
            }
            if (found) {
                ret.add(r);
            }
        }

        while (ret.isEmpty()) {
            for (int r = 0; r < n; r++) {
                boolean found = true;
                for (int c = 0; c < n; c++) {
                    if (r == c) {
                        continue;
                    }
                    if (dp[r][c] == 1) {
                        tmp[r][c] = 1;
                        continue;
                    }
                    for (int k = 0; k < n; k++) {
                        if (dp[r][k] == 1 && step[k][c] == 1) {
                            tmp[r][c] = 1;
                            break;
                        }
                    }
                    if (tmp[r][c] == 0) {
                        found = false;
                    }
                }
                if (found) {
                    ret.add(r);
                }
            }
            int[][] t = dp;
            dp = tmp;
            tmp = t;
        }
        return ret;
    }
}
