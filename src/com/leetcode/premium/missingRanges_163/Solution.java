package com.leetcode.premium.missingRanges_163;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges. For
 * example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
 * <p>
 * Example Questions Candidate Might Ask:
 * <p>
 * Q: What if the given array is empty?
 * A: Then you should return [“0->99”] as those ranges are missing.
 * Q: What if the given array contains all elements from the ranges?
 * A: Return an empty list, which means no range is missing.
 */
public class Solution {
    public List<String> findMissingRanges(int[] vals) {
        int p = 0;
        List<String> ret = new ArrayList<>();
        for (int v : vals) {
            if (p != v) {
                if (p == v - 1) {
                    ret.add(p + "");
                } else {
                    ret.add(p + "->" + (v - 1));
                }
            }
            p = v + 1;
        }
        if (p < 99) {
            ret.add(p + "->" + 99);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> ret;
        ret = s.findMissingRanges(new int[]{0, 1, 3, 50, 75});
        ret = s.findMissingRanges(new int[]{});
    }
}
