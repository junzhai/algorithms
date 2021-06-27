package com.real_interview.forward_network_2021;

/**
 * All numbers are positive
 */
public class FindMinMissingNumber {
    public int solution1(int[] nums) {
        int len = nums.length;
        boolean[] found = new boolean[len];
        for (int v : nums) {
            found[v] = true;
        }

        for (int i = 1; i < len; i++) {
            if (!found[i]) {
                return i;
            }
        }
        return len;
    }

    public int solution2(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == i) {
                continue;
            }
            int v = nums[i];
            nums[i] = 0;
            while (v < len && v != nums[v] && nums[v] != 0) {
                int tmp = nums[v];
                nums[v] = v;
                v = tmp;
            }
            if (v < len) {
                nums[v] = v;
            }
        }

        for (int i = 1; i < len; i++) {
            if (nums[i] == 0) {
                return i;
            }
        }
        return len;
    }

    public int solution3(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int v = Math.abs(nums[i]);
            if (v < len) {
                nums[v] = -Math.abs(nums[v]);
            }
        }

        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        return len;
    }
}
