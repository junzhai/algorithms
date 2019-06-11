package com.leetcode.algorithms.findDuplicateSubtrees_652;

import com.leetcode.algorithms.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UseDP extends Solution {
    @Override
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<TreeNode, Integer> index = new HashMap<>();
        TreeMap<Integer, List<TreeNode>> group = new TreeMap<>();
        int[] seq = new int[1];
        group(seq, root, index, group);

        Boolean[][] dp = new Boolean[seq[0]][seq[0]];
        List<TreeNode> ret = new ArrayList<>();
        for (int h : group.keySet()) {
            List<TreeNode> nodes = group.get(h);
            int len = nodes.size();
            boolean[] visited = new boolean[len];
            for (int i = 0; i < len - 1; i++) {
                if (visited[i]) {
                    continue;
                }
                TreeNode a = nodes.get(i);
                int x = index.get(a);
                boolean dup = false;
                for (int j = i + 1; j < len; j++) {
                    if (visited[j]) {
                        continue;
                    }
                    TreeNode b = nodes.get(j);
                    int y = index.get(b);
                    boolean v = dup(a, b, index, dp);
                    dp[x][y] = v;
                    dp[y][x] = v;
                    if (v) {
                        visited[j] = true;
                    }
                    dup |= v;
                }
                if (dup) {
                    ret.add(a);
                }
            }
        }

        return ret;
    }

    private int group(int[] seq, TreeNode node, Map<TreeNode, Integer> index, Map<Integer, List<TreeNode>> group) {
        if (node == null) {
            return 0;
        }

        index.put(node, seq[0]);
        seq[0] += 1;

        int l = group(seq, node.left, index, group), r = group(seq, node.right, index, group);
        int h = Math.max(l, r) + 1;
        if (!group.containsKey(h)) {
            group.put(h, new ArrayList<>());
        }
        group.get(h).add(node);
        return h;
    }

    private boolean dup(TreeNode a, TreeNode b, Map<TreeNode, Integer> index, Boolean[][] dp) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        Boolean v = dp[index.get(a)][index.get(b)];
        if (v != null) {
            return v;
        }

        return a.val == b.val && dup(a.left, b.left, index, dp) && dup(a.right, b.right, index, dp);
    }
}
