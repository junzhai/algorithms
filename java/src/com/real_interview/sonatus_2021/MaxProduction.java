package com.real_interview.sonatus_2021;

import java.util.Arrays;

public class MaxProduction {
    public int solution1(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[len - 1] * nums[len - 2], nums[0] * nums[1]);
    }

    public int solution2(int[] nums) {
        int max = nums[0], min = max, ret = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                ret = Math.max(ret, nums[i] * max);
            } else {
                ret = Math.max(ret, nums[i] * min);
            }
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return ret;
    }


















    public static void main(String[] args) {
        MaxProduction s = new MaxProduction();
        int[] arg = new int[]{549, 8674, 5724, 8285, 4021, 1368, -958, -402, 9705};
        System.out.println(s.solution1(arg));
        System.out.println(s.solution2(arg));
    }
}
