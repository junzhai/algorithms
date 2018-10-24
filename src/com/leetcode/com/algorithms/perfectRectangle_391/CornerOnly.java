package com.leetcode.com.algorithms.perfectRectangle_391;

import java.util.HashMap;
import java.util.Map;

public class CornerOnly extends Solution {
    @Override
    public boolean isRectangleCover(int[][] rectangles) {
        long m = Integer.MAX_VALUE;
        Map<Long, Integer> cache = new HashMap<>();
        for (int[] r : rectangles) {
            long k = r[0] * m + r[1];
            if (!add(cache, k, 0)) {
                return false;
            }

            k = r[0] * m + r[3];
            if (!add(cache, k, 3)) {
                return false;
            }

            k = r[2] * m + r[1];
            if (!add(cache, k, 1)) {
                return false;
            }

            k = r[2] * m + r[3];
            if (!add(cache, k, 2)) {
                return false;
            }
        }

        return cache.size() == 4;
    }

    private boolean add(Map<Long, Integer> cache, long k, int quadrant) {
        int mask = 1 << quadrant;
        if (cache.containsKey(k)) {
            int v = cache.get(k);
            if ((v & mask) > 0) {
                return false;
            }

            int nMask = 1 << (quadrant + 1) % 4;
            int pMask = 1 << (quadrant + 3) % 4;
            if ((v & nMask) > 0) {
                v ^= nMask;
            } else if ((v & pMask) > 0) {
                v ^= pMask;
            } else {
                v |= mask;
            }

            if (v == 0) {
                cache.remove(k);
            } else {
                cache.put(k, v);
            }
        } else {
            cache.put(k, mask);
        }
        return true;
    }
}
