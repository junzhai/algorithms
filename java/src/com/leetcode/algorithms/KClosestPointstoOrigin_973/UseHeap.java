package com.leetcode.algorithms.KClosestPointstoOrigin_973;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class UseHeap extends Solution {
    @Override
    public int[][] kClosest(int[][] points, int K) {
        int[] dist = new int[K];
        int[][] p = new int[K][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>(K, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return dist[o2] - dist[o1];
            }
        });

        int len = 0;
        for (int[] pt : points) {
            int d = pt[0] * pt[0] + pt[1] * pt[1];
            if (len < K) {
                p[len] = pt;
                dist[len] = d;
                pq.offer(len);
                len += 1;
            } else if (d < dist[pq.peek()]) {
                int index = pq.poll();
                p[index] = pt;
                dist[index] = d;
                pq.offer(index);
            }
        }

        return Arrays.copyOfRange(p, 0, len);
    }
}
