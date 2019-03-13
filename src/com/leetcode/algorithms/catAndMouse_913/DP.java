package com.leetcode.algorithms.catAndMouse_913;

import java.util.LinkedList;
import java.util.Queue;

public class DP extends Solution {
    @Override
    int catMouseGame(int[][] graph) {
        int l = graph.length;
        int[] full = new int[l];
        for (int i = 1; i < l; i++) {
            int[] adj = graph[i];
            for (int n : adj) {
                if (n != 0) {
                    full[i] |= (1 << n);
                }
            }
        }

        int[][] ret = new int[l][l], dp = new int[l][l];
        Queue<Integer> q = new LinkedList<>();

        for (int b : graph[0]) {
            for (int a = 1; a < l; a++) {
                if (a == b) {
                    continue;
                }
                ret[a][b] = 1;
                for (int aa : graph[a]) {
                    if (update(dp, aa, b, full[aa], a)) {
                        if (aa != b) {
                            q.offer(aa * l + b);
                        }
                    }
                }
            }
        }

        if (ret[2][1] == 1) {
            return 1;
        }

        while (!q.isEmpty()) {
            int seq = q.poll(), a = seq / l, b = seq % l;
            for (int bb : graph[b]) {
                if (bb == 0 || bb == a) {
                    continue;
                }
                if (ret[a][bb] == 0) {
                    ret[a][bb] = 1;
                    for (int aa : graph[a]) {
                        if (aa == 0) {
                            continue;
                        }
                        if (update(dp, aa, bb, full[aa], a)) {
                            if (aa != bb) {
                                q.offer(aa * l + bb);
                            }
                        }
                    }
                }
            }
            if (ret[2][1] == 1) {
                return 1;
            }
        }

        dp = new int[l][l];
        for (int b = 1; b < l; b++) {
            for (int a : graph[b]) {
                if (update(dp, a, b, full[b], a)) {
                    q.offer(a * l + b);
                }
            }
            ret[b][b] = 2;
            for (int aa : graph[b]) {
                if (aa == 0) {
                    continue;
                }
                for (int bb : graph[b]) {
                    if (bb == 0) {
                        continue;
                    }
                    if (update(dp, aa, bb, full[bb], b)) {
                        q.offer(aa * l + bb);
                    }
                }
            }
        }

        if (ret[2][1] == 2) {
            return 2;
        }

        while (!q.isEmpty()) {
            int seq = q.poll(), a = seq / l, b = seq % l;
            if (ret[a][b] == 0) {
                ret[a][b] = 2;
                for (int aa : graph[a]) {
                    if (aa == 0) {
                        continue;
                    }
                    for (int bb : graph[b]) {
                        if (bb == 0) {
                            continue;
                        }
                        if (update(dp, aa, bb, full[bb], b)) {
                            q.offer(aa * l + bb);
                        }
                    }
                }
                if (ret[2][1] == 2) {
                    return 2;
                }
            }
        }

        return 0;
    }

    private boolean update(int[][] dp, int a, int b, int full, int i) {
        if (dp[a][b] != full) {
            dp[a][b] |= (1 << i);
            return dp[a][b] == full;
        }
        return false;
    }
}
