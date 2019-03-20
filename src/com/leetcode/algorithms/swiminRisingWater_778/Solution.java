package com.leetcode.algorithms.swiminRisingWater_778;

import com.leetcode.algorithms.pattern.VFS;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

@VFS
public class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length, ret = 0;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return grid[o1[0]][o1[1]] - grid[o2[0]][o2[1]];
            }
        });
        pq.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int r = p[0], c = p[1];
            ret = Math.max(ret, grid[r][c]);
            if (r == n - 1 && c == n - 1) {
                break;
            }
            if (r > 0 && !visited[r - 1][c]) {
                pq.offer(new int[]{r - 1, c});
                visited[r - 1][c] = true;
            }
            if (c < n - 1 && !visited[r][c + 1]) {
                pq.offer(new int[]{r, c + 1});
                visited[r][c + 1] = true;
            }
            if (r < n - 1 && !visited[r + 1][c]) {
                pq.offer(new int[]{r + 1, c});
                visited[r + 1][c] = true;
            }
            if (c > 0 && !visited[r][c - 1]) {
                pq.offer(new int[]{r, c - 1});
                visited[r][c - 1] = true;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;

        ret = s.swimInWater(new int[][]{
                {0, 2},
                {1, 3}});
        assertEquals(3, ret);

        ret = s.swimInWater(new int[][]{
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}});
        assertEquals(16, ret);

        ret = s.swimInWater(new int[][]{
                {7, 34, 16, 12, 15, 0},
                {10, 26, 4, 30, 1, 20},
                {28, 27, 33, 35, 3, 8},
                {29, 9, 13, 14, 11, 32},
                {31, 21, 23, 24, 19, 18},
                {22, 6, 17, 5, 2, 25}});
        assertEquals(26, ret);
    }
}
