package com.leetcode.premium.bombEnemy_361;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum
 * enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the
 * wall is too strong to be destroyed.
 * Note that you can only put the bomb at an empty cell.
 * <p>
 * Example:
 * <p>
 * For the given grid
 * <p>
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 * <p>
 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
 */
public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int row = grid.length, col = grid[0].length, ret = 0;
        int[] rowIndex = new int[col], enemyInCol = new int[col];
        Arrays.fill(rowIndex, -1);

        for (int r = 0; r < row; r++) {
            for (int c = 0, e = 0, max = 0; c < col; c++) {
                switch (grid[r][c]) {
                    case 'E':
                        e += 1;
                        break;
                    case 'W':
                        max = 0;
                        e = 0;
                        break;
                    case '0':
                        if (r > rowIndex[c]) {
                            int rr = rowIndex[c] + 1, ee = 0;
                            for (; rr < row; rr++) {
                                char ch = grid[rr][c];
                                if (ch == 'E') {
                                    ee += 1;
                                } else if (ch == 'W') {
                                    break;
                                }
                            }
                            rowIndex[c] = rr;
                            enemyInCol[c] = ee;
                        }
                        max = Math.max(max, enemyInCol[c]);
                        ret = Math.max(ret, max + e);
                        break;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;

        ret = s.maxKilledEnemies(new char[][]{
                {'0', 'E', '0', '0', 'E', '0', 'W', 'E', '0', 'E', '0', '0'},
                {'0', 'E', '0', '0', 'E', '0', 'W', 'E', '0', 'E', '0', '0'},
                {'0', 'E', '0', '0', 'E', '0', 'W', 'E', '0', 'E', '0', '0'},
                {'0', 'E', '0', '0', 'E', '0', 'W', 'E', '0', 'E', '0', '0'},
                {'0', 'E', '0', '0', '0', '0', 'W', 'E', '0', 'E', '0', '0'},
                {'0', 'E', '0', '0', 'E', '0', 'W', 'E', '0', 'E', '0', '0'},
                {'0', 'E', '0', '0', 'E', '0', 'W', 'E', '0', 'E', '0', '0'},
                {'0', 'E', '0', '0', 'E', '0', 'W', 'E', '0', 'E', '0', '0'}
        });

        assertEquals(8, ret);

        ret = s.maxKilledEnemies(new char[][]{
                {'0', 'E', '0', '0', 'E', '0', 'W', 'E', '0', 'E', '0', '0'},
                {'0', 'E', '0', '0', 'E', '0', 'W', 'E', '0', 'E', '0', '0'},
                {'0', 'E', '0', '0', 'E', '0', 'W', 'E', '0', 'E', '0', '0'},
                {'0', 'E', '0', '0', 'E', '0', 'W', 'E', '0', 'E', '0', '0'},
                {'0', 'E', '0', '0', 'E', '0', 'W', 'E', '0', 'E', '0', '0'},
                {'0', 'E', '0', '0', 'E', '0', 'W', 'E', '0', 'E', '0', '0'},
                {'0', 'E', '0', '0', 'E', '0', 'W', 'E', '0', 'E', '0', '0'},
                {'0', 'E', '0', '0', 'E', '0', 'W', 'E', '0', 'E', '0', '0'}
        });

        assertEquals(2, ret);

        ret = s.maxKilledEnemies(new char[][]{
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'},
                {'0', 'E', '0', '0'}
        });

        assertEquals(3, ret);

    }
}
