package com.leetcode.algorithms.lengthofLongestFibonacciSubsequence_873;

import com.pattern.algorithms.DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@DP
public class DP2 extends Solution {
    @Override
    public int lenLongestFibSubseq(int[] A) {
        Set<Integer> s = new HashSet<>();
        int len = A.length, ret = 0;
        for (int a : A) {
            s.add(a);
        }
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        for (int i = 1; i < len - 1; i++) {
            Map<Integer, Integer> ddp = dp.get(A[i]);
            for (int j = 0; j < i; j++) {
                int sum = A[i] + A[j];
                if (s.contains(sum)) {
                    int c = ddp == null || !ddp.containsKey(A[j]) ? 3 : ddp.get(A[j]) + 1;
                    ret = Math.max(ret, c);
                    if (!dp.containsKey(sum)) {
                        dp.put(sum, new HashMap<>());
                    }
                    dp.get(sum).put(A[i], c);
                }
            }
        }

        return ret;
    }
}
