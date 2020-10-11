package com.leetcode.algorithms.xxx_countofRangeSum_327;

import com.leetcode.algorithms.pattern.SegmentOrAreaOrKDTree;

import java.util.Arrays;

@SegmentOrAreaOrKDTree
public class RollingSuminSegmentTree extends Solution {
    private class SegmentTreeNode {
        long min, max;
        int count;
        SegmentTreeNode left, right;

        SegmentTreeNode(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }

    @Override
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length, ret = 0;
        if (len == 0) {
            return 0;
        }

        long[] sum = new long[len];
        for (int i = 0; i < len; i++) {
            sum[i] = (i == 0 ? 0 : sum[i - 1]) + nums[i];
        }

        long[] o = Arrays.copyOf(sum, len);
        Arrays.sort(o);
        SegmentTreeNode root = buildTree(o, 0, len - 1);

        update(root, sum[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            ret += count(root, sum[i] + lower, sum[i] + upper);
            update(root, sum[i]);
        }
        ret += count(root, lower, upper);
        return ret;
    }

    private SegmentTreeNode buildTree(long[] arr, int b, int e) {
        if (b > e) {
            return null;
        }

        if (b == e) {
            return new SegmentTreeNode(arr[b], arr[e]);
        }

        SegmentTreeNode ret = new SegmentTreeNode(arr[b], arr[e]);
        int m = (b + e) / 2;
        ret.left = buildTree(arr, b, m);
        ret.right = buildTree(arr, m + 1, e);
        return ret;
    }

    private void update(SegmentTreeNode root, long v) {
        SegmentTreeNode p = root;
        while (p != null) {
            if (v > p.max || v < p.min) {
                return;
            }
            p.count += 1;

            if (p.left == null) {
                return;
            }

            if (v <= p.left.max) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
    }

    private int count(SegmentTreeNode p, long lower, long upper) {
        if (p.max < lower || p.min > upper) {
            return 0;
        }

        if (lower <= p.min && upper >= p.max) {
            return p.count;
        }

        return count(p.left, lower, upper) + count(p.right, lower, upper);
    }
}
