package com.leetcode.algorithms.soupServings_808;

import com.pattern.algorithms.BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

@BFS
public class BFSWithQueue extends Solution {
    @Override
    public double soupServings(int N) {
        if (N > 4800) {
            return 1;
        }

        double af = 0.0, eq = 0.0;
        double total = 1.0, afirst = 0, equal = 0, count = 1;
        Queue<int[]> q = new LinkedList<>();
        Map<String, Double> cache = new HashMap<>();
        q.offer(new int[]{0, 0});
        cache.put("0.0", 1.0);

        while (!q.isEmpty()) {
            total *= 4;
            afirst = 0;
            equal = 0;
            int nc = 0;
            for (int i = 0; i < count; i++) {
                int[] p = q.poll();
                double c = cache.remove(p[0] + "." + p[1]);
                if (p[0] + 100 >= N && p[1] >= N) {
                    equal += c;
                } else if (p[0] + 100 >= N) {
                    afirst += c;
                } else {
                    int a = p[0] + 100, b = p[1];
                    String k = a + "." + b;
                    if (cache.containsKey(k)) {
                        cache.put(k, cache.get(k) + c);
                    } else {
                        cache.put(k, c);
                        q.offer(new int[]{a, b});
                        nc += 1;
                    }
                }
                if (p[0] + 75 >= N && p[1] + 25 >= N) {
                    equal += c;
                } else if (p[0] + 75 >= N) {
                    afirst += c;
                } else if (p[1] + 25 < N) {
                    int a = p[0] + 75, b = p[1] + 25;
                    String k = a + "." + b;
                    if (cache.containsKey(k)) {
                        cache.put(k, cache.get(k) + c);
                    } else {
                        cache.put(k, c);
                        q.offer(new int[]{a, b});
                        nc += 1;
                    }
                }
                if (p[0] + 50 >= N && p[1] + 50 >= N) {
                    equal += c;
                } else if (p[0] + 50 >= N) {
                    afirst += c;
                } else if (p[1] + 50 < N) {
                    int a = p[0] + 50, b = p[1] + 50;
                    String k = a + "." + b;
                    if (cache.containsKey(k)) {
                        cache.put(k, cache.get(k) + c);
                    } else {
                        cache.put(k, c);
                        q.offer(new int[]{a, b});
                        nc += 1;
                    }
                }
                if (p[0] + 25 >= N && p[1] + 75 >= N) {
                    equal += c;
                } else if (p[0] + 25 >= N) {
                    afirst += c;
                } else if (p[1] + 75 < N) {
                    int a = p[0] + 25, b = p[1] + 75;
                    String k = a + "." + b;
                    if (cache.containsKey(k)) {
                        cache.put(k, cache.get(k) + c);
                    } else {
                        cache.put(k, c);
                        q.offer(new int[]{a, b});
                        nc += 1;
                    }
                }
            }
            af += (afirst) / total;
            eq += (equal) / total;
            count = nc;
        }

        return af + eq / 2;
    }
}
