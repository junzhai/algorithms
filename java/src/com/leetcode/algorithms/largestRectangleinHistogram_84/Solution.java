package com.leetcode.algorithms.largestRectangleinHistogram_84;

import com.pattern.algorithms.UnSortedArrayHistogram;
import org.junit.Assert;

@UnSortedArrayHistogram
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length, l = 0, ret = 0;
        int[] dp = new int[len], start = new int[len];

        for (int i = 0; i < len; i++) {
            int s = i;
            for (int j = l - 1; j >= 0; j--) {
                if (heights[i] > dp[j]) {
                    dp[j + 1] = heights[i];
                    start[j + 1] = s;
                    l = j + 2;
                    break;
                } else if (heights[i] < dp[j]) {
                    ret = Math.max(ret, dp[j] * (i - start[j]));
                    s = start[j];
                    l -= 1;
                } else {
                    break;
                }
            }
            if (l == 0) {
                dp[0] = heights[i];
                start[0] = 0;
                l += 1;
            }
        }

        for (int i = l - 1; i >= 0; i--) {
            ret = Math.max(ret, dp[i] * (len - start[i]));
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;
        ret = s.largestRectangleArea(new int[]{4, 2, 0, 3, 2, 5});
        Assert.assertEquals(6, ret);

        ret = s.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        Assert.assertEquals(10, ret);

        ret = s.largestRectangleArea(new int[]{1, 2, 2});
        Assert.assertEquals(4, ret);
    }
}
