package com.leetcode.premium.lineReflecton_356;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NoSort extends Solution {
    @Override
    public boolean isReflected(int[][] points) {
        Map<Integer, Set<Integer>> cache = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int[] p : points) {
            min = Math.min(min, p[0]);
            max = Math.max(max, p[0]);
            if (!cache.containsKey(p[0])) {
                cache.put(p[0], new HashSet<>());
            }
            cache.get(p[0]).add(p[1]);
        }

        int m = min + max;
        for (int[] p : points) {
            int k = m - p[0];
            if (!cache.containsKey(k) || !cache.get(k).contains(p[1])) {
                return false;
            }
        }
        return true;
    }
}
