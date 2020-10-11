package com.leetcode.algorithms.countDifferentPalindromicSubsequences_730;

import org.junit.Assert;

abstract public class Solution {
    abstract public int countPalindromicSubsequences(String S);

    public static void main(String[] arg) {
        Solution[] solutions = new Solution[]{
//                new BruteForce(),
//                new Histogram(),
                new Histogram1()
        };
        int ret;

        for (Solution s : solutions) {
            ret = s.countPalindromicSubsequences("abbadbcacbbdadadadcbdccdbdbcdacbcbabacbbccdadbbcacaacdbcdcdadacacaabcaddcdbbbbccdcdddbdddaabdccbaccccabbdacacadcddcadaacaabccbabbbdaabcaabadbbdcacbbdbccbadadbcdcdbadcbcbaabbbbcadaaaccaccdabbbadbcababa");
            Assert.assertEquals(703613271, ret);

            ret = s.countPalindromicSubsequences("baaddaaabaddccbbbdcbcccbdbdabdabdbadabddbbcbbcabbccdaccdbcbbcdcdbaadbcadacabcaaaadbcaddbbacddcdabaadcacacdcabaadacadcccdcbbcdabdcdacaacdcdbdacbdbcdcbaddaccabaaaabcadacdaddbcccbcdbadbdddaaabbdbdbcbcdab");
            Assert.assertEquals(431300010, ret);

            ret = s.countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba");
            Assert.assertEquals(104860361, ret);

            ret = s.countPalindromicSubsequences("dddcabadcbabccdadccbcabcdacdadcbbbcadaabcddccbcadaddbdbdacbcccddabbbcbcdccdaadabadacacbdbbbadcdaaabb");
            Assert.assertEquals(539524363, ret);

            ret = s.countPalindromicSubsequences("aaa");
            Assert.assertEquals(3, ret);

            ret = s.countPalindromicSubsequences("bccb");
            Assert.assertEquals(6, ret);

            ret = s.countPalindromicSubsequences("dbccbdc");
            Assert.assertEquals(17, ret);

            ret = s.countPalindromicSubsequences("dbcacccbdca");
            Assert.assertEquals(42, ret);

            ret = s.countPalindromicSubsequences("bacbabcbac");
            Assert.assertEquals(43, ret);

            ret = s.countPalindromicSubsequences("cbbabcbc");
            Assert.assertEquals(19, ret);

            ret = s.countPalindromicSubsequences("dbcbaaacdcbabcbddaac");
            Assert.assertEquals(356, ret);
        }
    }
}
