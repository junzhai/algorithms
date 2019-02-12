package com.leetcode.countofSmallerNumbersAfterSelf_315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCount extends Solution {
    @Override
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return Collections.emptyList();
        }

        Integer[] order = new Integer[len];
        for (int i = 0; i < len; i++) {
            order[i] = i;
        }
        Arrays.sort(order, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o1] - nums[o2];
            }
        });

        boolean[] done = new boolean[len];
        int[] count = new int[len];
        for (int i : order) {
            done[i] = true;
            for (int j = 0; j < i; j++) {
                if (!done[j]) {
                    count[j] += 1;
                }
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int i : count) {
            ret.add(i);
        }
        return ret;
    }
}
