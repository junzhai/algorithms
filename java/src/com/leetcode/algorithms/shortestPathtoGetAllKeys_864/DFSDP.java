package com.leetcode.algorithms.shortestPathtoGetAllKeys_864;

import com.pattern.algorithms.DFS;
import com.pattern.algorithms.DP;

@DFS
@DP
public class DFSDP extends Solution {
    @Override
    public int shortestPathAllKeys(String[] grid) {
        int row = grid.length, col = grid[0].length();
        char[][] g = new char[row][0];
        int r0 = 0, c0 = 0, key = 0;
        for (int i = 0; i < row; i++) {
            g[i] = grid[i].toCharArray();
            for (int j = 0; j < col; j++) {
                char ch = g[i][j];
                if (ch == '@') {
                    r0 = i;
                    c0 = j;
                }
                if (ch >= 'a' && ch <= 'f') {
                    key = Math.max(key, ch - 'a');
                }
            }
        }

        int target = (1 << key + 1) - 1;
        boolean[][][] visited = new boolean[row][col][target + 1];

        int[][][] dp = new int[row][col][target + 1];
        dp[r0][c0][0] = 1;

        int[] ret = new int[1];
        int max = (key + 1) * (row + col - 2) + 1;
        ret[0] = max;

        minPath(g, r0, c0, 0, 0, target, visited, dp, ret);
        return ret[0] == max ? -1 : ret[0];
    }

    private void minPath(char[][] g, int r, int c, int k, int step, int target, boolean[][][] visited, int[][][] dp,
                         int[] ret) {
        if (step >= ret[0]) {
            return;
        }

        if (visited[r][c][k]) {
            return;
        }

        char ch = g[r][c];
        if (ch == '#') {
            return;
        }

        if (ch >= 'a' && ch <= 'f') {
            k |= (1 << ch - 'a');
        }

        if (ch >= 'A' && ch <= 'F' && ((1 << ch - 'A') & k) == 0) {
            return;
        }

        if (dp[r][c][k] > 0 || ch == '@' && k == 0) {
            if (step >= dp[r][c][k]) {
                return;
            }
        }

        dp[r][c][k] = step;
        if (k == target) {
            ret[0] = Math.min(ret[0], step);
            return;
        }

        int row = g.length, col = g[0].length;
        visited[r][c][k] = true;
        if (c + 1 < col) {
            minPath(g, r, c + 1, k, step + 1, target, visited, dp, ret);
        }

        if (r + 1 < row) {
            minPath(g, r + 1, c, k, step + 1, target, visited, dp, ret);
        }

        if (c > 0) {
            minPath(g, r, c - 1, k, step + 1, target, visited, dp, ret);
        }

        if (r > 0) {
            minPath(g, r - 1, c, k, step + 1, target, visited, dp, ret);
        }
        visited[r][c][k] = false;
    }
}
