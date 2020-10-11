package com.leetcode.algorithms.capacityToShipPackagesWithinDDays_1011;

@com.leetcode.algorithms.pattern.BinarySearch
public class BinarySearch extends Solution {
    @Override
    public int shipWithinDays(int[] weights, int D) {
        int total = 0, max = 0;
        for (int w : weights) {
            total += w;
            max = Math.max(max, w);
        }

        int l = Math.max((total + D - 1) / D, max), r = total;
        if (check(weights, l, D)) {
            return l;
        }

        while (l + 1 < r) {
            int m = (l + r) / 2;
            if (check(weights, m, D)) {
                r = m;
            } else {
                l = m;
            }
        }

        return Math.max(l, r);
    }

    private boolean check(int[] weights, int capacity, int D) {
        int len = weights.length, d = 0;
        for (int i = 0, sum = 0; i < len && d < D; i++) {
            sum += weights[i];
            if (sum > capacity) {
                d += 1;
                sum = weights[i];
            }
        }
        return d < D;
    }
}
