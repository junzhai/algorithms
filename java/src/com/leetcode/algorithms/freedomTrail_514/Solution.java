package com.leetcode.algorithms.freedomTrail_514;

import org.junit.Assert;

abstract public class Solution {
    abstract public int findRotateSteps(String ring, String key);

    public static void main(String[] args) {
        Solution s = new DP();
        int ret;

        ret = s.findRotateSteps(
                "xioxpdzuwyoqbesyojiwmhiayvqybfmpksgticqgpvywzcfmalcvlsberzaewgkiujhkstopffunrebhhwrhuzobcdwktapkgwft",
                "tcwwkawngvtzfutzfvekskbshsuyboaorzisirijcdqhhbpruwyptgdkpwoimuaxpfkqbexhzgjmpoqecfyowyygewbclvihlmfa");
        Assert.assertEquals(856, ret);

        ret = s.findRotateSteps("caotmcaataijjxi", "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx");
        Assert.assertEquals(137, ret);

        ret = s.findRotateSteps("abcde", "ade");
        Assert.assertEquals(6, ret);

        ret = s.findRotateSteps("godding", "gd");
        Assert.assertEquals(4, ret);
    }
}
