package com.leetcode;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {
    public String frequencySort(String s) {
        int[] o = new int[s.length() + 1];

        int[] c = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            o[c[ch]] -= c[ch];
            c[ch] += 1;
            o[c[ch]] += c[ch];
        }

        for (int i = o.length - 1, su = 0; i >=0; i--) {
            int t = o[i];
            o[i] = su;
            su += t;
        }

        char[] ret = new char[s.length()];
        for (char ch = 0; ch < 256; ch++) {
            for (int i = 0; i < c[ch]; i++) {
                ret[o[c[ch]]] = ch;
                o[c[ch]] += 1;
            }
        }

        return String.valueOf(ret);
    }

    public String frequencySort1(String s) {
        Character[] o = new Character[256];
        for (char i = 0; i < 256; i++) {
            o[i] = i;
        }

        int[] c = new int[256];
        char min = 255, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            c[ch] += 1;
            min = (char) Math.min((int) min, (int) ch);
            max = (char) Math.max((int) max, (int) ch);
        }
        if (min > max) {
            min = max;
        }

        Arrays.sort(o, (int) min, (int) max + 1, new Comparator<Character>() {
            public int compare(Character i1, Character i2) {
                return c[i2.charValue()] - c[i1.charValue()];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = min; i <= max; i++) {
            char ch = o[i];
            if (c[ch] == 0) {
                break;
            }
            for (int k = 0; k < c[ch]; k++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Sandbox s = new Sandbox();
        String ret;

        ret = s.frequencySort("raaeaedere");

        ret = s.frequencySort("eeeee");

        ret = s.frequencySort("tee");

        ret = s.frequencySort("");
        Assert.assertEquals("", ret);

        ret = s.frequencySort("tree");
//        Assert.assertEquals(0, ret);
    }
}