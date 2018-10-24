package com.leetcode.com.algorithms.carFleet_853;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class UsingStack extends Solution {
    @Override
    public int carFleet(int target, final int[] position, int[] speed) {
        Integer[] order = new Integer[position.length];
        for (int i = 0; i < position.length; i++) {
            order[i] = i;
        }

        Arrays.sort(order, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return position[o2] - position[o1];
            }
        });

        Stack<Float> s = new Stack<>();
        for (int i = 0; i < order.length; i++) {
            int index = order[i];
            float t = (float) (target - position[index]) / speed[index];
            if (s.isEmpty()) {
                s.push(t);
            } else if (t > s.peek()) {
                s.push(t);
            }
        }
        return s.size();
    }
}
