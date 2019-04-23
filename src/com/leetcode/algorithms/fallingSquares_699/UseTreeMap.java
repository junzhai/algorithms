package com.leetcode.algorithms.fallingSquares_699;

import com.leetcode.algorithms.pattern.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

@BinarySearchTree
public class UseTreeMap extends Solution {
    @Override
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> ret = new ArrayList<>();
        java.util.TreeMap<Integer, Integer> dp = new java.util.TreeMap<>();
        dp.put(0, 0);

        int max = 0;
        for (int[] p : positions) {
            int left = p[0], right = p[0] + p[1], h = 0, last = 0;
            Integer k = dp.floorKey(p[0]);
            while (k != null && k < right) {
                last = k < left ? dp.get(k) : dp.remove(k);
                h = Math.max(h, last);
                k = dp.ceilingKey(k + 1);
            }

            h += p[1];
            dp.put(left, h);
            if (k == null || k > right) {
                dp.put(right, last);
            }

            max = Math.max(max, h);
            ret.add(max);
        }

        return ret;
    }
}
