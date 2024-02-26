package com.leetcode.algorithms.minimumReverseOperations_2612;

import com.pattern.algorithms.BFS;
import com.pattern.algorithms.JavaTreeSet;

import java.util.*;

@BFS
public class UseTreeSet_2 extends Solution {

    @JavaTreeSet
    @Override
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        int[] ans = new int[n];
        for (int i : banned) {
            ans[i] = -1;
        }
        ans[p] = 0;

        TreeSet<Integer> even = new TreeSet<>(), odd = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (i == p || ans[i] == -1) {
                continue;
            }
            if (i % 2 == 0) {
                even.add(i);
            } else {
                odd.add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(p);
        while (!q.isEmpty()) {
            int pos = q.poll();
            int step = ans[pos] + 1;
            TreeSet<Integer> set;
            int left = getLeftBound(pos, k);
            int right = getRightBound(pos, n, k);
            if ((pos + k - 1) % 2 == 0) {
                set = even;
            } else {
                set = odd;
            }
            Set<Integer> vs = set.subSet(left, true, right, true);
            Iterator<Integer> it = vs.iterator();
            while (it.hasNext()) {
                int v = it.next();
                ans[v] = step;
                q.offer(v);
                it.remove();
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != p && ans[i] == 0) {
                ans[i] = -1;
            }
        }

        return ans;
    }

    private int getLeftBound(int p, int k) {
        int v = Math.min(p + 1, k);
        return k - v + 1 - v + p;
    }

    private int getRightBound(int p, int n, int k) {
        int v = Math.min(k, n - p);
        return v - (k - v + 1) + p;
    }
}
