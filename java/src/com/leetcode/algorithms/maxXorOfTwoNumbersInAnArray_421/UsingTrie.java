package com.leetcode.algorithms.maxXorOfTwoNumbersInAnArray_421;

public class UsingTrie extends Solution {
    @Override
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        for (int num : nums) {
            Trie p = root;
            for (int i = 31; i >= 0; i--) {
                int index = (num & 1 << i) >>> i;
                if (p.children[index] == null) {
                    p.children[index] = new Trie();
                }
                p = p.children[index];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            Trie p = root;
            int xor = 0;
            for (int i = 31; i >= 0; i--) {
                int index = (num & 1 << i) >>> i;
                xor <<= 1;
                if (p.children[index ^ 1] != null) {
                    xor += 1;
                    p = p.children[index ^ 1];
                } else {
                    p = p.children[index];
                }
            }
            max = Math.max(max, xor);
        }

        return max;
    }
}
