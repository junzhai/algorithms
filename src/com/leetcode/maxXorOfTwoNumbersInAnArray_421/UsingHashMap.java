package com.leetcode.maxXorOfTwoNumbersInAnArray_421;

import java.util.HashSet;
import java.util.Set;

public class UsingHashMap extends Solution {
    @Override
    public int findMaximumXOR(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int xor = 0;
        for (int i = 31; i >= 0; i--) {
            s.clear();
            for (int num : nums) {
                s.add(num >>> i);
            }
            int mask = 1 << i;
            for (int num : nums) {
                if (s.contains((num ^ xor + mask) >>> i)) {
                    xor += mask;
                    break;
                }
            }
        }
        return xor;
    }
}
