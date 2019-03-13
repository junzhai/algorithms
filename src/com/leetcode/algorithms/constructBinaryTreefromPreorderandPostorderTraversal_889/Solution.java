package com.leetcode.algorithms.constructBinaryTreefromPreorderandPostorderTraversal_889;

import com.leetcode.algorithms.common.TreeNode;
import org.junit.Assert;

public class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int len = pre.length;
        int[] postIndex = new int[len + 1];
        for (int i = 0; i < len; i++) {
            postIndex[post[i]] = i;
        }
        return helper(pre, 0, len - 1, post, 0, len - 1, postIndex);
    }

    private TreeNode helper(int[] pre, int bPre, int ePre, int[] post, int bPost, int ePost, int[] postIndex) {
        if (pre == null || bPre > ePre) {
            return null;
        }

        TreeNode ret = new TreeNode(pre[bPre]);
        if (bPre + 1 <= ePre) {
            int t = postIndex[pre[bPre + 1]];
            ret.left = helper(pre, bPre + 1, bPre + 1 + t - bPost, post, bPost, t, postIndex);
            ret.right = helper(pre, bPre + 2 + t - bPost, ePre, post, t + 1, ePost - 1, postIndex);
        }
        return ret;
    }

    public static void main(String[] arg) {
        Solution s = new Solution();
        TreeNode ret = s.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        Assert.assertNotNull(ret);
    }
}
