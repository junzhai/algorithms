package com.leetcode.algorithms.sumofimbalancenumbersofallsubarrays_2763;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private int overlap(int range1Start, int range1End, int range2Start, int range2End) {
        int start = Math.max(range1Start, range2Start), end = Math.min(range1End, range2End);
        return start <= end ? end - start + 1 : 0;
    }

    private int calImbalanceNumberChange(int[] nums, int idx, int[] valPos) {
        int change = 0;
        int curVal = nums[idx];
        int firstValidSubArrIdx = 0;

        // check current value
        firstValidSubArrIdx = Math.max(firstValidSubArrIdx, valPos[curVal] + 1);
        if (firstValidSubArrIdx >= idx) {
            return 0;
        }

        // check current value +/-1

        // curVal - 1, curVal + 1 both exist, imbalance number decrease
        change -= overlap(0, Math.min(valPos[curVal - 1], valPos[curVal + 1]), firstValidSubArrIdx, idx - 1);

        //
        change -= overlap(0, Math.max(valPos[curVal - 1], valPos[curVal + 1]) + 1, firstValidSubArrIdx, idx - 1);


    }

    public int sumImbalanceNumbers(int[] nums) {
        int[][] minValBuf = new int[nums.length][2];
        minValBuf[0][0] = nums[0];
        minValBuf[0][1] = 0;
        int minValBufLen = 1;

        int[][] maxValBuf = new int[nums.length][2];
        maxValBuf[0][0] = nums[0];
        maxValBuf[0][1] = 0;
        int maxValBufLen = 1;

        int[] valPos = new int[nums.length + 2];
        Arrays.fill(valPos, -1);
        valPos[nums[0]] = 0;

        int ret = 0;
        for (int i = 1, curNumber = 0; i < nums.length; i++) {
            // subarry starts from (0, i - 1)
            int firstValidSubArrIdx = 0;

            // check current value nums[i]
            firstValidSubArrIdx = Math.max(firstValidSubArrIdx, valPos[nums[i]] + 1);
            if (firstValidSubArrIdx >= i) {

            }

            int s = Math.max(valPos.getOrDefault(nums[i], -1), valPos.getOrDefault(nums[i] - 1, -1)) + 1;
            int e;
            int p = Arrays.binarySearch(minValBuf, 0, minValBufLen, nums[i] - 2);
            if (p >= 0) {
                if (p == minValBufLen - 1) {
                    e = i - 1;
                } else {
                    e = minValueSubArryPos[p + 1] - 1;
                }
            } else {
                p = -(p + 1);
                if (p == minValBufLen) {
                    e = i - 1;
                } else {
                    e = minValueSubArryPos[p] - 1;
                }
            }
            int l = Math.max(0, s), r = Math.min(e, i - 1);
            if (l <= r) {
                ret += (r - l + 1) * (nums.length - i);
            }

            s = Math.max(valPos.getOrDefault(nums[i], -1), valPos.getOrDefault(nums[i] + 1, -1)) + 1;
            p = Arrays.binarySearch(maxValBuf, 0, maxValBufLen, nums[i] + 2, new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
            });
            if (p >= 0) {
                if (p == maxValBufLen - 1) {
                    e = i - 1;
                } else {
                    e = maxPos[p + 1] - 1;
                }
            } else {
                p = -(p + 1);
                if (p == maxValBufLen) {
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

            valPos.put(nums[i], i);

            p = Arrays.binarySearch(minValBuf, 0, minValBufLen, nums[i]);
            if (p >= 0) {
                minValBufLen = p + 1;
            } else {
                p = -(p + 1);
                if (p == minValBufLen) {
                    minValBuf[p] = nums[i];
                    minValueSubArryPos[p] = i;
                } else {
                    minValBuf[p] = nums[i];
                }
                minValBufLen = p + 1;
            }

            p = Arrays.binarySearch(maxValBuf, 0, maxValBufLen, nums[i], new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
            });
            if (p >= 0) {
                maxValBufLen = p + 1;
            } else {
                p = -(p + 1);
                if (p == maxValBufLen) {
                    maxValBuf[p] = nums[i];
                    maxPos[p] = i;
                } else {
                    maxValBuf[p] = nums[i];
                }
                maxValBufLen = p + 1;
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