package com.leetcode.algorithms.FourSum_18;

import com.leetcode.algorithms.pattern.Enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * O(n3)
 */
@Enumeration
public class Sum3Sum2 extends Solution {
    @Override
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length < 4) {
            return ret;
        }

        Arrays.sort(nums);
        int len = nums.length, max = nums[len - 1];
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] + max * 3 < target) {
                continue;
            }

            if (nums[i] << 2 > target) {
                continue;
            }

            threeSum(nums, i + 1, len - 1, target - nums[i], nums[i], ret);
        }
        return ret;
    }

    private void threeSum(int[] nums, int b, int e, int target, int first, List<List<Integer>> ret) {
        int max = nums[e] << 1;
        for (int i = b; i <= e - 2; i++) {
            if (i > b && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] + max < target) {
                continue;
            }

            if (nums[i] * 3 > target) {
                continue;
            }

            twoSum(nums, i + 1, e, target - nums[i], first, nums[i], ret);
        }
    }

    private void twoSum(int[] nums, int b, int e, int target, int first, int second, List<List<Integer>> ret) {
        int i = b, j = e;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s > target) {
                j -= 1;
            } else if (s < target) {
                i += 1;
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(first);
                l.add(second);
                l.add(nums[i]);
                l.add(nums[j]);
                ret.add(l);

                int tmp = nums[i];
                while (i < e && nums[i] == tmp) {
                    i += 1;
                }

                tmp = nums[j];
                while (j > b && nums[j] == tmp) {
                    j -= 1;
                }
            }
        }
    }
}
