package com.leetcode.algorithms.capacityToShipPackagesWithinDDays_1011;

import java.util.Arrays;

/**
 * Slow
 */
public class TryCapacity extends Solution {
    @Override
    public int shipWithinDays(int[] weights, int D) {
        int len = weights.length, max = 0;
        int[] sum = new int[len];
        for (int i = 0, s = 0; i < len; i++) {
            s += weights[i];
            sum[i] = s;
            max = Math.max(max, weights[i]);
        }

        int[] ships = new int[D], sort = new int[D], sortv = new int[D];
        int sl = 0, ret = Math.max((sum[len - 1] + D - 1) / D, max), si = 0, c = 0;
        boolean found = false;
        while (!found) {
            c += 1;
            for (int i = si; i < D; i++) {
                int lastSum = i > 0 ? sum[ships[i - 1]] : 0;
                int p = Arrays.binarySearch(sum, i > 0 ? ships[i - 1] + 1 : 0, len, ret + lastSum);
                p = p < 0 ? -p - 2 : p;
                ships[i] = p;
                if (p >= len - 1) {
                    found = true;
                    break;
                }

                int v = sum[p] - lastSum + weights[p + 1];
                if (sl == 0 || v < sortv[sl - 1]) {
                    sort[sl] = i;
                    sortv[sl] = v;
                    sl += 1;
                }
            }

            if (!found) {
                sl -= 1;
                si = sort[sl];
                ret = sortv[sl];
            }
        }
        return ret;
    }
}
