package com.leetcode.algorithms.findDuplicateSubtrees_652;

import com.leetcode.algorithms.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ATrick extends Solution {
    @Override
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ret = new ArrayList<>();
        helper(root, ret, new HashMap<>());
        return ret;
    }

    private String helper(TreeNode node, List<TreeNode> ret, Map<String, TreeNode> dp) {
        if (node == null) {
            return "*";
        }

        String key = node.val + "|" + helper(node.left, ret, dp) + "|" + helper(node.right, ret, dp);
        if (dp.containsKey(key)) {
            TreeNode dup = dp.get(key);
            if (dup != null) {
                ret.add(dup);
                dp.put(key, null);
            }
        } else {
            dp.put(key, node);
        }
        return key;
    }
}
