package com.leetcode.algorithms.catAndMouse_913;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NewGraph extends Solution {
    @Override
    public int catMouseGame(int[][] graph) {
        int len = graph.length;
        int[][] minDis = new int[graph[0].length][len];
        for (int i = 0; i < minDis.length; i++) {
            calMinDis(graph, graph[0][i], minDis[i]);
        }

        int[][] dp = init(graph, minDis);

        for (int a = 1; a < len; a++) {
            for (int b = 1; b < len; b++) {
                if (dp[a][b] != 3) {
                    continue;
                }
                Queue<Integer> q = new LinkedList<>();
                q.offer(a * len + b);
                while (!q.isEmpty()) {
                    int seq = q.poll(), aa = seq / len, bb = seq % len;
                    int v = infer(aa, bb, graph, dp);
                    if (dp[aa][bb] != v) {
                        dp[aa][bb] = v;
                        for (int na : graph[aa]) {
                            for (int nb : graph[bb]) {
                                if (dp[na][nb] == 3) {
                                    q.offer(na * len + nb);
                                }
                            }
                        }
                    }
                }
            }
        }
        return dp[2][1] == 3 ? 0 : dp[2][1];
    }

    private void calMinDis(int[][] graph, int p, int[] dis) {
        Arrays.fill(dis, dis.length);
        dis[0] = 1;
        dis[p] = 0;
        boolean[] v = new boolean[dis.length];
        v[0] = true;
        v[p] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(p);
        while (!q.isEmpty()) {
            int n = q.poll(), d = dis[n];
            for (int a : graph[n]) {
                dis[a] = Math.min(dis[a], d + 1);
                if (!v[a]) {
                    q.offer(a);
                    v[a] = true;
                }
            }
        }
    }

    private int[][] init(int[][] graph, int[][] minDis) {
        int len = graph.length;
        int[][] ret = new int[len][len];

        int a = 2, b = 1;
        ret[a][b] = state(a, b, minDis);
        Queue<Integer> q = new LinkedList<>();
        q.offer(a * len + b);
        while (!q.isEmpty()) {
            int seq = q.poll(), aa = seq / len, bb = seq % len;
            for (int na : graph[aa]) {
                if (na == 0 || na == bb) {
                    continue;
                }
                for (int nb : graph[bb]) {
                    if (nb == 0 || nb == aa) {
                        continue;
                    }
                    if (ret[na][nb] == 0) {
                        ret[na][nb] = state(na, nb, minDis);
                        q.offer(na * len + nb);
                    }
                }
            }
        }
        return ret;
    }

    private int state(int a, int b, int[][] minDis) {
        if (a == b) {
            return 2;
        }

        for (int[] min : minDis) {
            if (min[a] > min[b]) {
                return 1;
            }
        }
        return 3;
    }

    private int infer(int a, int b, int[][] graph, int[][] dp) {
        boolean aWin = true;
        for (int bb : graph[b]) {
            if (bb == 0 || bb == a) {
                continue;
            }
            boolean aaWin = false, bWin = true;
            for (int aa : graph[a]) {
                if (dp[aa][bb] == 3) {
                    bWin = false;
                } else if (dp[aa][bb] == 2) {
                    bWin = false;
                    aaWin = true;
                    break;
                }
            }
            if (bWin) {
                return 1;
            }
            aWin &= aaWin;
        }
        return aWin ? 2 : 3;
    }
}
