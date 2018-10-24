package com.leetcode.carFleet_853;

import java.util.Arrays;
import java.util.Comparator;

public class NonStack extends Solution {
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

        float limit = 0;
        int ret = 0;
        for (int i = 0; i < order.length; i++) {
            int index = order[i];
            float t = (float) (target - position[index]) / speed[index];
            if (t > limit) {
                limit = t;
                ret += 1;
            }
        }
        return ret;
    }
}
