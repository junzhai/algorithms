package com.leetcode.mergeIntervals_56;


import com.leetcode.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int[] start = new int[intervals.size()], end = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            Interval v = intervals.get(i);
            start[i] = v.start;
            end[i] = v.end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        List<Interval> ret = new ArrayList<>();
        for (int i = 0, b = 0, s = 0; i < end.length; i++) {
            while (b < start.length && start[b] <= end[i]) {
                b += 1;
            }
            if (i + 1 == b) {
                ret.add(new Interval(start[s], end[i]));
                s = b;
            }
        }
        return ret;
    }
}
