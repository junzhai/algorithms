package com.leetcode.algorithms.countofSmallerNumbersAfterSelf_315;

import com.pattern.UnSortedArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@UnSortedArray
public class BinarySearch extends Solution {
    @Override
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if (nums.length == 0) {
            return ret;
        }
        ret.add(0);
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            int b = i + 1, target = nums[i];
            int p = Arrays.binarySearch(nums, b, len, target);
            p = p >= 0 ? p : -p - 1;
            ret.add(0, p - b);
            System.arraycopy(nums, b, nums, i, p - b);
            nums[p - 1] = target;
        }
        return ret;
    }
}
