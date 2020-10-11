package com.leetcode.algorithms.majorityElement_169;

public class BoyerMooreVotingAlgorithm extends Solution {
    @Override
    public int majorityElement(int[] nums) {
        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }
}
