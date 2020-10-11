package com.leetcode.algorithms.sumofDistancesinTree_834;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@com.leetcode.algorithms.pattern.DFS
public class DFS extends Solution {
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

        int[] ret = new int[N];
        helper(ret, 0, g, new boolean[N]);
        return ret;
    }

    private Map<Integer, Integer> helper(int[] ret, int n, int[][] g, boolean[] visited) {
        visited[n] = true;
        Map<Integer, Integer> ans = new HashMap<>();
        int c = 1, s = 0;
        for (int p : g[n]) {
            if (!visited[p]) {
                Map<Integer, Integer> path = helper(ret, p, g, visited);
                int ss = path.remove(-1), cc = path.size();
                c += cc;
                s += ss + cc;
                for (int pp : path.keySet()) {
                    int l = path.get(pp) + 1;
                    ret[pp] -= l * cc;
                    ret[pp] -= ss + cc;
                    ans.put(pp, l);
                }
            }
        }

        for (int pp : ans.keySet()) {
            ret[pp] += ans.get(pp) * c;
            ret[pp] += s;
        }

        ret[n] += s;
        ans.put(n, 0);
        ans.put(-1, s);
        visited[n] = false;
        return ans;
    }
}
