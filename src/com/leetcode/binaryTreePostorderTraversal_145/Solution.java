package com.leetcode.binaryTreePostorderTraversal_145;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> ss = new Stack<>();

        TreeNode p = root;
        int state = 0;
        while (p != null) {
            if (state == 1 && p.right != null) {
                s.push(p);
                ss.push(2);
                p = p.right;
                state = 0;
                continue;
            }
            if (state == 0 && p.left != null) {
                s.push(p);
                ss.push(1);
                p = p.left;
                continue;
            }
            if (state == 0 && p.right != null) {
                s.push(p);
                ss.push(2);
                p = p.right;
                continue;
            }

            ret.add(p.val);
            if (!s.isEmpty()) {
                p = s.pop();
                state = ss.pop();
            } else {
                p = null;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> ret;

        ret = s.postorderTraversal(TreeNode.buildBinaryTree(new Integer[]{3, 2, 4, null, null, 1}));

        ret = s.postorderTraversal(TreeNode.buildBinaryTree(new Integer[]{1, null, 2, 3}));
    }
}
