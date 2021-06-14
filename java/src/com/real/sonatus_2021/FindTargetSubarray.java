package com.real.sonatus_2021;

import java.util.HashMap;
import java.util.Map;

public class FindTargetSubarray {
    public boolean solution(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, -1);

        for (int i = 0, s = 0; i < nums.length; i++) {
            s += nums[i];
            if (cache.containsKey(s - target)) {
                if (i - cache.get(s - target) > 1) {
                    return true;
                }
            }
            cache.put(s, i);
        }

        return false;
    }

    public static void main(String[] args) {
        FindTargetSubarray s = new FindTargetSubarray();
        System.out.println(s.solution(new int[]{6, 0, 0, 0}, 6));
        System.out.println(s.solution(new int[]{23, 2, 4, 6, 7}, 6));
    }
}
