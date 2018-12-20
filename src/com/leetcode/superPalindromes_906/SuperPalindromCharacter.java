package com.leetcode.superPalindromes_906;

import java.math.BigInteger;
import java.util.Arrays;

public class SuperPalindromCharacter extends Solution {
    @Override
    public int superpalindromesInRange(String L, String R) {
        BigInteger l = new BigInteger(L), r = new BigInteger(R);
        int ret = 0;
        char[] v = new char[8];
        Arrays.fill(v, '0');
        for (int i = 0; i < 4; i++) {
            v[i] = '1';
            v[7 - i] = '1';
            if (check(String.valueOf(v, i, 8 - 2 * i), l, r)) {
                ret += 1;
            }
            v[i] = '0';
            v[7 - i] = '0';
        }

        for (int i = 0; i < 4; i++) {
            v[i] = '2';
            v[7 - i] = '2';
            if (check(String.valueOf(v, i, 8 - 2 * i), l, r)) {
                ret += 1;
            }
            v[i] = '0';
            v[7 - i] = '0';
        }

        for (int i = 0; i < 4; i++) {
            v[i] = '1';
            v[7 - i] = '1';
            for (int j = i + 1; j < 4; j++) {
                v[j] = '1';
                v[7 - j] = '1';
                if (check(String.valueOf(v, i, 8 - 2 * i), l, r)) {
                    ret += 1;
                }
                v[j] = '0';
                v[7 - j] = '0';
            }
            v[i] = '0';
            v[7 - i] = '0';
        }

        Arrays.fill(v, '1');
        if (check(String.valueOf(v), l, r)) {
            ret += 1;
        }

        for (int i = 0; i < 4; i++) {
            v[i] = '0';
            v[7 - i] = '0';
            if (check(i == 0 ? String.valueOf(v, 1, 6) : String.valueOf(v), l, r)) {
                ret += 1;
            }
            v[i] = '1';
            v[7 - i] = '1';
        }

        v = new char[9];
        Arrays.fill(v, '0');
        for (int i = 0; i < 4; i++) {
            v[i] = '2';
            v[8 - i] = '2';
            if (check(String.valueOf(v, i, 9 - 2 * i), l, r)) {
                ret += 1;
            }

            v[4] = '1';
            if (check(String.valueOf(v, i, 9 - 2 * i), l, r)) {
                ret += 1;
            }
            v[4] = '0';
            v[i] = '0';
            v[8 - i] = '0';
        }

        for (int i = 0; i < 4; i++) {
            v[i] = '1';
            v[8 - i] = '1';
            if (check(String.valueOf(v, i, 9 - 2 * i), l, r)) {
                ret += 1;
            }

            v[4] = '1';
            if (check(String.valueOf(v, i, 9 - 2 * i), l, r)) {
                ret += 1;
            }
            v[4] = '2';
            if (check(String.valueOf(v, i, 9 - 2 * i), l, r)) {
                ret += 1;
            }
            v[4] = '0';
            v[i] = '0';
            v[8 - i] = '0';
        }

        for (int i = 0; i < 4; i++) {
            v[i] = '1';
            v[8 - i] = '1';
            for (int j = i + 1; j < 4; j++) {
                v[j] = '1';
                v[8 - j] = '1';
                if (check(String.valueOf(v, i, 9 - 2 * i), l, r)) {
                    ret += 1;
                }

                v[4] = '1';
                if (check(String.valueOf(v, i, 9 - 2 * i), l, r)) {
                    ret += 1;
                }
                v[4] = '2';
                if (check(String.valueOf(v, i, 9 - 2 * i), l, r)) {
                    ret += 1;
                }
                v[4] = '0';
                v[j] = '0';
                v[8 - j] = '0';
            }
            v[i] = '0';
            v[8 - i] = '0';
        }

        Arrays.fill(v, '1');
        if (check(String.valueOf(v), l, r)) {
            ret += 1;
        }
        v[4] = '0';
        if (check(String.valueOf(v), l, r)) {
            ret += 1;
        }
        v[4] = '1';

        for (int i = 0; i < 4; i++) {
            v[i] = '0';
            v[8 - i] = '0';
            if (check(String.valueOf(i == 0 ? String.valueOf(v, 1, 7) : String.valueOf(v)), l, r)) {
                ret += 1;
            }

            v[4] = '0';
            if (check(String.valueOf(i == 0 ? String.valueOf(v, 1, 7) : String.valueOf(v)), l, r)) {
                ret += 1;
            }
            v[4] = '1';
            v[i] = '1';
            v[8 - i] = '1';
        }

        if (check(String.valueOf(v, 4, 1), l, r)) {
            ret += 1;
        }

        v[4] = '0';
        if (check(String.valueOf(v, 4, 1), l, r)) {
            ret += 1;
        }
        v[4] = '2';
        if (check(String.valueOf(v, 4, 1), l, r)) {
            ret += 1;
        }
        v[4] = '3';
        if (check(String.valueOf(v, 4, 1), l, r)) {
            ret += 1;
        }
        return ret;
    }

    private boolean check(String n, BigInteger l, BigInteger r) {
        BigInteger t = new BigInteger(n);
        t = t.pow(2);
        boolean ret = t.compareTo(r) <= 0 && t.compareTo(l) >= 0;
        if (ret) {
            System.out.println(n);
        }
        return ret;
    }
}