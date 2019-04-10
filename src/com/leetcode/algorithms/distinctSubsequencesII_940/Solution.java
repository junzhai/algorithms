package com.leetcode.algorithms.distinctSubsequencesII_940;

import org.junit.Assert;

abstract public class Solution {
    abstract public int distinctSubseqII(String S);

    public static void main(String[] args) {
        Solution s = new DP2();
//        Solution s = new DP1();
        int ret;

        ret = s.distinctSubseqII
                ("zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn");
        Assert.assertEquals(97915677, ret);

        ret = s.distinctSubseqII("aaa");
        Assert.assertEquals(3, ret);

        ret = s.distinctSubseqII("aba");
        Assert.assertEquals(6, ret);

        ret = s.distinctSubseqII("abc");
        Assert.assertEquals(7, ret);
    }
}
