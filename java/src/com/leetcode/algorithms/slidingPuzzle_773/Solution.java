package com.leetcode.algorithms.slidingPuzzle_773;

import com.leetcode.algorithms.pattern.BFS;
import org.junit.Assert;

@BFS
public class Solution {
    public int slidingPuzzle(int[][] board) {
        int v = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                v <<= 3;
                v += board[i][j];
            }
        }
        boolean[] visited = new boolean[(1 << 18) + 1];
        visited[v] = true;

        int[] q = new int[720];
        q[0] = v;
        int head = 0, tail = 1, target = 0b001010011100101000, mm = 0x3ffff, ret = 0;

        while (head < tail) {
            int count = tail - head;
            for (int i = 0; i < count; i++) {
                v = q[head++];
                if (v == target) {
                    return ret;
                }

                int m = 0b111000000000000000;
                for (; m > 0; m >>>= 3) {
                    if ((m & v) == 0) {
                        break;
                    }
                }

                int left = m << 3 & mm;
                if (left > 0 && left != 0xe00) {
                    int n = (v | (v & left) >>> 3) & ~left;
                    if (!visited[n]) {
                        visited[n] = true;
                        q[tail++] = n;
                    }
                }

                int right = m >>> 3;
                if (right > 0 && right != 0x1c0) {
                    int n = (v | (v & right) << 3) & ~right;
                    if (!visited[n]) {
                        visited[n] = true;
                        q[tail++] = n;
                    }
                }

                int up = m << 9 & mm;
                if (up > 0) {
                    int n = (v | (v & up) >>> 9) & ~up;
                    if (!visited[n]) {
                        visited[n] = true;
                        q[tail++] = n;
                    }
                }

                int down = m >>> 9;
                if (down > 0) {
                    int n = (v | (v & down) << 9) & ~down;
                    if (!visited[n]) {
                        visited[n] = true;
                        q[tail++] = n;
                    }
                }
            }
            ret += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;

        ret = s.slidingPuzzle(new int[][]{{3, 2, 4}, {1, 5, 0}});
        Assert.assertEquals(14, ret);

        ret = s.slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}});
        Assert.assertEquals(5, ret);

        ret = s.slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}});
        Assert.assertEquals(-1, ret);

        ret = s.slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}});
        Assert.assertEquals(1, ret);


    }
}
