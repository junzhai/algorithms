package com.leetcode.algorithms.FourSum_18;

import com.pattern.algorithms.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DP
/**
 * O(n2)
 */
public class DP2 extends Solution {
    @Override
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();

        if (nums.length < 4) {
            return ret;
        }

        Arrays.sort(nums);

        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        int min = nums[0] + nums[1];
        Map<Integer, List<int[]>> dp = new HashMap<>();
        for (int i = 0, c = 0, total = count.get(nums[0]); i < nums.length - 1; i++) {
            if (c == total - 1) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int s = nums[i] + nums[j];
                    if (min + s > target) {
                        break;
                    }
                    if (dp.containsKey(s)) {
                        for (int[] p : dp.get(s)) {
                            List<Integer> ll = new ArrayList<>();
                            ll.add(p[0]);
                            ll.add(p[1]);
                            ll.add(nums[i]);
                            ll.add(nums[j]);
                            ret.add(ll);
                        }
                    }
                }
            } else if (c == total - 2) {
                int s = nums[i] << 1;
                if (dp.containsKey(s)) {
                    for (int[] p : dp.get(s)) {
                        List<Integer> ll = new ArrayList<>();
                        ll.add(p[0]);
                        ll.add(p[1]);
                        ll.add(nums[i]);
                        ll.add(nums[i]);
                        ret.add(ll);
                    }
                }
            }

            if (i >= nums.length - 2) {
                continue;
            }

            if (c == 0) {
                int max = nums[i + 1] + nums[i + 2];
                for (int j = 0; j < i; j++) {
                    if (j > 0 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int s = nums[i] + nums[j];
                    if (s + max > target) {
                        break;
                    }
                    s = target - s;
                    if (!dp.containsKey(s)) {
                        dp.put(s, new ArrayList<>());
                    }
                    dp.get(s).add(new int[]{nums[j], nums[i]});
                }
            } else if (c == 1) {
                int max = nums[i + 1] + nums[i + 2];
                int s = nums[i] << 1;
                if (s + max <= target) {
                    s = target - s;
                    if (!dp.containsKey(s)) {
                        dp.put(s, new ArrayList<>());
                    }
                    dp.get(s).add(new int[]{nums[i], nums[i]});
                }
            }

            if (nums[i + 1] == nums[i]) {
                c += 1;
            } else {
                c = 0;
                total = count.get(nums[i + 1]);
            }
        }

        return ret;
    }
}
