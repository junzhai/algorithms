package com.leetcode.algorithms.perfectRectangle_391;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ScanOneDimension extends Solution {
    @Override
    public boolean isRectangleCover(final int[][] rectangles) {
        int len = rectangles.length;
        Arrays.sort(rectangles, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Integer[] x2 = new Integer[len];
        for (int i = 0; i < len; i++) {
            x2[i] = i;
        }
        Arrays.sort(x2, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return rectangles[i1][2] - rectangles[i2][2];
            }
        });

        Set<Integer> bb = new HashSet<>(), ee = new HashSet<>();
        int p1 = 0, p2 = 0, xMin = rectangles[p1][0], yMin, yMax;
        while (p1 < len && rectangles[p1][0] < rectangles[x2[p2]][2]) {
            if (rectangles[p1][0] != xMin) {
                return false;
            }
            if (!add(bb, ee, rectangles[p1])) {
                return false;
            }
            p1 += 1;
        }

        if (bb.size() != 1 || ee.size() != 1) {
            return false;
        }

        yMin = bb.iterator().next();
        yMax = ee.iterator().next();
        if (yMin >= yMax) {
            return false;
        }

        while (p1 < len && p2 < len) {
            int end = rectangles[x2[p2]][2];
            if (rectangles[p1][0] > end) {
                return false;
            }

            while (p2 < len && rectangles[x2[p2]][2] == end) {
                delete(bb, ee, rectangles[x2[p2]]);
                p2 += 1;
            }

            while (p1 < len && rectangles[p1][0] < rectangles[x2[p2]][2]) {
                if (!add(bb, ee, rectangles[p1])) {
                    return false;
                }
                p1 += 1;
            }

            if (bb.size() != 1 || ee.size() != 1 || !bb.contains(yMin) || !ee.contains(yMax)) {
                return false;
            }
        }
        return true;
    }

    private boolean add(Set<Integer> b, Set<Integer> e, int[] p) {
        int y1 = p[1], y2 = p[3];
        if (b.contains(y1) || e.contains(y2)) {
            return false;
        }

        if (e.contains(y1)) {
            e.remove(y1);
        } else {
            b.add(y1);
        }
        if (b.contains(y2)) {
            b.remove(y2);
        } else {
            e.add(y2);
        }
        return true;
    }

    private void delete(Set<Integer> b, Set<Integer> e, int[] p) {
        int y1 = p[1], y2 = p[3];
        if (b.contains(y1)) {
            b.remove(y1);
        } else {
            e.add(y1);
        }
        if (e.contains(y2)) {
            e.remove(y2);
        } else {
            b.add(y2);
        }
    }
}
