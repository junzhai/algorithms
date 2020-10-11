package com.leetcode.algorithms.fruitIntoBaskets_904;

import com.leetcode.algorithms.pattern.SlidingWindow;

import static org.junit.Assert.assertEquals;

@SlidingWindow
public class Solution {
    public int totalFruit(int[] tree) {
        int ret = 0;
        for (int i = 0, b = 0, t1 = -1, t2 = -1, p1 = -1, p2 = -1; i < tree.length; i++) {
            if (t1 == -1) {
                t1 = tree[i];
                p1 = i;
            } else if (t1 == tree[i]) {
                p1 = i;
            } else if (t2 == -1) {
                t2 = tree[i];
                p2 = i;
            } else if (t2 == tree[i]) {
                p2 = i;
            } else if (p1 < p2) {
                b = p1 + 1;
                t1 = t2;
                p1 = p2;
                t2 = tree[i];
                p2 = i;
            } else {
                b = p2 + 1;
                t2 = tree[i];
                p2 = i;
            }
            ret = Math.max(ret, i - b + 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;
        ret = s.totalFruit(new int[]{0, 1, 2, 2});
        assertEquals(3, ret);
    }
}
