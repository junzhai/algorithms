package com.leetcode.algorithms.minimumSizeSubarraySum_209;

import com.leetcode.algorithms.pattern.SlidingWindow;

@SlidingWindow
public class Window extends Solution {
    @Override
    public int minSubArrayLen(int s, int[] nums) {
        int ret = 0;
        for (int i = 0, e = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            while (e < i && sum - s >= nums[e]) {
                sum -= nums[e];
                e += 1;
            }
            if (sum >= s) {
                ret = i - e + 1;
            }
            if (ret > 0) {
                sum -= nums[e];
                e += 1;
            }
        }

        return ret;
    }
}
