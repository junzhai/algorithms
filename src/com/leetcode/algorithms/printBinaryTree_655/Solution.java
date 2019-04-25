package com.leetcode.algorithms.printBinaryTree_655;

import com.leetcode.algorithms.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ret = new ArrayList<>();

        int row = height(root), col = 0;
        for (int i = 0; i < row; i++) {
            col = (col << 1) + 1;
            ret.add(new ArrayList<>());
        }

        print(0, 0, col, root, ret);
        return ret;
    }

    private int height(TreeNode n) {
        if (n == null) {
            return 0;
        }
        return Math.max(height(n.left), height(n.right)) + 1;
    }

    private void print(int r, int c0, int c1, TreeNode n, List<List<String>> ret) {
        int row = ret.size();
        if (r >= row) {
            return;
        }

        List<String> l = ret.get(r);
        for (int i = c0; i < c1; i++) {
            l.add("");
        }

        if (n == null) {
            for (int j = r + 1; j < row; j++) {
                List<String> ll = ret.get(j);
                for (int i = c0; i < c1; i++) {
                    ll.add("");
                }
            }

            return;
        }

        int m = (c0 + c1) / 2;
        l.set(m, Integer.toString(n.val));

        print(r + 1, c0, m, n.left, ret);
        for (int i = r + 1; i < row; i++) {
            ret.get(i).add("");
        }
        print(r + 1, m + 1, c1, n.right, ret);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> ret;

        ret = s.printTree(TreeNode.buildBinaryTree(new Integer[]{3, null, 30, 10, null, null, 15, null, 45}));
        ret = s.printTree(TreeNode.buildBinaryTree(new Integer[]{5, 3, 6, 2, 4, null, 7}));
    }
}
