package com.leetcode.algorithms.minimumNumberOfRefuelingStops_871;

import com.leetcode.algorithms.pattern.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

@Heap
public class Scan extends Solution {
    @Override
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (target <= startFuel) {
            return 0;
        }

        int len = stations.length, ret = 0, gas = startFuel;
        PriorityQueue<Integer> pq = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < len; i++) {
            while (gas < stations[i][0]) {
                if (pq.isEmpty()) {
                    return -1;
                }
                gas += pq.poll();
                ret += 1;
            }
            pq.offer(stations[i][1]);
        }

        while (gas < target) {
            if (pq.isEmpty()) {
                return -1;
            }
            gas += pq.poll();
            ret += 1;
        }

        return ret;
    }
}
