package com.real_interview.roblox_2021;

/**
 * What to do if the list of data is huge in file.
 */
public class FindLocalPeak {
    public static void main(String[] args) {
        FindLocalPeak s = new FindLocalPeak();
        s.solution_1(new int[]{2, 3, 7, 1, 3, 2, 1, 4, 9});
        s.solution_1(new int[]{9, 2, 3, 7, 1, 3, 2, 1, 4, 9});
        s.solution_2(new int[]{9, 2, 3, 7, 7, 1, 3, 3, 3, 3, 2, 1, 1, 4, 9, 9, 10, 21, 21, 3});
    }

    // Distinct values
    public void solution_1(int[] arr) {
        boolean up = false;
        for (int i = 1; i < arr.length; i++) {
            if (up) {
                if (arr[i] < arr[i - 1]) {
                    System.out.println((i - 1) + ", " + arr[i - 1]);
                    up = false;
                }
            } else {
                if (arr[i] > arr[i - 1]) {
                    up = true;
                }
            }
        }
    }

    // Consider duplicated values
    public void solution_2(int[] arr) {
        boolean up = false;
        for (int i = 1, s = 0; i < arr.length; i++) {
            if (up) {
                if (arr[i] < arr[i - 1]) {
                    System.out.println("(" + s + ": " + (i - 1) + "), " + arr[i - 1]);
                    up = false;
                } else if (arr[i] > arr[i - 1]) {
                    s = i;
                }
            } else {
                if (arr[i] > arr[i - 1]) {
                    up = true;
                    s = i;
                }
            }
        }
    }
}
