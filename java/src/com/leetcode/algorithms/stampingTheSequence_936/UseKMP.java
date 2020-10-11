package com.leetcode.algorithms.stampingTheSequence_936;

import com.leetcode.algorithms.pattern.KMP;

import java.util.Arrays;

@KMP
public class UseKMP extends Solution {
    @Override
    public int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray(), t = target.toCharArray();
        int[] vector = buildVector(s);

        int index = 0, len = t.length;
        int[] ret = new int[len * 10];
        while (index < len) {
            if (index == 0) {
                index = kmp(ret, s, 0, t, index, vector);
            } else {
                int tmp = -1;
                for (int pos = 0; pos < s.length; pos++) {
                    if (t[index] == s[pos]) {
                        tmp = kmp(ret, s, pos, t, index, vector);
                        if (tmp != -1) {
                            break;
                        }
                    }
                }
                index = tmp;
            }
            if (index == -1) {
                return new int[0];
            }
        }

        return Arrays.copyOfRange(ret, ret.length - ret[0], ret.length);
    }

    private int kmp(int[] ret, char[] stamp, int pos, char[] target, int index, int[] vector) {
        int len = target.length, pl = stamp.length, l = 1;
        int[] tmp = new int[len - index];
        tmp[0] = index - pos;
        for (; index < len && pos < pl; index++) {
            if (target[index] == stamp[pos]) {
                pos += 1;
                continue;
            }
            while (pos >= 0 && target[index] != stamp[pos]) {
                pos = vector[pos];
            }
            if (pos == -1) {
                break;
            }
            tmp[l++] = index - pos;
            pos += 1;
        }

        if (pos < pl) {
            return -1;
        }

        ret[0] += l;
        System.arraycopy(tmp, 0, ret, ret.length - ret[0], l);
        return index;
    }

    private int[] buildVector(char[] stamp) {
        int len = stamp.length;
        int[] ret = new int[len];
        ret[0] = -1;
        for (int i = 1; i < len; i++) {
            int p = ret[i - 1];
            while (p >= 0 && stamp[p] != stamp[i - 1]) {
                p = ret[p];
            }
            ret[i] = p + 1;
        }
        return ret;
    }

}
