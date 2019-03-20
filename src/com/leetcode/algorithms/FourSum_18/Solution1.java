package com.leetcode.algorithms.FourSum_18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 extends Solution {
    @Override
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>(), s3 = new HashMap<>(), s2 = new HashMap<>();
        int[] nnums = new int[nums.length];
        int len = 0;
        for (int n : nums) {
            if (s3.containsKey(n) && n != s3.get(n)) {
                int k = s3.get(n);
                List<Integer> l = new ArrayList<>();
                l.add(k);
                l.add(k);
                l.add(k);
                l.add(n);
                ret.add(l);
                s3.remove(n);
            }

            int c = !count.containsKey(n) ? 1 : count.get(n) + 1;
            count.put(n, c);
            if (c == 1) {
                nnums[len++] = n;
            }

            if (c == 2) {
                int k = n << 1;
                if (s2.containsKey(k) && s2.get(k) != n) {
                    int t = s2.get(k);
                    List<Integer> l = new ArrayList<>();
                    l.add(n);
                    l.add(n);
                    l.add(t);
                    l.add(t);
                    ret.add(l);
                }
                s2.put(target - k, n);
            }

            if (c == 3) {
                int expected = target - n * 3;
                if (count.containsKey(expected) && expected != n) {
                    List<Integer> l = new ArrayList<>();
                    l.add(n);
                    l.add(n);
                    l.add(n);
                    l.add(expected);
                    ret.add(l);
                } else {
                    s3.put(expected, n);
                }
            }

            if (c == 4 && n << 2 == target) {
                List<Integer> l = new ArrayList<>();
                l.add(n);
                l.add(n);
                l.add(n);
                l.add(n);
                ret.add(l);
            }
        }

        Map<Integer, List<int[]>> s1 = new HashMap<>();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int s = nnums[i] + nnums[j];
                if (s2.containsKey(s)) {
                    int k = s2.get(s);
                    if (k != nnums[i] && k != nnums[j]) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nnums[i]);
                        l.add(nnums[j]);
                        l.add(k);
                        l.add(k);
                        ret.add(l);
                    }
                }
                if (s1.containsKey(s)) {
                    for (int[] p : s1.get(s)) {
                        if (p[1] < i) {
                            List<Integer> l = new ArrayList<>();
                            l.add(nnums[i]);
                            l.add(nnums[j]);
                            l.add(nnums[p[0]]);
                            l.add(nnums[p[1]]);
                            ret.add(l);
                        }
                    }
                }

                int expected = target - s;
                if (!s1.containsKey(expected)) {
                    s1.put(expected, new ArrayList<>());
                }
                s1.get(expected).add(new int[]{i, j});
            }
        }

        return ret;
    }
}
