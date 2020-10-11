package com.leetcode.algorithms.nonOverlappingIntervals_435;

import com.leetcode.algorithms.pattern.DP;

import java.util.Arrays;
import java.util.Comparator;

@DP
public class DPWithoutBinarySearch extends Solution {
    @Override
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Comparator<int[]> comp = new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        };

        Arrays.sort(intervals, comp);

        int len = intervals.length;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] + 1;
            int count = 0, j = i - 1;
            for (; j >= 0; j--) {
                if (intervals[j][1] <= intervals[i][0]) {
                    break;
                }
                count += 1;
            }
            dp[i] = Math.min(dp[i], (j < 0? 0 : dp[j]) + count);
        }
        return dp[len - 1];
    }
}
