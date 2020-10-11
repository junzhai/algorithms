package com.leetcode.algorithms.soupServings_808;

import com.leetcode.algorithms.pattern.BFS;

import java.util.HashMap;
import java.util.Map;

@BFS
public class BFSWithCircularQueue extends Solution {
    @Override
    public double soupServings(int N) {
        if (N > 4800) {
            return 1;
        }

        double af = 0.0, eq = 0.0;
        int h = 0, l = 1, len = Math.min(N + 1, 200);
        int[][] q = new int[N + 1][2];
        Map<String, Double> cache = new HashMap<>();
        cache.put("0.0", 1.0);

        while (l > 0) {
            int[] p = q[h];
            l -= 1;
            h = (h + 1) % len;
            double c = cache.remove(p[0] + "." + p[1]) / 4;
            if (p[0] + 100 >= N && p[1] >= N) {
                eq += c;
            } else if (p[0] + 100 >= N) {
                af += c;
            } else {
                int a = p[0] + 100, b = p[1];
                String k = a + "." + b;
                if (cache.containsKey(k)) {
                    cache.put(k, cache.get(k) + c);
                } else {
                    cache.put(k, c);
                    int i = (h + l) % len;
                    l += 1;
                    q[i][0] = a;
                    q[i][1] = b;
                }
            }
            if (p[0] + 75 >= N && p[1] + 25 >= N) {
                eq += c;
            } else if (p[0] + 75 >= N) {
                af += c;
            } else if (p[1] + 25 < N) {
                int a = p[0] + 75, b = p[1] + 25;
                String k = a + "." + b;
                if (cache.containsKey(k)) {
                    cache.put(k, cache.get(k) + c);
                } else {
                    cache.put(k, c);
                    int i = (h + l) % len;
                    l += 1;
                    q[i][0] = a;
                    q[i][1] = b;
                }
            }
            if (p[0] + 50 >= N && p[1] + 50 >= N) {
                eq += c;
            } else if (p[0] + 50 >= N) {
                af += c;
            } else if (p[1] + 50 < N) {
                int a = p[0] + 50, b = p[1] + 50;
                String k = a + "." + b;
                if (cache.containsKey(k)) {
                    cache.put(k, cache.get(k) + c);
                } else {
                    cache.put(k, c);
                    int i = (h + l) % len;
                    l += 1;
                    q[i][0] = a;
                    q[i][1] = b;
                }
            }
            if (p[0] + 25 >= N && p[1] + 75 >= N) {
                eq += c;
            } else if (p[0] + 25 >= N) {
                af += c;
            } else if (p[1] + 75 < N) {
                int a = p[0] + 25, b = p[1] + 75;
                String k = a + "." + b;
                if (cache.containsKey(k)) {
                    cache.put(k, cache.get(k) + c);
                } else {
                    cache.put(k, c);
                    int i = (h + l) % len;
                    l += 1;
                    q[i][0] = a;
                    q[i][1] = b;
                }
            }
        }

        return af + eq / 2;
    }
}
