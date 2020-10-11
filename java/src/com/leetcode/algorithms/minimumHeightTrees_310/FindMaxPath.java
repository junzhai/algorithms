package com.leetcode.algorithms.minimumHeightTrees_310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMaxPath extends Solution {
    @Override
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[][] m = new int[n][0];
        for (int[] e : edges) {
            int l = m[e[0]].length;
            m[e[0]] = Arrays.copyOf(m[e[0]], l + 1);
            m[e[0]][l] = e[1];

            l = m[e[1]].length;
            m[e[1]] = Arrays.copyOf(m[e[1]], l + 1);
            m[e[1]][l] = e[0];
        }

        int[] r = new int[2], max = new int[1];
        helper(0, m, new boolean[n], r, max);

        List<Integer> ret = new ArrayList<>();
        ret.add(r[0]);
        if (max[0] % 2 == 0) {
            ret.add(r[1]);
        }

        return ret;
    }

    private List<Integer> helper(int n, int[][] m, boolean[] visited, int[] ret, int[] max) {
        visited[n] = true;

        int l1 = 0, l2 = 0;
        List<Integer> lp = null;
        for (int i : m[n]) {
            if (!visited[i]) {
                List<Integer> p = helper(i, m, visited, ret, max);
                int nl = p.size();
                if (nl > l1) {
                    l2 = l1;
                    l1 = nl;
                    lp = p;
                } else if (nl > l2) {
                    l2 = nl;
                }
            }
        }

        if (lp == null) {
            lp = new ArrayList<>();
        }
        lp.add(n);

        if (lp.size() + l2 > max[0]) {
            max[0] = lp.size() + l2;
            int i = max[0] / 2;
            if (max[0] % 2 == 0) {
                ret[0] = lp.get(i - 1);
                ret[1] = lp.get(i);
            } else {
                ret[0] = lp.get(i);
            }
        }

        return lp;
    }
}
