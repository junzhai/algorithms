package com.real_interview.sonatus_2021;

public class Division_without_div_multiple {
    // O(log x/y)
    int solution(int x, int y) {
        int[][] ys = new int[100][2];
        int t = y, c = 1, len = 0;
        while (t < x) {
            ys[len][0] = t;
            ys[len++][1] = c;
            t += t;
            c += c;
        }
        int ret = 0;
        for (int i = len - 1; i >= 0; i--) {
            while (ys[i][0] <= x) {
                ret += ys[i][1];
                x -= ys[i][0];
            }
        }
        return ret;
    }
}
