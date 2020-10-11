package com.google.kickstart.round2019a.training;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int p = in.nextInt();
            int[] s = new int[n];
            for (int j = 0; j < n; j++) {
                s[j] = in.nextInt();
            }
            System.out.println("Case #" + i + ": " + train(n, p, s));
        }
    }

    private static int train(int n, int p, int[] s) {
        Arrays.sort(s);
        int ret = 0;
        for (int i = 0; i < p; i++) {
            ret += s[p - 1] - s[i];
        }

        for (int i = p, t = ret; i < n; i++) {
            t += (s[i] - s[i - 1]) * p;
            t -= s[i] - s[i - p];
            ret = Math.min(ret, t);
        }
        return ret;
    }
}