package com.leetcode.algorithms.perfectRectangle_391;

import com.pattern.algorithms.Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

@Heap
class UsingHeap {
    public boolean isRectangleCover(int[][] rectangles) {
        int X = Integer.MAX_VALUE, Y = Integer.MAX_VALUE, A = Integer.MIN_VALUE, B = Integer.MIN_VALUE;
        for (int[] rec : rectangles) {
            X = Math.min(X, rec[0]);
            Y = Math.min(Y, rec[1]);
            A = Math.max(A, rec[2]);
            B = Math.max(B, rec[3]);
        }

        Arrays.sort(rectangles, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int ret = a[0] - b[0];
                if (ret == 0) {
                    return a[1] - b[1];
                }
                return ret;
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });

        pq.offer(new int[]{X, Y, B - Y});
        int idx = 0;
        while (!pq.isEmpty()) {
            if (idx >= rectangles.length) {
                return false;
            }
            int[] r = pq.poll();
            int[] nr = pq.isEmpty() ? null : pq.peek();
            while (nr != null && r[0] == nr[0] && r[1] + r[2] == nr[1]) {
                r[2] += nr[2];
                pq.poll();
                nr = pq.isEmpty() ? null : pq.peek();
            }
            if (r[0] != rectangles[idx][0] || r[1] != rectangles[idx][1]) {
                return false;
            }
            if (r[2] == rectangles[idx][3] - rectangles[idx][1]) {
                if (rectangles[idx][2] < A) {
                    pq.offer(new int[]{rectangles[idx][2], r[1], r[2]});
                }
            } else if (r[2] > rectangles[idx][3] - rectangles[idx][1]) {
                if (rectangles[idx][2] < A) {
                    pq.offer(new int[]{rectangles[idx][2], r[1], rectangles[idx][3] - rectangles[idx][1]});
                }
                pq.offer(new int[]{r[0], rectangles[idx][3], r[2] - rectangles[idx][3] + rectangles[idx][1]});
            } else {
                return false;
            }
            idx += 1;
        }

        return idx == rectangles.length;
    }

    public static void main(String[] args) {
        UsingHeap s = new UsingHeap();

        boolean ret;
        ret = s.isRectangleCover(new int[][]{
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {3, 2, 4, 4},
                {1, 3, 2, 4},
                {2, 3, 3, 4}});
        int i = 0;
    }
}