package com.leetcode.algorithms.trappingRainWater_42;

import com.leetcode.algorithms.pattern.UnSortedArray;
import org.junit.Assert;

import java.util.Arrays;

@UnSortedArray
public class Solution {
    public int trap(int[] height) {
        int len = height.length, l = 0, ret = 0;
        int[] h = new int[len], index = new int[len], sum = new int[len], water = new int[len];
        for (int i = 0, s = 0; i < len; i++) {
            s += height[i];
            int p = Arrays.binarySearch(h, len - l, len, height[i]);
            if (p >= 0) {
                while (p - 1 >= len - l && h[p - 1] == h[p]) {
                    p -= 1;
                }
                l = len - p;
            } else {
                p = -p - 1;
            }
            if (p < len) {
                water[p - 1] = (i - index[p]) * height[i] - (s - sum[p]);
            } else {
                ret += water[len - 1];
                water[p - 1] = (i - index[len - 1]) * h[len - 1] - (s - sum[len - 1] - height[i] + h[len - 1]);
            }
            index[p - 1] = i;
            sum[p - 1] = s;
            h[p - 1] = height[i];
            l = len - p + 1;
        }

        for (int i = 0; i < l; i++) {
            ret += water[len - i - 1];
        }

        return ret;
    }

    public static void main(String[] a) {
        Solution s = new Solution();
        int ret;

        ret = s.trap(new int[]{0, 5, 6, 4, 6, 1, 0, 0, 2, 7});
        Assert.assertEquals(23, ret);

        ret = s.trap(new int[]{9, 6, 8, 8, 5, 6, 3});
        Assert.assertEquals(3, ret);

        ret = s.trap(new int[]{4, 2, 0, 3, 2, 4, 3, 4});
        Assert.assertEquals(10, ret);

        ret = s.trap(new int[]{});
        Assert.assertEquals(0, ret);

        ret = s.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        Assert.assertEquals(6, ret);
    }
}
