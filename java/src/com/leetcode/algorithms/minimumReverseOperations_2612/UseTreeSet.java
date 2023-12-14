package com.leetcode.algorithms.minimumReverseOperations_2612;

import com.pattern.algorithms.BFS;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

@BFS
public class UseTreeSet extends Solution {

    @com.pattern.algorithms.TreeSet
    @Override
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        int[] ans = new int[n];
        for (int i : banned) {
            ans[i] = -1;
        }
        ans[p] = 0;

        TreeSet<Integer> odd = new TreeSet<>(), even = new TreeSet<>();
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

        int[] q = new int[n];
        int end = 0;
        q[end++] = p;
        int start = 0;
        while (end - start > 0) {
            int pos = q[start++];
            int step = ans[pos] + 1;

            int x = Math.min(pos, k - 1);
            int min = pos + k - x - 1 - x;
            x = Math.min(n - 1 - pos, k - 1);
            int max = pos + x - (k - x - 1);

            Set<Integer> sub = (max % 2 == 0) ? even.subSet(min, max + 1) : odd.subSet(min, max + 1);
            Iterator<Integer> it = sub.iterator();
            while (it.hasNext()) {
                int i = it.next();
                ans[i] = step;
                q[end++] = i;
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
}
