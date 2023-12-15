package com.leetcode.algorithms.minimumReverseOperations_2612;

import com.pattern.algorithms.BFS;
import com.pattern.algorithms.JavaTreeMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@BFS
public class TreeMapInterval extends Solution {

    @JavaTreeMap
    @Override
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        int[] ans = new int[n];
        for (int i : banned) {
            ans[i] = -1;
        }
        ans[p] = 0;

        TreeMap<Integer, Integer> oddIntervals = new TreeMap<>(), evenIntervals = new TreeMap<>();
        int s = -1;
        for (int i = 0; i < n; i++) {
            if (i == p || ans[i] == -1) {
                if (s >= 0) {
                    insertInterval(oddIntervals, evenIntervals, s, i - 1);
                    s = -1;
                }
            } else if (s < 0) {
                s = i;
            }
        }

        if (s >= 0) {
            insertInterval(oddIntervals, evenIntervals, s, n - 1);
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

            TreeMap<Integer, Integer> intervals = max % 2 == 0 ? evenIntervals : oddIntervals;
            Integer lowerKey = intervals.lowerKey(min);
            Iterator<Map.Entry<Integer, Integer>> it = intervals.subMap(lowerKey == null ? min : lowerKey, max + 2).entrySet().iterator();
            Map<Integer, Integer> tmp = new HashMap<>();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> interval = it.next();
                int ss = interval.getKey(), ee = interval.getValue();

                if (ss < min) {
                    if (ee >= min) {
                        for (int i = min; i <= Math.min(max, ee); i += 2) {
                            ans[i] = step;
                            q[end++] = i;
                        }
                        interval.setValue(min - 2);
                    }
                    if (ee > max) {
                        tmp.put(max + 2, ee);
                    }
                } else {
                    for (int i = ss; i <= Math.min(max, ee); i += 2) {
                        ans[i] = step;
                        q[end++] = i;
                    }
                    it.remove();
                    if (ee > max) {
                        tmp.put(max + 2, ee);
                    }
                }
            }
            intervals.putAll(tmp);
        }

        for (int i = 0; i < n; i++) {
            if (i != p && ans[i] == 0) {
                ans[i] = -1;
            }
        }

        return ans;
    }

    private void insertInterval(TreeMap<Integer, Integer> odd, TreeMap<Integer, Integer> even, int s, int e) {
        if (s % 2 == 0 && e % 2 == 0) {
            even.put(s, e);
            if (s != e) {
                odd.put(s + 1, e - 1);
            }
        } else if (s % 2 == 0 && e % 2 == 1) {
            even.put(s, e - 1);
            odd.put(s + 1, e);
        } else if (s % 2 == 1 && e % 2 == 0) {
            odd.put(s, e - 1);
            even.put(s + 1, e);
        } else {
            odd.put(s, e);
            if (s != e) {
                even.put(s + 1, e - 1);
            }
        }
    }
}
