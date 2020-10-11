package com.leetcode.algorithms.shortestPathVisitingAllNodes_847;

import com.leetcode.algorithms.pattern.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

@DP
public class UseDP extends Solution {
    @Override
    public int shortestPathLength(int[][] graph) {
        int[][] minDist = minDist(graph);
        int len = graph.length, ret = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int[] tmp = new int[len + 1];
            Arrays.fill(tmp, Integer.MAX_VALUE);
            ret = Math.min(ret, helper(graph, minDist, i, 1 << i, 0, tmp, null));
            if (ret == len - 1) {
                break;
            }
        }
        return ret;
    }

    private int[][] minDist(int[][] graph) {
        int len = graph.length;
        int[][] ret = new int[len][len];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int visited = 1 << i;
            q.offer(i);
            int dist = 0, size = 1;
            while (size > 0) {
                int nSize = 0;
                for (int j = 0; j < size; j++) {
                    int v = q.poll();
                    ret[i][v] = dist;
                    ret[v][i] = dist;
                    for (int child : graph[v]) {
                        int m = 1 << child;
                        if ((visited & m) == 0) {
                            q.offer(child);
                            nSize += 1;
                            visited += m;
                        }
                    }
                }
                size = nSize;
                dist += 1;
            }
        }
        return ret;
    }

    private int helper(int[][] graph, int[][] minDist, int v, int visited, int step, int[] dp, int[] min) {
        int len = graph.length, all = (1 << len) - 1;
        if (visited == all) {
            return len - 1;
        }

        int total = 0;
        int[] children = graph[v];
        Map<Integer, int[]> minCircle = new HashMap<>();
        dp[len] = 1 << v;
        for (int child : children) {
            int m = 1 << child;
            if ((visited & m) > 0) {
                continue;
            }
            int[] tmp = new int[len + 1];
            Arrays.fill(tmp, Integer.MAX_VALUE);
            int r = helper(graph, minDist, child, visited + m, step + 1, tmp, min);
            if (r == len - 1) {
                return r;
            }
            dp[len] |= tmp[len];
            int minc = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                if (tmp[i] < Integer.MAX_VALUE) {
                    minc = Math.min(minc, tmp[i] + 1 + minDist[i][v]);
                }
            }

            if (minCircle.containsKey(tmp[len])) {
                int[] a = minCircle.get(tmp[len]);
                for (int i = 0; i < len; i++) {
                    if (tmp[i] < a[i]) {
                        a[i] = tmp[i];
                    }
                }
                if (minc < a[len]) {
                    total -= a[len] - minc;
                    a[len] = minc;
                }
            } else {
                minCircle.put(tmp[len], tmp);
                total += minc;
                tmp[len] = minc;
            }
        }

        int mm = Integer.MAX_VALUE;
        if (total == 0) {
            dp[v] = 0;
            mm = 0;
        } else {
            for (int cc : minCircle.keySet()) {
                int[] p = minCircle.get(cc);
                for (int i = 0; i < len; i++) {
                    if (p[i] < Integer.MAX_VALUE) {
                        int pp = p[i] + 1 + total - p[len];
                        dp[i] = Math.min(dp[i], pp);
                        mm = Math.min(mm, pp);
                    }
                }
            }
        }

        return (dp[len] | visited) == all ? mm + step: Integer.MAX_VALUE;
    }
}
