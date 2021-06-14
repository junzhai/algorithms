package com.real.sonatus_2021;

public class Pow {
    public double pow(double x, int n) {
        double ret = 1.0, y = x;
        for (int i = 0, m = 1; i < 31; i++, m <<= 1) {
            if ((n & m) != 0) {
                ret *= y;
            }
            y *= y;
        }
        return ret;
    }
}