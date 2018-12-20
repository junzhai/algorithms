package com.leetcode.superPalindromes_906;

import org.junit.Assert;

import java.math.BigInteger;

public class BruteForce extends Solution {
    @Override
    public int superpalindromesInRange(String L, String R) {
        BigInteger l = new BigInteger(L), r = new BigInteger(R);
        char[] v = new char[8];
        int ret = 0;
        for (int i1 = 0; i1 < 10; i1++) {
            v[0] = (char) ('0' + i1);
            v[7] = v[0];
            for (int i2 = 0; i2 < 10; i2++) {
                v[1] = (char) ('0' + i2);
                v[6] = v[1];
                for (int i3 = 0; i3 < 10; i3++) {
                    v[2] = (char) ('0' + i3);
                    v[5] = v[2];
                    for (int i4 = 0; i4 < 10; i4++) {
                        v[3] = (char) ('0' + i4);
                        v[4] = v[3];
                        String vv = trim0(String.valueOf(v));
                        if (check(vv, l, r)) {
                            ret += 1;
                        }
                    }
                }
            }
        }

        System.out.println("----------------------");

        v = new char[9];
        for (int i1 = 0; i1 < 10; i1++) {
            v[0] = (char) ('0' + i1);
            v[8] = v[0];
            for (int i2 = 0; i2 < 10; i2++) {
                v[1] = (char) ('0' + i2);
                v[7] = v[1];
                for (int i3 = 0; i3 < 10; i3++) {
                    v[2] = (char) ('0' + i3);
                    v[6] = v[2];
                    for (int i4 = 0; i4 < 10; i4++) {
                        v[3] = (char) ('0' + i4);
                        v[5] = v[3];
                        for (int i5 = 0; i5 < 10; i5++) {
                            v[4] = (char) ('0' + i5);
                            String vv = trim0(String.valueOf(v));
                            if (check(vv, l, r)) {
                                ret += 1;
                            }
                        }
                    }
                }
            }
        }

        return ret;
    }

    private boolean isp(String n) {
        int i = 0, j = n.length() - 1;
        while (i < j) {
            if (n.charAt(i) != n.charAt(j)) {
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }

    private String trim0(String n) {
        while (n.charAt(0) == '0') {
            if (n.length() <= 2) {
                return "0";
            }
            n = n.substring(1, n.length() - 1);
        }
        return n;
    }

    private boolean check(String n, BigInteger l, BigInteger r) {
        BigInteger t = new BigInteger(n);
        t = t.pow(2);
        boolean ret = t.compareTo(r) <= 0 && t.compareTo(l) >= 0;
        if (ret && isp(t.toString())) {
            System.out.println(n + " -- >" + t);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BruteForce s = new BruteForce();
        int ret;

        ret = s.superpalindromesInRange("38455498359", "999999999999999999");
        Assert.assertEquals(45, ret);

        ret = s.superpalindromesInRange("398904669", "13479046850");
        Assert.assertEquals(6, ret);

        ret = s.superpalindromesInRange("92904622", "232747148");
        Assert.assertEquals(6, ret);

        ret = s.superpalindromesInRange("4", "1000");
        Assert.assertEquals(4, ret);
    }
}