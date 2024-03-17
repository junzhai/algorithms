package com.leetcode.algorithms.sumofimbalancenumbersofallsubarrays_2763;

import java.util.Arrays;

public class Simplified extends Solution {

    private int overlap(int range1Start, int range1End, int range2Start, int range2End) {
        int start = Math.max(range1Start, range2Start), end = Math.min(range1End, range2End);
        return start <= end ? end - start + 1 : 0;
    }

    private int calImbalanceNumberChange(int[] nums, int idx, int[] valPos) {
        int change = 0;
        int curVal = nums[idx];
        int firstValidSubArrIdx = 0, lastValidSubArrIdx = idx - 1;

        // check current value
        firstValidSubArrIdx = Math.max(firstValidSubArrIdx, valPos[curVal] + 1);
        if (firstValidSubArrIdx > lastValidSubArrIdx) {
            return change;
        }

        // check current value +/-1
        // curVal - 1, curVal + 1 both exist, imbalance number decrease
        change -= overlap(0, Math.min(valPos[curVal - 1], valPos[curVal + 1]), firstValidSubArrIdx, lastValidSubArrIdx);

        // neither curVal - 1 nor curVal + 1 exists
        firstValidSubArrIdx = Math.max(Math.max(valPos[curVal - 1], valPos[curVal + 1]) + 1, firstValidSubArrIdx);
        if (firstValidSubArrIdx > lastValidSubArrIdx) {
            return change;
        }

        // imbalance number ALWAYS increase by 1 since there is no curVal, curVal - 1, and curVal + 1. No matter whether
        // the curVal is the min, max.
        change += lastValidSubArrIdx - firstValidSubArrIdx + 1;

        return change;
    }

    public int sumImbalanceNumbers(int[] nums) {
        int[] valPos = new int[nums.length + 2];
        Arrays.fill(valPos, -1);
        valPos[nums[0]] = 0;

        int ret = 0;
        for (int i = 1, curImbalanceNumber = 0; i < nums.length; i++) {
            curImbalanceNumber += calImbalanceNumberChange(nums, i, valPos);
            ret += curImbalanceNumber;
            // Value position cache
            valPos[nums[i]] = i;
        }

        return ret;
    }
}