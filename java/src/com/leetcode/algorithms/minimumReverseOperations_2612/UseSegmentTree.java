package com.leetcode.algorithms.minimumReverseOperations_2612;

import java.util.HashSet;
import java.util.Set;

class UseSegmentTree extends Solution {
    private static class SegmentTreeNode {
        int left, right;
        boolean used;

        public SegmentTreeNode(int left, int right) {
            this.left = left;
            this.right = right;
            used = false;
        }
    }

    private void buildSegmentTree(SegmentTreeNode[] tree, int idx, int left, int right) {
        tree[idx] = new SegmentTreeNode(left, right);
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        mid = left % 2 == mid % 2 ? mid : mid - 1;
        buildSegmentTree(tree, idx * 2 + 1, left, mid);
        buildSegmentTree(tree, idx * 2 + 2, mid + 2, right);
    }

    private void updateSegmentTree(SegmentTreeNode[] tree, int idx, int value) {
        SegmentTreeNode node = tree[idx];
        if (node.used) {
            return;
        }

        if (node.left == node.right) {
            node.used = true;
            return;
        }

        int mid = (node.left + node.right) / 2;
        mid = mid % 2 == node.left % 2 ? mid : mid - 1;
        if (value <= mid) {
            updateSegmentTree(tree, idx * 2 + 1, value);
        } else {
            updateSegmentTree(tree, idx * 2 + 2, value);
        }
        node.used = tree[idx * 2 + 1].used && tree[idx * 2 + 2].used;
    }

    private void traverse(SegmentTreeNode[] tree, int idx, int left, int right, Set<Integer> ret) {
        SegmentTreeNode node = tree[idx];
        if (node.used) {
            return;
        }
        if (node.left == node.right) {
            ret.add(node.left);
            node.used = true;
            return;
        }
        int mid = (node.left + node.right) / 2;
        mid = mid % 2 == node.left % 2 ? mid : mid - 1;
        if (right <= mid) {
            traverse(tree, idx * 2 + 1, left, right, ret);
        } else if (left > mid) {
            traverse(tree, idx * 2 + 2, left, right, ret);
        } else {
            traverse(tree, idx * 2 + 1, left, mid, ret);
            traverse(tree, idx * 2 + 2, mid + 2, right, ret);
        }
        node.used = tree[idx * 2 + 1].used && tree[idx * 2 + 2].used;
    }

    private int getLeftBound(int p, int k) {
        int v = Math.min(k, p + 1);
        return k - v + 1 - v + p;
    }

    private int getRightBound(int p, int n, int k) {
        int v = Math.min(k, n - p);
        return v - k + v - 1 + p;
    }

    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        if (n == 1) {
            return new int[]{0};
        }
        SegmentTreeNode[] oddSegmentTree = new SegmentTreeNode[n << 1];
        SegmentTreeNode[] evenSegmentTree = new SegmentTreeNode[n << 1];
        buildSegmentTree(oddSegmentTree, 0, 1, n % 2 == 0 ? n - 1 : n - 2);
        buildSegmentTree(evenSegmentTree, 0, 0, n % 2 == 0 ? n - 2 : n - 1);

        int[] ans = new int[n];
        for (int i : banned) {
            ans[i] = -1;
            if (i % 2 == 0) {
                updateSegmentTree(evenSegmentTree, 0, i);
            } else {
                updateSegmentTree(oddSegmentTree, 0, i);
            }
        }

        if (p % 2 == 0) {
            updateSegmentTree(evenSegmentTree, 0, p);
        } else {
            updateSegmentTree(oddSegmentTree, 0, p);
        }
        ans[p] = 0;

        int[] queue = new int[n];
        queue[0] = p;
        int head = 0, tail = 1;
        while (head < tail) {
            int v = queue[head++];
            int step = ans[v] + 1;
            int left = getLeftBound(v, k);
            int right = getRightBound(v, n, k);
            SegmentTreeNode[] tree = left % 2 == 0 ? evenSegmentTree : oddSegmentTree;
            Set<Integer> next = new HashSet<>();
            traverse(tree, 0, left, right, next);
            for (int x : next) {
                ans[x] = step;
                queue[tail++] = x;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != p && ans[i] == 0) {
                ans[i] = -1;
            }
        }

        return ans;
    }
}