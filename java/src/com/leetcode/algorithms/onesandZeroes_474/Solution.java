package com.leetcode.algorithms.onesandZeroes_474;

import com.leetcode.algorithms.pattern.BackTracking;

import java.util.Arrays;
import java.util.Comparator;

@BackTracking
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] cost = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            String t = strs[i];
            int l = t.length(), z = 0;
            for (int j = 0; j < l; j++) {
                if (t.charAt(j) == '0') {
                    z += 1;
                }
            }
            cost[i][0] = z;
            cost[i][1] = l - z;
        }
        Arrays.sort(cost, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                int r = o1[0] - o2[0];
                if (r == 0) {
                    r = o1[1] - o2[1];
                }
                return r;
            }
        });
        return helper(cost, 0, 0, m, n);
    }

    private int helper(int[][] cost, int index, int count, int m, int n) {
        int len = cost.length, ret = count, upper1 = n + 1;
        for (int i = index; i < len - ret + count; i++) {
            if (cost[i][0] > m) {
                break;
            }
            if (cost[i][1] >= upper1) {
                continue;
            }
            ret = Math.max(ret, helper(cost, i + 1, count + 1, m - cost[i][0], n - cost[i][1]));
            upper1 = cost[i][1];
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;
        ret = s.findMaxForm(
                new String[]{"1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0"
                        , "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0",
                        "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1"
                        , "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1",
                        "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0"
                        , "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0",
                        "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0", "1", "0"},
                30,
                30);
    }
}
