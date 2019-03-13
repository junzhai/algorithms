package com.leetcode.algorithms.twoSum_InputIsABST_653;


import com.leetcode.algorithms.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class UseHashSet extends Solution {
    @Override
    public boolean findTarget(TreeNode root, int k) {
        return find(root, k, new HashSet<Integer>());
    }

    private boolean find(TreeNode root, int k, Set<Integer> c) {
        if (root == null) {
            return false;
        }

        if (c.contains(k - root.val)) {
            return true;
        }

        c.add(root.val);

        return find(root.left, k, c) || find(root.right, k, c);
    }
}
