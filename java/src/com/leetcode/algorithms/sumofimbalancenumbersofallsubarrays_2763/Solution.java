package com.leetcode.algorithms.sumofimbalancenumbersofallsubarrays_2763;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int sumImbalanceNumbers(int[] nums) {
        int[] min = new int[nums.length];
        int[] minPos = new int[nums.length];
        min[0] = nums[0];
        minPos[0] = 0;

        Integer[] max = new Integer[nums.length];
        int[] maxPos = new int[nums.length];
        max[0] = nums[0];
        maxPos[0] = 0;

        int minL = 1, maxL = 1;

        Map<Integer, Integer> pos = new HashMap<>();
        pos.put(nums[0], 0);

        int ret = 0;
        for (int i = 1; i < nums.length; i++) {
            int s = Math.max(pos.getOrDefault(nums[i], -1), pos.getOrDefault(nums[i] - 1, -1)) + 1;
            int e;
            int p = Arrays.binarySearch(min, 0, minL, nums[i] - 2);
            if (p >= 0) {
                if (p == minL - 1) {
                    e = i - 1;
                } else {
                    e = minPos[p + 1] - 1;
                }
            } else {
                p = -(p + 1);
                if (p == minL) {
                    e = i - 1;
                } else {
                    e = minPos[p] - 1;
                }
            }
            int l = Math.max(0, s), r = Math.min(e, i - 1);
            if (l <= r) {
                ret += (r - l + 1) * (nums.length - i);
            }

            s = Math.max(pos.getOrDefault(nums[i], -1), pos.getOrDefault(nums[i] + 1, -1)) + 1;
            p = Arrays.binarySearch(max, 0, maxL, nums[i] + 2, new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
            });
            if (p >= 0) {
                if (p == maxL - 1) {
                    e = i - 1;
                } else {
                    e = maxPos[p + 1] - 1;
                }
            } else {
                p = -(p + 1);
                if (p == maxL) {
                    e = i - 1;
                } else {
                    e = maxPos[p] - 1;
                }
            }
            l = Math.max(0, s);
            r = Math.min(e, i - 1);
            if (l <= r) {
                ret += (r - l + 1) * (nums.length - i);
            }

            pos.put(nums[i], i);

            p = Arrays.binarySearch(min, 0, minL, nums[i]);
            if (p >= 0) {
                minL = p + 1;
            } else {
                p = -(p + 1);
                if (p == minL) {
                    min[p] = nums[i];
                    minPos[p] = i;
                } else {
                    min[p] = nums[i];
                }
                minL = p + 1;
            }

            p = Arrays.binarySearch(max, 0, maxL, nums[i], new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
            });
            if (p >= 0) {
                maxL = p + 1;
            } else {
                p = -(p + 1);
                if (p == maxL) {
                    max[p] = nums[i];
                    maxPos[p] = i;
                } else {
                    max[p] = nums[i];
                }
                maxL = p + 1;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ret;

        ret = solution.sumImbalanceNumbers(new int[]{2, 3, 1, 4});
        Assert.assertEquals(3, ret);

        ret = solution.sumImbalanceNumbers(new int[]{1, 3, 3, 3, 5});
        Assert.assertEquals(8, ret);

        ret = solution.sumImbalanceNumbers(new int[]{1, 3, 1});
        Assert.assertEquals(3, ret);

        ret = solution.sumImbalanceNumbers(new int[]{1, 3, 2});
        Assert.assertEquals(1, ret);
    }
}