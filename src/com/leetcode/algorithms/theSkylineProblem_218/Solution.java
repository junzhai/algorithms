package com.leetcode.algorithms.theSkylineProblem_218;

import com.leetcode.algorithms.pattern.UnSortedArray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@UnSortedArray
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        int len = buildings.length;
        boolean[] inheap = new boolean[len];
        PriorityQueue<Integer> h = new PriorityQueue<>(10, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return buildings[o2][2] - buildings[o1][2];
            }
        });
        PriorityQueue<Integer> e = new PriorityQueue<>(10, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return buildings[o1][1] - buildings[o2][1];
            }
        });

        List<int[]> ret = new ArrayList<>();
        for (int i = 0, x = -1; i < len; i++) {
            while (!e.isEmpty()) {
                if (buildings[e.peek()][1] >= buildings[i][0]) {
                    break;
                }
                int index = e.poll();
                inheap[index] = false;
                if (index == h.peek()) {
                    while (!h.isEmpty() && !inheap[h.peek()]) {
                        h.poll();
                    }
                    int maxh = h.isEmpty() ? 0 : buildings[h.peek()][2];
                    if (buildings[index][2] > maxh) {
                        ret.add(new int[]{buildings[index][1], maxh});
                    }
                }
            }

            int maxh = h.isEmpty() ? 0 : buildings[h.peek()][2];
            if (buildings[i][2] > maxh) {
                if (buildings[i][0] > x) {
                    ret.add(new int[]{buildings[i][0], buildings[i][2]});
                    x = buildings[i][0];
                } else {
                    int[] pre = ret.get(ret.size() - 1);
                    pre[1] = buildings[i][2];
                }
            }
            h.offer(i);
            e.offer(i);
            inheap[i] = true;
        }

        int x = -1;
        while (!e.isEmpty()) {
            int index = e.poll();
            inheap[index] = false;
            if (index == h.peek()) {
                while (!h.isEmpty() && !inheap[h.peek()]) {
                    h.poll();
                }
                int maxh = h.isEmpty() ? 0 : buildings[h.peek()][2];
                if (buildings[index][2] > maxh) {
                    if (buildings[index][1] > x) {
                        ret.add(new int[]{buildings[index][1], maxh});
                        x = buildings[index][1];
                    } else {
                        int[] pre = ret.get(ret.size() - 1);
                        pre[1] = maxh;
                    }
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<int[]> ret;

        // [[0,3],[5,0]]
        ret = s.getSkyline(new int[][]{{0, 2, 3}, {2, 5, 3}});

        // [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
        ret = s.getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}});

        // [[1,3],[2,0]]
        ret = s.getSkyline(new int[][]{{1, 2, 1}, {1, 2, 2}, {1, 2, 3}});
    }
}
