package com.leetcode.maxXorOfTwoNumbersInAnArray_421;

abstract public class Solution {
    abstract public int findMaximumXOR(int[] nums);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new UsingTrie(),
                new UsingTrieRecursive(),
                new UsingHashMap()
        };

        for (Solution s : solutions) {
            int ret = s.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8});
            System.out.println("done --> 28, " + ret);

            ret = s.findMaximumXOR(new int[]{32, 18, 33, 42, 29, 20, 26, 36, 15, 46});
            System.out.println("done --> 62, " + ret);
        }
    }
}
