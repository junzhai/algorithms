package com.leetcode.algorithms.strStr_28;

import com.pattern.KMP;
import org.junit.Assert;

@KMP
public class Solution {
    public int strStr(String haystack, String needle) {
        int l = needle.length();
        if (l == 0) {
            return 0;
        }

        int[] back = new int[l];
        back[0] = -1;
        for (int i = 1; i < l - 1; i++) {
            int pos = back[i];
            while (pos >= 0 && needle.charAt(pos) != needle.charAt(i)) {
                pos = back[pos];
            }
            back[i + 1] = pos + 1;
        }

        for (int i = 0, pp = 0; i < haystack.length(); i++) {
            char ch = haystack.charAt(i);
            while (pp >= 0 && needle.charAt(pp) != ch) {
                pp = back[pp];
            }
            pp += 1;
            if (pp >= l) {
                return i - l + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;

        ret = s.strStr("", "");
        Assert.assertEquals(0, ret);

        ret = s.strStr("hello", "ll");
        Assert.assertEquals(2, ret);

        ret = s.strStr("aaaaa", "bba");
        Assert.assertEquals(-1, ret);
    }
}
