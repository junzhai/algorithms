package com.leetcode.algorithms.deleteOperationforTwoStrings_583;

import org.junit.Assert;

abstract public class Solution {
    abstract public int minDistance(String word1, String word2);

    public static void main(String[] args) {
//        Solution s = new UseDP();
        Solution s = new UnknownDPPath();
        int ret;


        ret = s.minDistance("dinitrophenylhydrazine", "benzalphenylhydrazone");
        Assert.assertEquals(13, ret);

        ret = s.minDistance("intention", "execution");
        Assert.assertEquals(8, ret);

        ret = s.minDistance("sea", "ate");
        Assert.assertEquals(4, ret);

        ret = s.minDistance("sea", "eat");
        Assert.assertEquals(2, ret);
    }
}
