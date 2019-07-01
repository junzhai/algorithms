package com.leetcode.algorithms.KClosestPointstoOrigin_973;

import com.leetcode.algorithms.pattern.QuickSelect;

import java.util.Arrays;

@QuickSelect
public class UseQuickSelect extends Solution {
    @Override
    public int[][] kClosest(int[][] points, int K) {
        int len = points.length, l = 0, r = len - 1;
        while (l < r) {
            int m = partition(points, l, r);
            if (m + 1 == K) {
                break;
            }
            if (m + 1 < K) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int partition(int[][] points, int l, int r) {
        int[] pivot = points[l];
        int pd = pivot[0] * pivot[0] + pivot[1] * pivot[1];
        while (l < r) {
            while (l < r && compare(points[r], pd) >= 0) {
                r -= 1;
            }
            points[l] = points[r];
            while (l < r && compare(points[l], pd) <= 0) {
                l += 1;
            }
            points[r] = points[l];
        }

        points[l] = pivot;
        return l;
    }

    private int compare(int[] p, int d) {
        return p[0] * p[0] + p[1] * p[1] - d;
    }
}
