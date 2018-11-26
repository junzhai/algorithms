package com.leetcode.validPermutationsForDISequence_903;

import org.junit.Assert;

abstract public class Solution {
    abstract public int numPermsDISequence(String S);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
//                new BruteForce(),
//                new DP(),
//                new DP2(),
                new DP1()
        };

        for (Solution s : solutions) {
            int ret;

            ret = s.numPermsDISequence("D");
            Assert.assertEquals(1, ret);

            ret = s.numPermsDISequence("DID");
            Assert.assertEquals(5, ret);

            ret = s.numPermsDISequence("DIDI");
            Assert.assertEquals(16, ret);

            ret = s.numPermsDISequence("DDIID");
            Assert.assertEquals(26, ret);

            ret = s.numPermsDISequence("DIID");
            Assert.assertEquals(11, ret);

            ret = s.numPermsDISequence("DIIID");
            Assert.assertEquals(19, ret);

            ret = s.numPermsDISequence("IDDDIIDIIIIIIIIDI");
            Assert.assertEquals(93842753, ret);

            ret = s.numPermsDISequence("IDDDIIDIIIIIIIIDID");
            Assert.assertEquals(180399751, ret);

            ret = s.numPermsDISequence("IDDDIIDIIIIIIIIDIDI");
            Assert.assertEquals(807503983, ret);

            ret = s.numPermsDISequence("IDDDIIDIIIIIIIIDIDID");
            Assert.assertEquals(853197538, ret);

            ret = s.numPermsDISequence("IIDIIIIDIDIIDIDDIDID");
            Assert.assertEquals(585812576, ret);
        }
    }
}