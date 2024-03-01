package com.leetcode.algorithms.minimumReverseOperations_2612;

import com.pattern.algorithms.BFS;
import com.pattern.algorithms.JavaTreeSet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

@BFS
public class BFSRangeUseTreeMap extends Solution {

    @JavaTreeSet
    @Override
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        int[] ans = new int[n];
        for (int i : banned) {
            ans[i] = -1;
        }
        ans[p] = 0;

        TreeMap<Integer, Integer> even = new TreeMap<>(), odd = new TreeMap<>();
        int os = -1, es = -1;
        for (int i = 0; i < n; i++) {
            if (i == p || ans[i] == -1) {
                if (i % 2 == 0) {
                    if (es > -1) {
                        even.put(es, i - 2);
                        es = -1;
                    }
                } else {
                    if (os > -1) {
                        odd.put(os, i - 2);
                        os = -1;
                    }
                }
            } else {
                if (i % 2 == 0) {
                    if (es == -1) {
                        es = i;
                    }
                } else {
                    if (os == -1) {
                        os = i;
                    }
                }
            }
        }
        if (os > -1) {
            odd.put(os, (n - 1) % 2 == 0 ? n - 2 : n - 1);
        }
        if (es > -1) {
            even.put(es, (n - 1) % 2 == 0 ? n - 1 : n - 2);
        }

        int[][] queue = new int[n][2];
        queue[0][0] = p;
        queue[0][1] = p;
        int head = 0, tail = 1;
        while (head < tail) {
            int[] range = queue[head++];
            int step = ans[range[0]] + 1;
            int[] nextRange = getNextRange(range, n, k);
            TreeMap<Integer, Integer> map = nextRange[0] % 2 == 0 ? even : odd;
            Map<Integer, Integer> ret = getAvailableRanges(map, nextRange);
            for (Map.Entry<Integer, Integer> entry : ret.entrySet()) {
                for (int x = entry.getKey(); x <= entry.getValue(); x += 2) {
                    ans[x] = step;
                }
                queue[tail++] = new int[]{entry.getKey(), entry.getValue()};
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != p && ans[i] == 0) {
                ans[i] = -1;
            }
        }

        return ans;
    }

    private Map<Integer, Integer> getAvailableRanges(TreeMap<Integer, Integer> map, int[] range) {
        Map<Integer, Integer> ret = new HashMap<>();
        Map.Entry<Integer, Integer> lower = map.lowerEntry(range[0]);
        Map.Entry<Integer, Integer> floor = map.floorEntry(range[1]);

        if (lower != null && floor != null && lower.getKey() == floor.getKey()) {
            if (lower.getValue() >= range[0]) {
                if (lower.getValue() <= range[1]) {
                    map.put(lower.getKey(), range[0] - 2);
                    ret.put(range[0], lower.getValue());
                } else {
                    map.put(lower.getKey(), range[0] - 2);
                    map.put(range[1] + 2, lower.getValue());
                    ret.put(range[0], range[1]);
                }
            }
            return ret;
        }

        if (lower != null && lower.getValue() >= range[0]) {
            map.put(lower.getKey(), range[0] - 2);
            ret.put(range[0], lower.getValue());
        }

        if (floor != null && floor.getValue() > range[1]) {
            map.remove(floor.getKey());
            map.put(range[1] + 2, floor.getValue());
            ret.put(floor.getKey(), range[1]);
        }

        NavigableMap<Integer, Integer> ms = map.subMap(range[0], true, range[1], true);
        Iterator<Map.Entry<Integer, Integer>> it = ms.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> i = it.next();
            ret.put(i.getKey(), i.getValue());
            it.remove();
        }

        return ret;
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
