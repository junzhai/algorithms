package com.leetcode.algorithms.minimumReverseOperations_2612;

import com.pattern.algorithms.BFS;
import com.pattern.algorithms.JavaTreeSet;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

@BFS
public class BFSRangeUseTreeSet extends Solution {

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

        // BFS queue a consecutive range (odd/even). Process it yields a list of new consecutive ranges.
        int[][] queue = new int[n][2];
        queue[0][0] = p;
        queue[0][1] = p;
        int head = 0, tail = 1;
        while (head < tail) {
            int[] range = queue[head++];
            int step = ans[range[0]] + 1;
            int[] nextRange = getNextRange(range, n, k);
            TreeSet<Integer> set = nextRange[0] % 2 == 0 ? even : odd;
            Set<Integer> vs = set.subSet(nextRange[0], true, nextRange[1], true);
            if (vs.isEmpty()) {
                continue;
            }
            Iterator<Integer> it = vs.iterator();
            int s = -1, pre = -1;
            while (it.hasNext()) {
                int v = it.next();
                ans[v] = step;
                it.remove();
                if (s == -1) {
                    s = v;
                } else if (v - pre > 2) {
                    queue[tail++] = new int[]{s, pre};
                    s = v;
                }
                pre = v;
            }
            queue[tail++] = new int[]{s, pre};
        }

        for (int i = 0; i < n; i++) {
            if (i != p && ans[i] == 0) {
                ans[i] = -1;
            }
        }

        return ans;
    }

    private int[] getNextRange(int[] range, int n, int k) {
        int l, r;
        if (k - 1 < range[0]) {
            l = range[0] - k + 1;
        } else if (k - 1 <= range[1]) {
            if ((k - 1) % 2 == range[0] % 2) {
                l = 0;
            } else {
                l = getLeftBound(k, k);
            }
        } else {
            l = getLeftBound(range[1], k);
        }

        if (n - k > range[1]) {
            r = range[1] + k - 1;
        } else if (n - k >= range[0]) {
            if ((n - k) % 2 == range[0] % 2) {
                r = n - 1;
            } else {
                r = getRightBound(n - k + 1, n, k);
            }
        } else {
            r = getRightBound(range[0], n, k);
        }

        return new int[]{l, r};
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
