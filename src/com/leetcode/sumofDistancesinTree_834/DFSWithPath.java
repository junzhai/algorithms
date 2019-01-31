package com.leetcode.sumofDistancesinTree_834;

import com.pattern.DFS;

import java.util.Arrays;

@DFS
public class DFSWithPath extends Solution {
    @Override
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[][] g = new int[N][0];
        for (int[] e : edges) {
            int[] children = g[e[0]];
            children = Arrays.copyOf(children, children.length + 1);
            children[children.length - 1] = e[1];
            g[e[0]] = children;

            children = g[e[1]];
            children = Arrays.copyOf(children, children.length + 1);
            children[children.length - 1] = e[0];
            g[e[1]] = children;
        }

        int[] count = new int[N], sum = new int[N], ret = new int[N];
        countAndSum(g, 0, count, sum, new boolean[N]);
        cal(g, 0, sum, count, ret, new int[N], 0, new boolean[N]);
        return ret;
    }

    private void countAndSum(int[][] g, int n, int[] count, int[] sum, boolean[] visited) {
        visited[n] = true;
        int c = 1, s = 0;
        for (int p : g[n]) {
            if (!visited[p]) {
                countAndSum(g, p, count, sum, visited);
                c += count[p];
                s += sum[p] + count[p];
            }
        }
        count[n] = c;
        sum[n] = s;
        visited[n] = false;
    }

    private void cal(int[][] g, int n, int[] sum, int[] count, int[] ret, int[] path, int len, boolean[] visited) {
        ret[n] += sum[n];
        path[len] = n;
        for (int i = 0; i < len; i++) {
            ret[n] += sum[path[i]] - sum[path[i + 1]] - count[path[i + 1]];
            ret[n] += (len - i) * (count[path[i]] - count[path[i + 1]]);
        }
        visited[n] = true;
        for (int p : g[n]) {
            if (!visited[p]) {
                path[len] = n;
                cal(g, p, sum, count, ret, path, len + 1, visited);
            }
        }
        visited[n] = false;
    }
}
