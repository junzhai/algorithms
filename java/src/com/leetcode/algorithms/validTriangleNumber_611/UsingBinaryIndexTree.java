package com.leetcode.algorithms.validTriangleNumber_611;

import com.leetcode.algorithms.pattern.BinaryIndexedTree;

import java.util.Arrays;

@BinaryIndexedTree
public class UsingBinaryIndexTree extends Solution {
    @Override
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length, ret = 0, total = 0;
        int[] bit = new int[2002];
        for (int i = 1; i < len; i++) {
            ret += total - getSum(bit, nums[i] + 1);
            for (int j = 0; j < i; j++) {
                update(bit, nums[j] + nums[i]);
            }
            total += i;
        }
        return ret;
    }

    private int getSum(int[] bit, int i) {
        int ret = 0;
        while (i > 0) {
            ret += bit[i];
            i -= i & -i;
        }
        return ret;
    }

    private void update(int[] bit, int diff) {
        int index = diff + 1;
        while (index < 2002) {
            bit[index] += 1;
            index += index & -index;
        }
    }
}
