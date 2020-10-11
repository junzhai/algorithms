package com.leetcode.algorithms.shortestPathtoGetAllKeys_864;

import java.util.Arrays;

public class BruteForce extends Solution {
    @Override
    public int shortestPathAllKeys(String[] grid) {
        int row = grid.length, col = grid[0].length(), x = 0, y = 0;
        char[][] g = new char[row][0];
        for (int i = 0; i < row; i++) {
            g[i] = grid[i].toCharArray();
        }

        boolean[] keys = new boolean[6];
        Arrays.fill(keys, true);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char ch = g[i][j];
                if (ch == '@') {
                    x = i;
                    y = j;
                } else if (ch >= 'a' && ch <= 'f') {
                    keys[ch - 'a'] = false;
                }
            }
        }

        return helper(g, x, y, keys);
    }

    private int helper(char[][] g, int x, int y, boolean[] keys) {
        boolean done = true;
        for (boolean k : keys) {
            done &= k;
        }

        if (done) {
            return 0;
        }

        int row = g.length, col = g[0].length, len = 1;
        int[][] q1 = new int[row * col][2], q2 = new int[row * col][2];
        q1[0][0] = x;
        q1[0][1] = y;
        boolean[][] visited = new boolean[row][col];
        visited[x][y] = true;

        int ret = Integer.MAX_VALUE, move = 0;
        while (len > 0) {
            move += 1;
            int l = 0;
            for (int i = 0; i < len; i++) {
                int r = q1[i][0], c = q1[i][1];
                if (c + 1 < col && !visited[r][c + 1]) {
                    char ch = g[r][c + 1];
                    if (ch >= 'a' && ch <= 'f' && !keys[ch - 'a']) {
                        keys[ch - 'a'] = true;
                        int min = helper(g, r, c + 1, keys);
                        if (min >= 0) {
                            ret = Math.min(ret, min + move);
                        }
                        keys[ch - 'a'] = false;
                    }

                    if (ch == '.'
                            || ch == '@'
                            || ch >= 'A' && ch <= 'F' && keys[ch - 'A']
                            || ch >= 'a' && ch <= 'f') {
                        q2[l][0] = r;
                        q2[l][1] = c + 1;
                        l += 1;
                        visited[r][c + 1] = true;
                    }
                }
                if (r + 1 < row && !visited[r + 1][c]) {
                    char ch = g[r + 1][c];
                    if (ch >= 'a' && ch <= 'f' && !keys[ch - 'a']) {
                        keys[ch - 'a'] = true;
                        int min = helper(g, r + 1, c, keys);
                        if (min >= 0) {
                            ret = Math.min(ret, min + move);
                        }
                        keys[ch - 'a'] = false;
                    }

                    if (ch == '.'
                            || ch == '@'
                            || ch >= 'A' && ch <= 'F' && keys[ch - 'A']
                            || ch >= 'a' && ch <= 'f') {
                        q2[l][0] = r + 1;
                        q2[l][1] = c;
                        l += 1;
                        visited[r + 1][c] = true;
                    }
                }
                if (c > 0 && !visited[r][c - 1]) {
                    char ch = g[r][c - 1];
                    if (ch >= 'a' && ch <= 'f' && !keys[ch - 'a']) {
                        keys[ch - 'a'] = true;
                        int min = helper(g, r, c - 1, keys);
                        if (min >= 0) {
                            ret = Math.min(ret, min + move);
                        }
                        keys[ch - 'a'] = false;
                    }

                    if (ch == '.'
                            || ch == '@'
                            || ch >= 'A' && ch <= 'F' && keys[ch - 'A']
                            || ch >= 'a' && ch <= 'f') {
                        q2[l][0] = r;
                        q2[l][1] = c - 1;
                        l += 1;
                        visited[r][c - 1] = true;
                    }
                }
                if (r > 0 && !visited[r - 1][c]) {
                    char ch = g[r - 1][c];
                    if (ch >= 'a' && ch <= 'f' && !keys[ch - 'a']) {
                        keys[ch - 'a'] = true;
                        int min = helper(g, r - 1, c, keys);
                        if (min >= 0) {
                            ret = Math.min(ret, min + move);
                        }
                        keys[ch - 'a'] = false;
                    }
                    if (ch == '.'
                            || ch == '@'
                            || ch >= 'A' && ch <= 'F' && keys[ch - 'A']
                            || ch >= 'a' && ch <= 'f') {
                        q2[l][0] = r - 1;
                        q2[l][1] = c;
                        l += 1;
                        visited[r - 1][c] = true;
                    }
                }
            }

            len = l;
            int[][] tmp = q1;
            q1 = q2;
            q2 = tmp;
        }

        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}