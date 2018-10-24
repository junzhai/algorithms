package com.leetcode.com.algorithms.majorityElement_169;

abstract public class Solution {
    abstract public int majorityElement(int[] nums);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new BoyerMooreVotingAlgorithm()
        };

        for (Solution s : solutions) {
            int ret = s.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
            System.out.println("done --> 2, " + ret);
        }
    }
}
