package com.leetcode.algorithms.shortestPathtoGetAllKeys_864;

import com.pattern.algorithms.BackTracking;
import com.pattern.algorithms.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@DP
@BackTracking
public class UseDP extends Solution {
    @Override
    public int shortestPathAllKeys(String[] grid) {
        int row = grid.length, col = grid[0].length();
        char[][] g = new char[row][0];
        for (int i = 0; i < row; i++) {
            g[i] = grid[i].toCharArray();
        }

        int locked = 0;
        int[] starts = new int[6];
        int[][] k2k = new int[6][6], k2l = new int[6][6], l2l = new int[6][6];
        for (int i = 0; i < 6; i++) {
            Arrays.fill(k2k[i], 50);
            Arrays.fill(k2l[i], 50);
            Arrays.fill(l2l[i], 50);
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                char ch = g[r][c];
                if (ch == '@') {
                    dfsStart(g, r, c, starts, new boolean[row][col]);
                } else if (ch >= 'a' && ch <= 'f') {
                    dfsKey(g, r, c, k2k, k2l, new boolean[row][col]);
                } else if (ch >= 'A' && ch <= 'F') {
                    locked |= 1 << ch - 'A';
                    dfsLock(g, r, c, l2l, new boolean[row][col]);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            if (starts[i] != 0) {
                int v = helper(k2k, k2l, l2l, i, locked, new HashMap<>());
                if (v >= 0) {
                    ret = Math.min(ret, v + starts[i]);
                }
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    private void dfsStart(char[][] g, int x, int y, int[] starts, boolean[][] visited) {
        int row = g.length, col = g[0].length, len = 1;
        int[][] q1 = new int[row * col][2], q2 = new int[row * col][2];
        q1[0][0] = x;
        q1[0][1] = y;
        visited[x][y] = true;

        int move = 0;
        while (len > 0) {
            move += 1;
            int l = 0;
            for (int i = 0; i < len; i++) {
                int r = q1[i][0], c = q1[i][1];
                if (c + 1 < col && !visited[r][c + 1]) {
                    char ch = g[r][c + 1];
                    if (ch >= 'a' && ch <= 'f') {
                        starts[ch - 'a'] = move;
                    }

                    if (ch == '.' || ch >= 'a' && ch <= 'f') {
                        q2[l][0] = r;
                        q2[l][1] = c + 1;
                        l += 1;
                    }
                    visited[r][c + 1] = true;
                }
                if (r + 1 < row && !visited[r + 1][c]) {
                    char ch = g[r + 1][c];
                    if (ch >= 'a' && ch <= 'f') {
                        starts[ch - 'a'] = move;
                    }

                    if (ch == '.' || ch >= 'a' && ch <= 'f') {
                        q2[l][0] = r + 1;
                        q2[l][1] = c;
                        l += 1;
                    }
                    visited[r + 1][c] = true;
                }
                if (c > 0 && !visited[r][c - 1]) {
                    char ch = g[r][c - 1];
                    if (ch >= 'a' && ch <= 'f') {
                        starts[ch - 'a'] = move;
                    }

                    if (ch == '.' || ch >= 'a' && ch <= 'f') {
                        q2[l][0] = r;
                        q2[l][1] = c - 1;
                        l += 1;
                    }
                    visited[r][c - 1] = true;
                }
                if (r > 0 && !visited[r - 1][c]) {
                    char ch = g[r - 1][c];
                    if (ch >= 'a' && ch <= 'f') {
                        starts[ch - 'a'] = move;
                    }
                    if (ch == '.' || ch >= 'a' && ch <= 'f') {
                        q2[l][0] = r - 1;
                        q2[l][1] = c;
                        l += 1;
                    }
                    visited[r - 1][c] = true;
                }
            }

            len = l;
            int[][] tmp = q1;
            q1 = q2;
            q2 = tmp;
        }
    }


    private void dfsKey(char[][] g, int x, int y, int[][] k2k, int[][] k2l, boolean[][] visited) {
        int row = g.length, col = g[0].length, len = 1, cur = g[x][y] - 'a';
        int[][] q1 = new int[row * col][2], q2 = new int[row * col][2];
        q1[0][0] = x;
        q1[0][1] = y;
        visited[x][y] = true;

        int move = 0;
        while (len > 0) {
            move += 1;
            int l = 0;
            for (int i = 0; i < len; i++) {
                int r = q1[i][0], c = q1[i][1];
                if (c + 1 < col && !visited[r][c + 1]) {
                    char ch = g[r][c + 1];
                    if (ch >= 'a' && ch <= 'f') {
                        int idx = ch - 'a';
                        if (cur < idx) {
                            k2k[cur][idx] = move;
                        } else {
                            k2k[idx][cur] = move;
                        }
                    } else if (ch >= 'A' && ch <= 'F') {
                        int idx = ch - 'A';
                        k2l[cur][idx] = move;
                    }

                    if (ch == '.' || ch >= 'a' && ch <= 'f' || ch == '@') {
                        q2[l][0] = r;
                        q2[l][1] = c + 1;
                        l += 1;
                    }
                    visited[r][c + 1] = true;
                }
                if (r + 1 < row && !visited[r + 1][c]) {
                    char ch = g[r + 1][c];
                    if (ch >= 'a' && ch <= 'f') {
                        int idx = ch - 'a';
                        if (cur < idx) {
                            k2k[cur][idx] = move;
                        } else {
                            k2k[idx][cur] = move;
                        }
                    } else if (ch >= 'A' && ch <= 'F') {
                        int idx = ch - 'A';
                        k2l[cur][idx] = move;
                    }

                    if (ch == '.' || ch >= 'a' && ch <= 'f' || ch == '@') {
                        q2[l][0] = r + 1;
                        q2[l][1] = c;
                        l += 1;
                    }
                    visited[r + 1][c] = true;
                }
                if (c > 0 && !visited[r][c - 1]) {
                    char ch = g[r][c - 1];
                    if (ch >= 'a' && ch <= 'f') {
                        int idx = ch - 'a';
                        if (cur < idx) {
                            k2k[cur][idx] = move;
                        } else {
                            k2k[idx][cur] = move;
                        }
                    } else if (ch >= 'A' && ch <= 'F') {
                        int idx = ch - 'A';
                        k2l[cur][idx] = move;
                    }

                    if (ch == '.' || ch >= 'a' && ch <= 'f' || ch == '@') {
                        q2[l][0] = r;
                        q2[l][1] = c - 1;
                        l += 1;
                    }
                    visited[r][c - 1] = true;
                }
                if (r > 0 && !visited[r - 1][c]) {
                    char ch = g[r - 1][c];
                    if (ch >= 'a' && ch <= 'f') {
                        int idx = ch - 'a';
                        if (cur < idx) {
                            k2k[cur][idx] = move;
                        } else {
                            k2k[idx][cur] = move;
                        }
                    } else if (ch >= 'A' && ch <= 'F') {
                        int idx = ch - 'A';
                        k2l[cur][idx] = move;
                    }
                    if (ch == '.' || ch >= 'a' && ch <= 'f' || ch == '@') {
                        q2[l][0] = r - 1;
                        q2[l][1] = c;
                        l += 1;
                    }
                    visited[r - 1][c] = true;
                }
            }

            len = l;
            int[][] tmp = q1;
            q1 = q2;
            q2 = tmp;
        }
    }

    private void dfsLock(char[][] g, int x, int y, int[][] l2l, boolean[][] visited) {
        int row = g.length, col = g[0].length, len = 1, cur = g[x][y] - 'A';
        int[][] q1 = new int[row * col][2], q2 = new int[row * col][2];
        q1[0][0] = x;
        q1[0][1] = y;
        visited[x][y] = true;

        int move = 0;
        while (len > 0) {
            move += 1;
            int l = 0;
            for (int i = 0; i < len; i++) {
                int r = q1[i][0], c = q1[i][1];
                if (c + 1 < col && !visited[r][c + 1]) {
                    char ch = g[r][c + 1];
                    if (ch >= 'A' && ch <= 'F') {
                        int idx = ch - 'A';
                        if (cur < idx) {
                            l2l[cur][idx] = move;
                        } else {
                            l2l[idx][cur] = move;
                        }
                    }

                    if (ch == '.' || ch >= 'a' && ch <= 'f' || ch == '@') {
                        q2[l][0] = r;
                        q2[l][1] = c + 1;
                        l += 1;
                    }
                    visited[r][c + 1] = true;
                }
                if (r + 1 < row && !visited[r + 1][c]) {
                    char ch = g[r + 1][c];
                    if (ch >= 'A' && ch <= 'F') {
                        int idx = ch - 'A';
                        if (cur < idx) {
                            l2l[cur][idx] = move;
                        } else {
                            l2l[idx][cur] = move;
                        }
                    }

                    if (ch == '.' || ch >= 'a' && ch <= 'f' || ch == '@') {
                        q2[l][0] = r + 1;
                        q2[l][1] = c;
                        l += 1;
                    }
                    visited[r + 1][c] = true;
                }
                if (c > 0 && !visited[r][c - 1]) {
                    char ch = g[r][c - 1];
                    if (ch >= 'A' && ch <= 'F') {
                        int idx = ch - 'A';
                        if (cur < idx) {
                            l2l[cur][idx] = move;
                        } else {
                            l2l[idx][cur] = move;
                        }
                    }

                    if (ch == '.' || ch >= 'a' && ch <= 'f' || ch == '@') {
                        q2[l][0] = r;
                        q2[l][1] = c - 1;
                        l += 1;
                    }
                    visited[r][c - 1] = true;
                }
                if (r > 0 && !visited[r - 1][c]) {
                    char ch = g[r - 1][c];
                    if (ch >= 'A' && ch <= 'F') {
                        int idx = ch - 'A';
                        if (cur < idx) {
                            l2l[cur][idx] = move;
                        } else {
                            l2l[idx][cur] = move;
                        }
                    }
                    if (ch == '.' || ch >= 'a' && ch <= 'f' || ch == '@') {
                        q2[l][0] = r - 1;
                        q2[l][1] = c;
                        l += 1;
                    }
                    visited[r - 1][c] = true;
                }
            }

            len = l;
            int[][] tmp = q1;
            q1 = q2;
            q2 = tmp;
        }
    }

    private int helper(int[][] k2k, int[][] k2l, int[][] l2l, int k, int locked, Map<Integer, Integer> dp) {
        if (locked == (1 << k)) {
            return 0;
        }

        int key = (locked << 3) + k;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int[][] new_l2l = new int[6][6];
        for (int i = 0, mi = 1; i < 6; i++, mi <<= 1) {
            if ((locked & mi) == 0) {
                continue;
            }
            for (int j = i + 1, mj = 1 << j; j < 6; j++, mj <<= 1) {
                if ((locked & mj) == 0) {
                    continue;
                }
                if (i == k || j == k) {
                    new_l2l[i][j] = l2l[i][j];
                } else {
                    new_l2l[i][j] = Math.min(l2l[i][j],
                            l2l[Math.min(i, k)][Math.max(i, k)] + l2l[Math.min(j, k)][Math.max(j, k)]);
                }
            }
        }

        int[][] new_k2l = new int[6][6];
        for (int i = 0, mi = 1; i < 6; i++, mi <<= 1) {
            if ((locked & mi) == 0) {
                continue;
            }
            for (int j = 0, mj = 1; j < 6; j++, mj <<= 1) {
                if ((locked & mj) == 0) {
                    continue;
                }
                if (j == k) {
                    new_k2l[i][j] = k2l[i][j];
                } else {
                    new_k2l[i][j] = Math.min(k2l[i][j], k2l[i][k] + l2l[Math.min(j, k)][Math.max(j, k)]);
                }
            }
        }

        int[][] new_k2k = new int[6][6];
        for (int i = 0, mi = 1; i < 6; i++, mi <<= 1) {
            if ((locked & mi) == 0) {
                continue;
            }
            for (int j = i + 1, mj = 1 << j; j < 6; j++, mj <<= 1) {
                if ((locked & mj) == 0) {
                    continue;
                }
                new_k2k[i][j] = Math.min(k2k[i][j], k2l[i][k] + k2l[j][k]);
            }
        }

        locked -= 1 << k;
        int ret = Integer.MAX_VALUE;
        for (int i = 0, m = 1; i < 6; i++, m <<= 1) {
            if ((locked & m) > 0) {
                int v = new_k2k[Math.min(k, i)][Math.max(k, i)];
                if (v < 50) {
                    int vv = helper(new_k2k, new_k2l, new_l2l, i, locked, dp);
                    if (vv >= 0) {
                        ret = Math.min(ret, vv + v);
                    }
                }
            }
        }

        ret = ret == Integer.MAX_VALUE ? -1 : ret;
        dp.put(key, ret);
        return ret;
    }
}