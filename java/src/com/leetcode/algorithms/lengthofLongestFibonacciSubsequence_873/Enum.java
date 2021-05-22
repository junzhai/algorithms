package com.leetcode.algorithms.lengthofLongestFibonacciSubsequence_873;

import com.pattern.algorithms.Enumeration;

import java.util.HashSet;
import java.util.Set;

@Enumeration
public class Enum extends Solution {
    @Override
    public int lenLongestFibSubseq(int[] A) {
        Set<Integer> s = new HashSet<>();
        int len = A.length, ret = 0, lim = len - 1;
        for (int a : A) {
            s.add(a);
        }

        for (int i = 1; i < lim; i++) {
            for (int j = 0; j < i; j++) {
                int a = A[j], b = A[i], diff = b - a;
                if (diff < a && s.contains(diff)) {
                    continue;
                }
                int sum = a + b, c = 0;
                while (s.contains(sum)) {
                    a = b;
                    b = sum;
                    sum = a + b;
                    c += 1;
                }
                if (c > 0) {
                    c += 2;
                    ret = Math.max(ret, c);
                    lim = len - ret + 2;
                }
            }
        }

        return ret;
    }
}
