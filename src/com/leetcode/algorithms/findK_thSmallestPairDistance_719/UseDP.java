package com.leetcode.algorithms.findK_thSmallestPairDistance_719;

import com.leetcode.algorithms.pattern.DP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Time Limit Exceeded
 */
@DP
public class UseDP extends Solution {
    @Override
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] start = new int[len], dist = new int[len];

        int l = 1, r = len - 1, target = k << 1, begin = -1;
        while (l < r - 1) {
            int m = (r + l) / 2, cur = m * (m + 1);
            if (cur > target) {
                r = m;
            } else if (cur == target) {
                begin = m + 1;
                break;
            } else {
                l = m;
            }
        }

        if (begin == -1) {
            begin = l + 1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(10, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return dist[o2] - dist[o1];
            }
        });

        for (int i = 0; i < begin; i++) {
            dist[i] = nums[i] - nums[0];
            pq.offer(i);
        }

        for (int i = begin, remain = k - ((begin - 1) * begin >>> 1); i < len; i++) {
            start[i] = i - remain;

            l = start[i - 1];
            r = i - remain - 1;
            while (!pq.isEmpty() && l <= r) {
                target = pq.peek();
                int m = (l + r) / 2, md = nums[i] - nums[m];
                if (dist[target] <= md) {
                    l = m + 1;
                } else {
                    r -= 1;
                    start[i] -= 1;
                    int index = pq.poll();
                    start[index] += 1;
                    dist[index] = nums[index] - nums[start[index]];
                    if (start[index] < index) {
                        pq.offer(index);
                    }
                }
            }

            dist[i] = nums[i] - nums[start[i]];
            if (start[i] < i) {
                pq.offer(i);
            }
            remain = 0;
        }

        int index = pq.peek();
        return nums[index] - nums[start[index]];
    }

    public int smallestDistancePair1(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] start = new int[len], dist = new int[len];

        int l = 1, r = len - 1, target = k << 1, begin = -1;
        while (l < r - 1) {
            int m = (r + l) / 2, cur = m * (m + 1);
            if (cur > target) {
                r = m;
            } else if (cur == target) {
                begin = m + 1;
                break;
            } else {
                l = m;
            }
        }

        if (begin == -1) {
            begin = l + 1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(10, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return dist[o2] - dist[o1];
            }
        });

        for (int i = 0; i < begin; i++) {
            dist[i] = nums[i] - nums[0];
            pq.offer(i);
        }

        for (int i = begin, remain = k - ((begin - 1) * begin >>> 1); i < len; i++) {
            start[i] = i - remain;
            for (int j = i - remain - 1; j >= start[i - 1]; j--) {
                if (pq.isEmpty()) {
                    break;
                }

                int d = nums[i] - nums[j];
                int index = pq.peek();
                if (d >= dist[index]) {
                    break;
                }

                start[i] -= 1;
                index = pq.poll();
                start[index] += 1;
                dist[index] = nums[index] - nums[start[index]];
                if (start[index] < index) {
                    pq.offer(index);
                }
            }

            dist[i] = nums[i] - nums[start[i]];
            if (start[i] < i) {
                pq.offer(i);
            }
            remain = 0;
        }

        int index = pq.peek();
        return nums[index] - nums[start[index]];
    }
}
