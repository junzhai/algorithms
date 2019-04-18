package com.leetcode.algorithms.gridIllumination_1001;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Index extends Solution {
    @Override
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        Set<Long> lampSet = new HashSet<>();
        Map<Integer, Integer> row = new HashMap<>(), column = new HashMap<>();
        Map<Integer, Integer> diagonal0 = new HashMap<>(), diagonal1 = new HashMap<>();

        for (int[] lamp : lamps) {
            int x = lamp[0], y = lamp[1];
            lampSet.add((long) x * N + y);
            row.put(x, row.getOrDefault(x, 0) + 1);
            column.put(y, column.getOrDefault(y, 0) + 1);
            diagonal0.put(x - y, diagonal0.getOrDefault(x - y, 0) + 1);
            diagonal1.put(x + y - N + 1, diagonal1.getOrDefault(x + y - N + 1, 0) + 1);
        }

        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            boolean luminated = row.getOrDefault(x, 0) > 0
                    || column.getOrDefault(y, 0) > 0
                    || diagonal0.getOrDefault(x - y, 0) > 0
                    || diagonal1.getOrDefault(x + y - N + 1, 0) > 0;
            for (int r = x - 1; r <= x + 1; r++) {
                for (int c = y - 1; c <= y + 1; c++) {
                    long n = (long) r * N + c;
                    if (!lampSet.contains(n)) {
                        continue;
                    }

                    lampSet.remove(n);
                    int tmp = row.getOrDefault(r, 0) - 1;
                    if (tmp > 0) {
                        row.put(r, tmp);
                    } else {
                        row.remove(r);
                    }

                    tmp = column.getOrDefault(c, 0) - 1;
                    if (tmp > 0) {
                        column.put(c, tmp);
                    } else {
                        column.remove(c);
                    }

                    int k = r - c;
                    tmp = diagonal0.getOrDefault(k, 0) - 1;
                    if (tmp > 0) {
                        diagonal0.put(k, tmp);
                    } else {
                        diagonal0.remove(k);
                    }

                    k = r + c - N + 1;
                    tmp = diagonal1.getOrDefault(k, 0) - 1;
                    if (tmp > 0) {
                        diagonal1.put(k, tmp);
                    } else {
                        diagonal1.remove(k);
                    }
                }
            }
            ret[i] = luminated ? 1 : 0;

        }
        return ret;
    }
}
