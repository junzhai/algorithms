package com.leetcode.algorithms.numberofGreatPartitions;

import com.pattern.algorithms.DP;

import java.util.Arrays;

@DP
public class Solution {
    public int countPartitions(int[] nums, int k) {
        int mode = 1000000007;
        int sum = 0;
        for (int v : nums) {
            sum += v;
            sum %= mode;
        }

        if (sum < (k << 1)) {
            return 0;
        }

        Arrays.sort(nums);
        int[] counter = new int[k];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                break;
            }
            for (int j = k - 1; j >= nums[i]; j--) {
                counter[j] += counter[j - nums[i]] + 1;
                counter[j] %= mode;
            }
        }

        int ret = (int) (Math.pow(2, nums.length) % mode) - ((counter[k - 1] + 1) << 1) % mode;
        return ret < 0 ? ret + mode : ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret = 0;
        int[] aa = new int[]{452712990, 304923574, 514804081, 516542653, 302633600, 387844856, 254193892, 514125672, 231231273, 537828972, 739788846, 997137192, 323638612, 980131474, 932473011, 451725510, 603721810, 314059822, 812497197, 880888575, 270244953, 703545293, 853537357, 744164576, 92185020, 481926703, 917558408, 760008715, 101971293};
        ret = s.countPartitions(aa, 778);


    }
}
