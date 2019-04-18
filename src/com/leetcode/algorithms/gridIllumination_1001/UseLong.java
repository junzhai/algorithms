package com.leetcode.algorithms.gridIllumination_1001;

import java.util.Arrays;

/**
 * Time Limit Exceeded
 */
public class UseLong extends Solution {
    @Override
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        long[] l = new long[lamps.length];
        boolean[] off = new boolean[lamps.length];
        for (int i = 0; i < lamps.length; i++) {
            l[i] = (long) lamps[i][0] * N + lamps[i][1];
        }
        Arrays.sort(l);

        long max = (long) N * N;
        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            boolean luminated = false;
            int x = queries[i][0], y = queries[i][1];

            for (int r = Math.max(0, x - 1); r <= Math.min(N, x + 1); r++) {
                for (int c = Math.max(0, y - 1); c <= Math.min(N, y + 1); c++) {
                    long t = (long) r * N + c;
                    int p = Arrays.binarySearch(l, t);
                    if (p >= 0 && !off[p]) {
                        luminated = true;
                        off[p] = true;
                    }
                }
            }

            if (!luminated) {
                for (int c = 0; c < y - 1; c++) {
                    long t = (long) x * N + c;
                    int p = Arrays.binarySearch(l, t);
                    if (p >= 0 && !off[p]) {
                        luminated = true;
                        break;
                    }
                }
            }

            if (!luminated) {
                for (int c = y + 2; c < N; c++) {
                    long t = (long) x * N + c;
                    int p = Arrays.binarySearch(l, t);
                    if (p >= 0 && !off[p]) {
                        luminated = true;
                        break;
                    }
                }
            }

            if (!luminated) {
                for (int r = 0; r < x - 1; r++) {
                    long t = (long) r * N + y;
                    int p = Arrays.binarySearch(l, t);
                    if (p >= 0 && !off[p]) {
                        luminated = true;
                        break;
                    }
                }
            }

            if (!luminated) {
                for (int r = x + 2; r < N; r++) {
                    long t = (long) r * N + y;
                    int p = Arrays.binarySearch(l, t);
                    if (p >= 0 && !off[p]) {
                        luminated = true;
                        break;
                    }
                }
            }

            if (!luminated) {
                for (int r = x - 2, c = y - 2; r >= 0 && c >= 0; r--, c--) {
                    long t = (long) r * N + c;
                    int p = Arrays.binarySearch(l, t);
                    if (p >= 0 && !off[p]) {
                        luminated = true;
                        break;
                    }
                }
            }

            if (!luminated) {
                for (int r = x - 2, c = y + 2; r >= 0 && c < N; r--, c++) {
                    long t = (long) r * N + c;
                    int p = Arrays.binarySearch(l, t);
                    if (p >= 0 && !off[p]) {
                        luminated = true;
                        break;
                    }
                }
            }

            if (!luminated) {
                for (int r = x + 2, c = y - 2; r < N && c >= 0; r++, c--) {
                    long t = (long) r * N + c;
                    int p = Arrays.binarySearch(l, t);
                    if (p >= 0 && !off[p]) {
                        luminated = true;
                        break;
                    }
                }
            }

            if (!luminated) {
                for (int r = x + 2, c = y + 2; r < N && c < N; r++, c++) {
                    long t = (long) r * N + c;
                    int p = Arrays.binarySearch(l, t);
                    if (p >= 0 && !off[p]) {
                        luminated = true;
                        break;
                    }
                }
            }

            ret[i] = luminated ? 1 : 0;
        }
        return ret;
    }
}
