package com.leetcode.algorithms.sumofimbalancenumbersofallsubarrays_2763;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

public class OverKilled extends Solution {

    private int overlap(int range1Start, int range1End, int range2Start, int range2End) {
        int start = Math.max(range1Start, range2Start), end = Math.min(range1End, range2End);
        return start <= end ? end - start + 1 : 0;
    }

    private int calImbalanceNumberChange(int[] nums, int idx, int[] valPos, int[][] minValBuf, int minValBufLen, int[][] maxValBuf, int maxValBufLen) {
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

        // imbalance number increase by 1 if curVal is the min value of the sub array
        int idxByMinVal = findSubArrIdxByMinVal(nums, idx, minValBuf, minValBufLen);
        change += overlap(firstValidSubArrIdx, lastValidSubArrIdx, idxByMinVal, lastValidSubArrIdx);
        lastValidSubArrIdx = idxByMinVal - 1;
        if (firstValidSubArrIdx > lastValidSubArrIdx) {
            return change;
        }

        // imbalance number increase by i if curVal is the max value of the sub array
        int idxByMaxVal = findSubArrIdxByMaxVal(nums, idx, maxValBuf, maxValBufLen);
        change += overlap(firstValidSubArrIdx, lastValidSubArrIdx, idxByMaxVal, idx - 1);
        lastValidSubArrIdx = Math.min(lastValidSubArrIdx, idxByMaxVal - 1);
        if (firstValidSubArrIdx > lastValidSubArrIdx) {
            return change;
        }

        // imbalance number increase by 1 if curVal is neither min nor max
        change += lastValidSubArrIdx - firstValidSubArrIdx + 1;

        return change;
    }

    private int findSubArrIdxByMinVal(int[] nums, int idx, int[][] minValBuf, int minValBufLen) {
        int p = Arrays.binarySearch(minValBuf, 0, minValBufLen, new int[]{nums[idx], 0}, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        p = p < 0 ? -(p + 1) : p;
        return p == minValBufLen ? idx : minValBuf[p][1];
    }

    private int findSubArrIdxByMaxVal(int[] nums, int idx, int[][] maxValBuf, int maxValBufLen) {
        int p = Arrays.binarySearch(maxValBuf, 0, maxValBufLen, new int[]{nums[idx], 0}, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        p = p < 0 ? -(p + 1) : p;
        return p == maxValBufLen ? idx : maxValBuf[p][1];
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
        for (int i = 1, curImbalanceNumber = 0; i < nums.length; i++) {
            curImbalanceNumber += calImbalanceNumberChange(nums, i, valPos, minValBuf, minValBufLen, maxValBuf, maxValBufLen);
            ret += curImbalanceNumber;

            // Value position cache
            valPos[nums[i]] = i;

            // Update minValBuf
            int p = Arrays.binarySearch(minValBuf, 0, minValBufLen, new int[]{nums[i], 0}, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            if (p < 0) {
                p = -(p + 1);
                if (p == minValBufLen) {
                    minValBuf[p][0] = nums[i];
                    minValBuf[p][1] = i;
                } else {
                    minValBuf[p][0] = nums[i];
                }
            }
            minValBufLen = p + 1;

            // Update maxValBuf
            p = Arrays.binarySearch(maxValBuf, 0, maxValBufLen, new int[]{nums[i], 0}, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });
            if (p < 0) {
                p = -(p + 1);
                if (p == maxValBufLen) {
                    maxValBuf[p][0] = nums[i];
                    maxValBuf[p][1] = i;
                } else {
                    maxValBuf[p][0] = nums[i];
                }
            }
            maxValBufLen = p + 1;
        }

        return ret;
    }

    public static void main(String[] args) {
        OverKilled solution = new OverKilled();
        int ret;

        ret = solution.sumImbalanceNumbers(new int[]{1, 5, 3, 2, 4});
        Assert.assertEquals(7, ret);

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