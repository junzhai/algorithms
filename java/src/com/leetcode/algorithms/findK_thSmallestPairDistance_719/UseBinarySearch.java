package com.leetcode.algorithms.findK_thSmallestPairDistance_719;

import com.leetcode.algorithms.pattern.BinarySearch;

import java.util.Arrays;

@BinarySearch
public class UseBinarySearch extends Solution {
    @Override
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length, l = -1, r = nums[len - 1] - nums[0];
        while (l + 1 < r) {
            int m = (l + r) / 2;
            int[] ret = count(nums, m, k);
            if (ret[0] < k) {
                l = m;
            } else if (ret[0] > k) {
                r = m;
            } else {
                return ret[1];
            }
        }
        return r;
    }

    private int[] count(int[] nums, int target, int k) {
        int len = nums.length;
        int[] ret = new int[2];
        for (int i = 0, b = 1; i < len - 1 && ret[0] <= k; i++) {
            if (b >= len) {
                ret[0] += (len - i - 1) * (len - i) >>> 1;
                break;
            }
            int nt = target + nums[i];
            b = Arrays.binarySearch(nums, b, len, target + nums[i]);
            if (b >= 0) {
                while (b < len && nums[b] == nt) {
                    b += 1;
                }
                ret[1] = target;
            } else {
                b = -b - 1;
                ret[1] = Math.max(ret[1], b > 0 ? nums[b - 1] - nums[i] : -1);
            }
            ret[0] += b - i - 1;
        }
        return ret;
    }
}
