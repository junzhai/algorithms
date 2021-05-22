package com.leetcode.algorithms.validTriangleNumber_611;

import com.pattern.algorithms.BinaryIndexedTree;

import java.util.Arrays;

@BinaryIndexedTree
public class Pivoting extends Solution {
    @Override
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length, ret = 0;
        for (int i = 1; i < len - 1; i++) {
            int k = 0;
            for (int j = i + 1; j < len && k < i; j++) {
                while (k < i && nums[k] + nums[i] <= nums[j]) {
                    ret += j - i - 1;
                    k += 1;
                }
            }
            ret += (i - k) * (len - i - 1);
        }
        return ret;
    }
}
