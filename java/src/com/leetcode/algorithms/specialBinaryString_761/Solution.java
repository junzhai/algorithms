package com.leetcode.algorithms.specialBinaryString_761;

import com.pattern.algorithms.UnSortedArrayHistogram;
import org.junit.Assert;

@UnSortedArrayHistogram
public class Solution {
    public String makeLargestSpecial(String S) {
        int len = S.length(), l = 1;
        char[] chs = S.toCharArray(), buf = new char[len];
        int[][] c1 = new int[len + 1][3];
        c1[0][0] = 0;
        c1[0][1] = -1;
        for (int i = 0, c = 0; i < len; i++) {
            c += (chs[i] == '1' ? 1 : -1);
            int p = l;
            if (c < c1[l - 1][0]) {
                p = l - 1;
                while (p > 0 && c1[p - 1][0] == c1[p][0]) {
                    c1[p - 1][2] = c1[p][1] - c1[p - 1][1];
                    p -= 1;
                }

                if (l - p >= 3) {
                    int sss = c1[p][1] + 1, bi = 0;
                    swap(chs, c1, p, l - 2, 2);
                    for (int k = p; k < l - 1; k++) {
                        System.arraycopy(chs, c1[k][1] + 1, buf, bi, c1[k][2]);
                        bi += c1[k][2];
                    }
                    System.arraycopy(buf, 0, chs, sss, bi);
                }
            }

            c1[p][0] = c;
            c1[p][1] = i;
            l = p + 1;
        }

        if (l >= 3) {
            int p = l - 1;
            while (p > 0 && c1[p - 1][0] == c1[p][0]) {
                c1[p - 1][2] = c1[p][1] - c1[p - 1][1];
                p -= 1;
            }
            swap(chs, c1, 0, l - 2, 2);
            int bi = 0;
            for (int k = 0; k < l - 1; k++) {
                System.arraycopy(chs, c1[k][1] + 1, buf, bi, c1[k][2]);
                bi += c1[k][2];
            }
            System.arraycopy(buf, 0, chs, 0, bi);
        }

        return String.valueOf(chs);
    }

    private void swap(char[] s, int[][] c1, int b, int e, int i) {
        if (b >= e) {
            return;
        }

        if (i > c1[b][2]) {
            return;
        }

        int l = b, r = e;
        while (l <= r) {
            if (s[c1[l][1] + i] == '1') {
                l += 1;
                continue;
            }
            if (s[c1[r][1] + i] == '0') {
                r -= 1;
                continue;
            }
            int[] tmp = c1[l];
            c1[l] = c1[r];
            c1[r] = tmp;
        }

        swap(s, c1, b, l - 1, i + 1);
        swap(s, c1, l, e, i + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ret;

        ret = s.makeLargestSpecial("1011001010");
        Assert.assertEquals("1100101010", ret);

        ret = s.makeLargestSpecial("101010");
        Assert.assertEquals("101010", ret);

        ret = s.makeLargestSpecial("1010101100");
        Assert.assertEquals("1100101010", ret);

        ret = s.makeLargestSpecial("11011000");
        Assert.assertEquals("11100100", ret);
    }
}
