package com.leetcode.algorithms.FourSum_18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@com.pattern.algorithms.DP
/**
 * O(n2)
 */
public class DP extends Solution {
    @Override
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();

        Map<Integer, Integer> count = new HashMap<>();
        int[] nn = new int[nums.length];
        int len = 0;
        for (int n : nums) {
            if (count.containsKey(n)) {
                count.put(n, count.get(n) + 1);
            } else {
                nn[len++] = n;
                count.put(n, 1);
            }
        }

        Map<Integer, List<int[]>> dp = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int c = count.get(nn[i]);
            for (int k = 0; k < c; k++) {
                if (k == c - 1) {
                    for (int j = i + 1; j < len; j++) {
                        int s = nn[i] + nn[j];
                        if (dp.containsKey(s)) {
                            for (int[] p : dp.get(s)) {
                                List<Integer> ll = new ArrayList<>();
                                ll.add(p[0]);
                                ll.add(p[1]);
                                ll.add(nn[i]);
                                ll.add(nn[j]);
                                ret.add(ll);
                            }
                        }
                    }
                } else if (k == c - 2) {
                    int s = nn[i] << 1;
                    if (dp.containsKey(s)) {
                        for (int[] p : dp.get(s)) {
                            List<Integer> ll = new ArrayList<>();
                            ll.add(p[0]);
                            ll.add(p[1]);
                            ll.add(nn[i]);
                            ll.add(nn[i]);
                            ret.add(ll);
                        }
                    }
                }

                if (k == 0) {
                    for (int j = i - 1; j >= 0; j--) {
                        int s = target - nn[i] - nn[j];
                        if (!dp.containsKey(s)) {
                            dp.put(s, new ArrayList<>());
                        }
                        dp.get(s).add(new int[]{nn[j], nn[i]});
                    }
                } else if (k == 1) {
                    int s = target - (nn[i] << 1);
                    if (!dp.containsKey(s)) {
                        dp.put(s, new ArrayList<>());
                    }
                    dp.get(s).add(new int[]{nn[i], nn[i]});
                }
            }
        }

        return ret;
    }
}
