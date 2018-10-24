package com.leetcode.com.leetcode.Sliding_Window_Median;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ret = new double[nums.length - k + 1];

        if (k == 1) {
            for (int i = 0; i < nums.length; i++) {
                ret[i] = nums[i] * 1.0;
            }

            return ret;
        }

        Map<Integer, Integer> minHeapFilter = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        Map<Integer, Integer> maxHeapFilter = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, Collections.<Integer>reverseOrder());

        double median = 0;
        for (int i = 0; i < k; i++) {
            int val = nums[i];
            if (i % 2 == 0) {
                if (minHeap.size() > 0 && val > minHeap.peek()) {
                    median = minHeap.poll();
                    minHeap.offer(val);
                } else if (maxHeap.size() > 0 && val < maxHeap.peek()) {
                    median = maxHeap.poll();
                    maxHeap.offer(val);
                } else {
                    median = val;
                }
            } else {
                if (val > median) {
                    minHeap.offer(val);
                    maxHeap.offer((int) median);
                } else {
                    minHeap.offer((int) median);
                    maxHeap.offer(val);
                }
                median = (minHeap.peek() * 1.0 + maxHeap.peek()) / 2.0;
            }
        }

        ret[0] = median;

        for (int i = k, index = 1; i < nums.length; i++) {
            int out = nums[i - k];
            int in = nums[i];

            if (out == in) {
                ret[index++] = median;
                continue;
            }

            if (k % 2 == 0) {
                if (out <= median) {
                    record(maxHeapFilter, out);
                    if (in <= minHeap.peek()) {
                        maxHeap.offer(in);
                    } else {
                        maxHeap.offer(minHeap.poll());
                        minHeap.offer(in);
                    }
                } else {
                    record(minHeapFilter, out);
                    if (in >= maxHeap.peek()) {
                        minHeap.offer(in);
                    } else {
                        minHeap.offer(maxHeap.poll());
                        maxHeap.offer(in);
                    }
                }
                clearHeapTop(maxHeap, maxHeapFilter);
                clearHeapTop(minHeap, minHeapFilter);
                median = (minHeap.peek() * 1.0 + maxHeap.peek()) / 2.0;
            } else {
                if (out == median) {
                    if (in > minHeap.peek()) {
                        median = minHeap.poll();
                        minHeap.offer(in);
                    } else if (in < maxHeap.peek()) {
                        median = maxHeap.poll();
                        maxHeap.offer(in);
                    } else {
                        median = in;
                    }
                } else if (out < median) {
                    record(maxHeapFilter, out);
                    if (in <= median) {
                        maxHeap.offer(in);
                    } else if (in <= minHeap.peek()) {
                        maxHeap.offer((int) median);
                        median = in;
                    } else {
                        maxHeap.offer((int) median);
                        median = minHeap.poll();
                        minHeap.offer(in);
                    }
                } else {
                    record(minHeapFilter, out);
                    if (in >= median) {
                        minHeap.offer(in);
                    } else if (in >= maxHeap.peek()) {
                        minHeap.offer((int) median);
                        median = in;
                    } else {
                        minHeap.offer((int) median);
                        median = maxHeap.poll();
                        maxHeap.offer(in);
                    }
                }
                clearHeapTop(maxHeap, maxHeapFilter);
                clearHeapTop(minHeap, minHeapFilter);
            }

            ret[index++] = median;
        }

        return ret;
    }

    private void record(Map<Integer, Integer> filter, int key) {
        if (filter.containsKey(key)) {
            filter.put(key, filter.get(key) + 1);
        } else {
            filter.put(key, 1);
        }
    }

    private void clearHeapTop(PriorityQueue<Integer> heap, Map<Integer, Integer> filter) {
        while (filter.containsKey(heap.peek())) {
            int key = heap.poll();
            if (filter.get(key) == 1) {
                filter.remove(key);
            } else {
                filter.put(key, filter.get(key) - 1);
            }
        }
    }
}