package com.leetcode.algorithms.satisfiabilityofEqualityEquations_990;

import org.junit.Assert;

import java.util.Arrays;

public class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] union = new int[26];
        Arrays.fill(union, -1);
        for (String e : equations) {
            if (e.charAt(1) == '=') {
                int a = e.charAt(0) - 'a', b = e.charAt(3) - 'a';
                if (a != b) {
                    while (union[a] >= 0) {
                        a = union[a];
                    }
                    while (union[b] >= 0) {
                        b = union[b];
                    }
                    if (a < b) {
                        union[b] = a;
                    } else if (a > b) {
                        union[a] = b;
                    }
                }
            }
        }
        for (String e : equations) {
            if (e.charAt(1) == '!') {
                int a = e.charAt(0) - 'a', b = e.charAt(3) - 'a';
                while (union[a] >= 0) {
                    a = union[a];
                }
                while (union[b] >= 0) {
                    b = union[b];
                }
                if (a == b) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean ret;
        ret = s.equationsPossible(new String[]{"f==b", "c==b", "c==b", "e!=f"});
        Assert.assertEquals(true, ret);
    }
}
