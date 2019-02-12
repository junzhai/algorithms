package com.leetcode.countofSmallerNumbersAfterSelf_315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Heap extends Solution {
    @Override
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if (nums.length == 0) {
            return ret;
        }

        PriorityQueue<Integer> min = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        ret.add(0);
        int len = nums.length, target = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] == target) {
                min.offer(target);
            } else if (nums[i] > target) {
                max.offer(target);
                while (!min.isEmpty() && min.peek() < nums[i]) {
                    max.offer(min.poll());
                }
            } else {
                min.offer(target);
                while (!max.isEmpty() && max.peek() >= nums[i]) {
                    min.offer(max.poll());
                }
            }
            ret.add(0, max.size());
            target = nums[i];
        }
        return ret;
    }
}
