package com.leetcode.com.algorithms.maxXorOfTwoNumbersInAnArray_421;

public class UsingTrieRecursive extends Solution {
    @Override
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        for (int num : nums) {
            Trie p = root;
            for (int i = 31; i >= 0; i--) {
                int index = (1 << i & num) >>> i;
                if (p.children[index] == null) {
                    p.children[index] = new Trie();
                }
                p = p.children[index];
            }
        }

        return inner(root, root, 31);
    }

    public int inner(Trie a, Trie b, int index) {
        if (index < 0) {
            return 0;
        }

        if (a == b) {
            if (a.children[0] != null && a.children[1] != null) {
                return inner(a.children[0], a.children[1], index - 1) + (1 << index);
            } else if (a.children[0] != null) {
                return inner(a.children[0], a.children[0], index - 1);
            } else {
                return inner(a.children[1], a.children[1], index - 1);
            }
        }

        int ret = 0;
        boolean found = false;
        if (a.children[0] != null && b.children[1] != null) {
            ret = Math.max(ret, inner(a.children[0], b.children[1], index - 1));
            found = true;
        }
        if (a.children[1] != null && b.children[0] != null) {
            ret = Math.max(ret, inner(a.children[1], b.children[0], index - 1));
            found = true;
        }

        if (found) {
            return ret + (1 << index);
        }

        if (a.children[0] != null && b.children[0] != null) {
            ret = Math.max(ret, inner(a.children[0], b.children[0], index - 1));
        } else {
            ret = Math.max(ret, inner(a.children[1], b.children[1], index - 1));
        }
        return ret;
    }
}
