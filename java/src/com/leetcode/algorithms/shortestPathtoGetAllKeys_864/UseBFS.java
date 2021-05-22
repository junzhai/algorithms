package com.leetcode.algorithms.shortestPathtoGetAllKeys_864;

import com.pattern.algorithms.BFS;

import java.util.LinkedList;
import java.util.Queue;

@BFS
public class UseBFS extends Solution {
    @Override
    public int shortestPathAllKeys(String[] grid) {
        int row = grid.length, col = grid[0].length(), target = 0;
        char[][] g = new char[row][0];
        for (int i = 0; i < row; i++) {
            g[i] = grid[i].toCharArray();
        }

        boolean[][][] visited = new boolean[row][col][64];
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                char ch = g[r][c];
                if (ch == '@') {
                    q.offer(new int[]{r, c, 0});
                    visited[r][c][0] = true;
                } else if (ch >= 'a' && ch <= 'f') {
                    target |= 1 << ch - 'a';
                }
            }
        }


        int move = 0;
        while (!q.isEmpty()) {
            move += 1;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] cur = q.poll();

                int r = cur[0], c = cur[1], k = cur[2];
                if (c + 1 < col && !visited[r][c + 1][k]) {
                    char ch = g[r][c + 1];
                    int kk = k;
                    if (ch >= 'a' && ch <= 'f') {
                        kk |= 1 << ch - 'a';
                        if (kk == target) {
                            return move;
                        }
                    }

                    if (ch == '.' || ch == '@'
                            || ch >= 'a' && ch <= 'f'
                            || ch >= 'A' && ch <= 'F' && (k & 1 << ch - 'A') > 0) {
                        q.offer(new int[]{r, c + 1, kk});
                        visited[r][c + 1][k] = true;
                    }
                }
                if (r + 1 < row && !visited[r + 1][c][k]) {
                    char ch = g[r + 1][c];
                    int kk = k;
                    if (ch >= 'a' && ch <= 'f') {
                        kk |= 1 << ch - 'a';
                        if (kk == target) {
                            return move;
                        }
                    }

                    if (ch == '.' || ch == '@'
                            || ch >= 'a' && ch <= 'f'
                            || ch >= 'A' && ch <= 'F' && (k & 1 << ch - 'A') > 0) {
                        q.offer(new int[]{r + 1, c, kk});
                        visited[r + 1][c][k] = true;
                    }
                }
                if (c > 0 && !visited[r][c - 1][k]) {
                    char ch = g[r][c - 1];
                    int kk = k;
                    if (ch >= 'a' && ch <= 'f') {
                        kk |= 1 << ch - 'a';
                        if (kk == target) {
                            return move;
                        }
                    }

                    if (ch == '.' || ch == '@'
                            || ch >= 'a' && ch <= 'f'
                            || ch >= 'A' && ch <= 'F' && (k & 1 << ch - 'A') > 0) {
                        q.offer(new int[]{r, c - 1, kk});
                        visited[r][c - 1][k] = true;
                    }
                }
                if (r > 0 && !visited[r - 1][c][k]) {
                    char ch = g[r - 1][c];
                    int kk = k;
                    if (ch >= 'a' && ch <= 'f') {
                        kk |= 1 << ch - 'a';
                        if (kk == target) {
                            return move;
                        }
                    }

                    if (ch == '.' || ch == '@'
                            || ch >= 'a' && ch <= 'f'
                            || ch >= 'A' && ch <= 'F' && (k & 1 << ch - 'A') > 0) {
                        q.offer(new int[]{r - 1, c, kk});
                        visited[r - 1][c][k] = true;
                    }
                }
            }
        }

        return -1;
    }
}