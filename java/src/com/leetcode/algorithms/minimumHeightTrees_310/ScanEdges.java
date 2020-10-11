package com.leetcode.algorithms.minimumHeightTrees_310;

import java.util.ArrayList;
import java.util.List;

// Exceed time limit
public class ScanEdges extends Solution {
    @Override
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ret = new ArrayList<>();
        if (n == 1) {
            ret.add(0);
            return ret;
        }

        int[][] dp = new int[n][n];
        int[] count = new int[n];
        int step = 1;
        while (ret.isEmpty()) {
            for (int[] e : edges) {
                for (int k = 0; k < n; k++) {
                    if (k == e[1] || k == e[0]) {
                        if (!connected(e[0], e[1], step, dp)) {
                            connect(n, e[0], e[1], step, dp, count, ret);
                        }
                        continue;
                    }

                    if (connected(k, e[0], step, dp) && !connected(k, e[1], step, dp)) {
                        connect(n, k, e[1], step, dp, count, ret);
                        continue;
                    }

                    if (!connected(k, e[0], step, dp) && connected(k, e[1], step, dp)) {
                        connect(n, k, e[0], step, dp, count, ret);
                    }
                }
            }
            step += 1;
        }
        return ret;
    }

    private boolean connected(int a, int b, int step, int[][] dp) {
        return dp[a][b] > 0 && dp[a][b] < step;
    }

    private void connect(int n, int a, int b, int step, int[][] dp, int[] count, List<Integer> ret) {
        if (dp[a][b] == 0) {
            count[a] += 1;
            count[b] += 1;
            if (count[a] == n - 1) {
                ret.add(a);
            }
            if (count[b] == n - 1) {
                ret.add(b);
            }
        }
        dp[a][b] = step;
        dp[b][a] = step;
    }
}
