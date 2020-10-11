package com.leetcode.algorithms.nonOverlappingIntervals_435;

import com.leetcode.algorithms.pattern.DP;

import java.util.Arrays;
import java.util.Comparator;

@DP
public class DPWithBinarySearch extends Solution {
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
            int p = Arrays.binarySearch(intervals, 0, i, new int[]{intervals[i][0], intervals[i][0]}, comp);
            if (p >= 0) {
                while (p < i && intervals[p][1] == intervals[i][0]) {
                    p += 1;
                }
            } else {
                p = -p - 1;
            }
            dp[i] = Math.min(dp[i], (p > 0 ? dp[p - 1] : 0) + i - p);
        }
        return dp[len - 1];
    }
}
