package com.leetcode;

import org.junit.Assert;

import java.util.Arrays;

public class Sandbox {
    public int countDigitOne(int n) {
        int d = 1;
        while (n / d >= 10) {
            d *= 10;
        }

        int ret = 0, m = n;
        while (d > 0) {
            int v = n / 10 / d;
            ret += v * d;
            int dig = m / d;
            if (dig > 1) {
                ret += d;
            } else if (dig == 1) {
                ret += m % d + 1;
            }
            m %= d;
            d /= 10;
        }

        return ret;
    }

    public static void main(String[] args) {
        Sandbox s = new Sandbox();
        int ret;

        ret = s.countDigitOne(100);
        Assert.assertEquals(21, ret);

        ret = s.countDigitOne(1410065408);
        Assert.assertEquals(1737167499, ret);

        ret = s.countDigitOne(9);
        Assert.assertEquals(1, ret);

        ret = s.countDigitOne(13);
        Assert.assertEquals(6, ret);
    }
}