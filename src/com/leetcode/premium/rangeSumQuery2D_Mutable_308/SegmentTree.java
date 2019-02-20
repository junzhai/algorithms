package com.leetcode.premium.rangeSumQuery2D_Mutable_308;

@com.pattern.SegmentTree
public class SegmentTree extends NumMatrix {
    public static class SegmentTreeNode {
        int row1;
        int col1;
        int row2;
        int col2;
        int area;
        SegmentTreeNode[] children = new SegmentTreeNode[4];

        public SegmentTreeNode(int row1, int col1, int row2, int col2, int area) {
            this.row1 = row1;
            this.col1 = col1;
            this.row2 = row2;
            this.col2 = col2;
            this.area = area;
        }
    }

    private final int[][] matrix;
    private final SegmentTreeNode root;

    public SegmentTree(int[][] matrix) {
        this.matrix = matrix;
        root = build(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private SegmentTreeNode build(int[][] matrix, int r1, int c1, int r2, int c2) {
        if (r1 == r2 && c1 == c2) {
            return new SegmentTreeNode(r1, c1, r2, c2, matrix[r1][c1]);
        }

        SegmentTreeNode ret = new SegmentTreeNode(r1, c1, r2, c2, 0);
        if (r1 == r2) {
            int mc = (c1 + c2) / 2;
            ret.children[0] = build(matrix, r1, c1, r1, mc);
            ret.children[1] = build(matrix, r1, mc + 1, r1, c2);
        } else if (c1 == c2) {
            int mr = (r1 + r1) / 2;
            ret.children[0] = build(matrix, r1, c1, mr, c1);
            ret.children[2] = build(matrix, mr + 1, c1, r2, c1);
        } else {
            int mr = (r1 + r2) / 2, mc = (c1 + c2) / 2;
            ret.children[0] = build(matrix, r1, c1, mr, mc);
            ret.children[1] = build(matrix, r1, mc + 1, mr, c2);
            ret.children[2] = build(matrix, mr + 1, c1, r2, mc);
            ret.children[3] = build(matrix, mr + 1, mc + 1, r2, c2);
        }

        for (int i = 0; i < 4; i++) {
            if (ret.children[i] == null) {
                continue;
            }
            ret.area += ret.children[i].area;
        }

        return ret;
    }

    @Override
    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        update(row, col, diff, root);
    }

    private void update(int row, int col, int diff, SegmentTreeNode p) {
        if (p != null && row >= p.row1 && row <= p.row2 && col <= p.col2 && col >= p.col1) {
            p.area += diff;
            for (SegmentTreeNode child : p.children) {
                update(row, col, diff, child);
            }
        }
    }

    @Override
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegion(root, row1, col1, row2, col2);
    }

    private int sumRegion(SegmentTreeNode p, int row1, int col1, int row2, int col2) {
        if (p == null || row1 > p.row2 || row2 < p.row1 || col1 > p.col2 || col2 < p.col1) {
            return 0;
        }

        if (row1 <= p.row1 && row2 >= p.row2 && col1 <= p.col1 && col2 >= p.col2) {
            return p.area;
        }

        int ret = 0;
        for (SegmentTreeNode child : p.children) {
            ret += sumRegion(child, row1, col1, row2, col2);
        }
        return ret;
    }
}
