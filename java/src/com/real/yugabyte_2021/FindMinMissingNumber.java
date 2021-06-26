package com.real.yugabyte_2021;

import java.util.Arrays;

/**
 * Number could be negative
 */
public class FindMinMissingNumber {
    public static void main(String[] args) {
        FindMinMissingNumber s = new FindMinMissingNumber();
        int[] arr = new int[]{2, -22, 0, 123, -2, 5, 1, 4};
        System.out.println(s.solution_1(arr));
        System.out.println(s.solution_3(arr));
        Arrays.sort(arr);
        System.out.println(s.solution_2(arr));
    }

    // arr not sorted
    public int solution_1(int[] arr) {
        boolean[] exist = new boolean[arr.length];
        for (int v : arr) {
            if (v >= 0 && v < arr.length) {
                exist[v] = true;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (!exist[i]) {
                return i;
            }
        }
        return arr.length;
    }

    // arr is sorted
    public int solution_2(int[] arr) {
        int target = 0;
        for (int v : arr) {
            if (v == target) {
                target += 1;
            } else if (v > target) {
                return target;
            }
        }
        return target;
    }

    // arr is not sorted
    public int solution_3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int idx = i, fill = -1;
            while (idx >= 0 && idx < arr.length && arr[idx] != idx) {
                int tmp = arr[idx];
                arr[idx] = fill;
                idx = tmp;
                fill = tmp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return i;
            }
        }

        return arr.length;
    }
}
