package com.leetcode.algorithms.superUglyNumber_313;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UseArray extends Solution {
    @Override
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] nums = new int[n], p = new int[len], m = new int[len];
        nums[0] = 1;

        for (int i = 0; i < len; i++) {
            m[i] = primes[i];
        }

        int l = 1;
        while (l < n) {
            int min = m[0], index = 0;
            for (int i = 1; i < len; i++) {
                if (min > m[i]) {
                    min = m[i];
                    index = i;
                }
                if (p[i] == p[len - 1]) {
                    break;
                }
            }

            if (m[index] > nums[l - 1]) {
                nums[l++] = m[index];
            }
            p[index] += 1;
            m[index] = nums[p[index]] * primes[index];
        }

        return nums[n - 1];
    }
}
