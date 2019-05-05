package com.leetcode.algorithms.erecttheFence_587;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[][] outerTrees(int[][] points) {
        int len = points.length;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int r = o1[0] - o2[0];
                if (r == 0) {
                    r = o1[1] - o2[1];
                }
                return r;
            }
        });

        int ymin = points[0][1], ymax = ymin;
        for (int i = 1; i < len; i++) {
            ymin = Math.min(ymin, points[i][1]);
            ymax = Math.max(ymax, points[i][1]);
        }

        int xmin = points[0][0], xmax = points[len - 1][0];

        int p = 0;
        Set<Integer> outer = new HashSet<>();

        for (int i = 0; i < len && points[i][0] == xmin; i++) {
            p = i;
            outer.add(i);
        }

        int[] ps = new int[len];
        while (points[p][1] < ymax) {
            int i = p + 1, dx = 0, dy = 0, l = 0;
            while (i < len) {
                if (points[i][1] <= points[p][1]) {
                    i += 1;
                    continue;
                }
                int ddy = points[i][1] - points[p][1], ddx = points[i][0] - points[p][0];
                int a = ddy * dx, b = ddx * dy;
                if (a >= b) {
                    l = a > b ? 0 : l;
                    ps[l++] = i;
                    dx = ddx;
                    dy = ddy;
                }
                if (points[i][1] == ymax) {
                    break;
                }
                i += 1;
            }

            for (int j = 0; j < l; j++) {
                outer.add(ps[j]);
            }
            p = ps[l - 1];
        }

        while (points[p][0] < xmax) {
            int i = p + 1, dx = 0, dy = 0, l = 0;
            while (i < len) {
                if (points[i][1] == ymax) {
                    outer.add(i);
                    p = i;
                    l = 0;
                    break;
                } else if (points[i][1] >= points[p][1]) {
                    i += 1;
                    continue;
                }
                int ddy = points[i][1] - points[p][1], ddx = points[i][0] - points[p][0];
                int a = ddy * dx, b = ddx * dy;
                if (a >= b) {
                    l = a > b ? 0 : l;
                    ps[l++] = i;
                    dx = ddx;
                    dy = ddy;
                }
                i += 1;
            }
            if (l > 0) {
                for (int j = 0; j < l; j++) {
                    outer.add(ps[j]);
                }
                p = ps[l - 1];
            }
        }

        for (int i = p  - 1; i >= 0 && points[i][0] == xmax; i--) {
            outer.add(i);
        }

        if (ymin == ymax) {
            int i = 0;
            int[][] ret = new int[outer.size()][0];
            for (int j : outer) {
                ret[i++] = points[j];
            }
            return ret;
        }

        p = 0;
        while (points[p][1] > ymin) {
            int i = p + 1, dx = 0, dy = 0, l = 0;
            while (i < len) {
                if (points[i][1] >= points[p][1]) {
                    i += 1;
                    continue;
                }
                int ddy = points[i][1] - points[p][1], ddx = points[i][0] - points[p][0];
                int a = ddy * dx, b = ddx * dy;
                if (a <= b) {
                    l = a < b ? 0 : l;
                    ps[l++] = i;
                    dx = ddx;
                    dy = ddy;
                }
                if (points[i][1] == ymin) {
                    break;
                }
                i += 1;
            }
            for (int j = 0; j < l; j++) {
                outer.add(ps[j]);
            }
            p = ps[l - 1];
        }

        while (points[p][0] < xmax) {
            int i = p + 1, dx = 0, dy = 0, l = 0;
            while (i < len) {
                if (points[i][1] == ymin) {
                    outer.add(i);
                    p = i;
                    l = 0;
                    break;
                } else if (points[i][1] <= points[p][1] || points[i][0] == points[p][0]) {
                    i += 1;
                    continue;
                }
                int ddy = points[i][1] - points[p][1], ddx = points[i][0] - points[p][0];
                int a = ddy * dx, b = ddx * dy;
                if (a <= b) {
                    l = a < b ? 0 : l;
                    ps[l++] = i;
                    dx = ddx;
                    dy = ddy;
                }
                if (points[i][0] == xmax) {
                    break;
                }
                i += 1;
            }

            if (l > 0) {
                for (int j = 0; j < l; j++) {
                    outer.add(ps[j]);
                }
                p = ps[l - 1];
            }
        }

        int i = 0;
        int[][] ret = new int[outer.size()][0];
        for (int j : outer) {
            ret[i++] = points[j];
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] ret;

        // {{0,3},{6,1},{3,5},{7,2},{5,0},{1,4},{1,2},{7,3},{4,5},{5,5},{6,5},{4,0},{3,0},{2,1},{2,5},{7,4}}
        ret = s.outerTrees(new int[][]{{3, 0}, {4, 0}, {5, 0}, {6, 1}, {7, 2}, {7, 3}, {7, 4}, {6, 5}, {5, 5}, {4, 5}
        , {3, 5}, {2, 5}, {1, 4}, {1, 3}, {1, 2}, {2, 1}, {4, 2}, {0, 3}});

        // {{100,100},{0,0},{0,100},{100,0}}
        ret = s.outerTrees(new int[][]{{0, 0}, {0, 100}, {100, 100}, {100, 0}, {50, 50}});

        // {{3,7},{7,13},{11,10},{8,5},{4,13},{4,3}}
        ret = s.outerTrees(new int[][]{{3, 7}, {6, 8}, {7, 8}, {11, 10}, {4, 3}, {8, 5}, {7, 13}, {4, 13}});

        ret = s.outerTrees(new int[][]{{3, 0}, {4, 0}, {5, 0}, {6, 1}, {7, 2}, {7, 3}, {7, 4}, {6, 5}, {5, 5}, {4, 5}
                , {3, 5}, {2, 5}, {1, 4}, {1, 3}, {1, 2}, {2, 1}, {4, 2}, {0, 3}});

        ret = s.outerTrees(new int[][]{{0, 0}, {1, 1}, {100, 100}});

        // {{1,2},{2,2},{4,2}}
        ret = s.outerTrees(new int[][]{{1, 2}, {2, 2}, {4, 2}});

        // {{1,1},{2,0},{4,2},{3,3},{2,4}}
        ret = s.outerTrees(new int[][]{{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}});
    }
}
