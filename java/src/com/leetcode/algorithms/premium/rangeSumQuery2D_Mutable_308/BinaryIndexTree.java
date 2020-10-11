package com.leetcode.algorithms.premium.rangeSumQuery2D_Mutable_308;

import com.leetcode.algorithms.pattern.BinaryIndexedTree;

@BinaryIndexedTree
public class BinaryIndexTree extends NumMatrix {
    private final int rowCount, colCount;
    private final int[][] matrix;
    private final int[][] sum;

    public BinaryIndexTree(int[][] matrix) {
        rowCount = matrix.length + 1;
        colCount = matrix[0].length + 1;

        sum = new int[rowCount][colCount];
        this.matrix = new int[rowCount][colCount];

        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                update(i - 1, j - 1, matrix[i - 1][j - 1]);
            }
        }
    }

    @Override
    public void update(int row, int col, int val) {
        int diff = val - matrix[row + 1][col + 1];
        updateDiff(row + 1, col + 1, diff);
        matrix[row + 1][col + 1] = val;
    }

    private void updateDiff(int row, int col, int diff) {
        for (; row < rowCount; row += (row & -row)) {
            for (int c = col; c < colCount; c += (c & -c)) {
                sum[row][c] += diff;
            }
        }
    }

    @Override
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2 + 1, col2 + 1) - sum(row1, col2 + 1) - sum(row2 + 1, col1) + sum(row1, col1);
    }

    private int sum(int row, int col) {
        if (row < 0 || col < 0) {
            return 0;
        }

        int ret = 0;
        for (; row > 0; row -= (row & -row)) {
            for (int c = col; c > 0; c -= (c & -c)) {
                ret += sum[row][c];
            }
        }
        return ret;
    }
}
