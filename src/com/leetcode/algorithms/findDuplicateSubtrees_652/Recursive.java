package com.leetcode.algorithms.findDuplicateSubtrees_652;

import com.leetcode.algorithms.common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Recursive extends Solution {
    @Override
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ret = new ArrayList<>();
        helper(root, new ArrayList<>(), ret, new HashSet<>(), false);
        return ret;
    }

    private void helper(TreeNode node, List<TreeNode> path, List<TreeNode> ret, Set<TreeNode> visited, boolean found) {
        if (node == null || visited.contains(node)) {
            return;
        }

        for (TreeNode parent : path) {
            found |= findDup(parent.right, node, visited);
        }

        if (found) {
            ret.add(node);
        }

        path.add(node);
        helper(node.left, path, ret, visited, found);
        path.remove(path.size() - 1);
        helper(node.right, path, ret, visited, found);
    }

    private boolean findDup(TreeNode node, TreeNode target, Set<TreeNode> visited) {
        if (node == null || node == target || visited.contains(node)) {
            return false;
        }

        if (dup(node, target)) {
            visited.add(node);
            return true;
        }

        return findDup(node.left, target, visited) | findDup(node.right, target, visited);
    }

    private boolean dup(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }

        if (!dup(a.left, b.left)) {
            return false;
        }

        return dup(a.right, b.right);
    }
}
