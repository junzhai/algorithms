package com.leetcode.algorithms.nextGreaterElementII_503;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length, l = len;
        int[] ret = new int[len];

        if (len == 0) {
            return ret;
        }

        Integer[] tmp = new Integer[len];
        Comparator<Integer> comp = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return nums[o1] - nums[o2];
            }
        };
        for (int i = 0; i < len; i++) {
            int p = Arrays.binarySearch(tmp, l, len, i, comp);
            if (p >= 0) {
                while (p > l && nums[tmp[p - 1]] == nums[i]) {
                    p -= 1;
                }
            } else {
                p = -p - 1;
            }
            for (int j = l; j < p; j++) {
                ret[tmp[j]] = nums[i];
            }
            tmp[p - 1] = i;
            l = p - 1;
        }

        for (int i = 0; i <= tmp[len - 1]; i++) {
            while (nums[i] > nums[tmp[l]]) {
                ret[tmp[l]] = nums[i];
                l += 1;
            }
        }

        for (int i = l; i < len; i++) {
            ret[tmp[i]] = -1;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ret;

        ret = s.nextGreaterElements(new int[]{1, 2, 3, 4, 5, 6, 5, 4, 5, 1, 2, 3});
        Assert.assertArrayEquals(new int[]{2, 3, 4, 5, 6, -1, 6, 5, 6, 2, 3, 4}, ret);

        ret = s.nextGreaterElements(new int[]{1, 1, 1, 1, 1});
        Assert.assertArrayEquals(new int[]{-1, -1, -1, -1, -1}, ret);

        ret = s.nextGreaterElements(new int[]{});
        Assert.assertArrayEquals(new int[]{}, ret);

        ret = s.nextGreaterElements(new int[]{1, 2, 1});
        Assert.assertArrayEquals(new int[]{2, -1, 2}, ret);
    }
}
