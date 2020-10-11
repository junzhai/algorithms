package com.leetcode.algorithms.superUglyNumber_313;

import java.util.Comparator;
import java.util.PriorityQueue;

public class UseHeap extends Solution {
    @Override
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] nums = new int[n], p = new int[len], m = new int[len];
        nums[0] = 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return m[o1] - m[o2];
            }
        });

        for (int i = 0; i < len; i++) {
            m[i] = primes[i];
        }

        for (int i = 0; i < len; i++) {
            pq.offer(i);
        }

        int l = 1;
        while (l < n) {
            int index = pq.poll();
            if (m[index] > nums[l - 1]) {
                nums[l++] = m[index];
            }
            p[index] += 1;
            m[index] = nums[p[index]] * primes[index];
            pq.offer(index);
        }

        return nums[n - 1];
    }
}
