package com.leetcode.algorithms.stampingTheSequence_936;

import org.junit.Assert;

abstract public class Solution {
    abstract public int[] movesToStamp(String stamp, String target);

    public static void main(String[] args) {
        Solution s = new UseKMP();
        int[] ret;

        ret = s.movesToStamp("uzavnaucpu", "uzuzuzavnaucpuu");

        ret = s.movesToStamp("adba", "adadadbabbda");

        ret = s.movesToStamp("abca", "aabcaca");
        Assert.assertArrayEquals(new int[]{3, 0, 1}, ret);
    }

}
