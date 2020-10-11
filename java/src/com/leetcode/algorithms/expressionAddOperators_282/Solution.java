package com.leetcode.algorithms.expressionAddOperators_282;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

abstract public class Solution {
    abstract public List<String> addOperators(String num, int target);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new Recursive(),
                new Iterative(),
                new Recursive2WithBetterExprEval()
        };

        for (Solution s : solutions) {
            List<String> ret, expect;

            ret = s.addOperators("2147483648", -2147483648);
            Assert.assertEquals(ret.size(), 0);

            ret = s.addOperators("", 5);
            Assert.assertEquals(ret.size(), 0);

            ret = s.addOperators("123", 6);
            expect = Arrays.asList("1+2+3", "1*2*3");
            Assert.assertTrue(ret.containsAll(expect) && expect.containsAll(ret));

            ret = s.addOperators("232", 8);
            expect = Arrays.asList("2*3+2", "2+3*2");
            Assert.assertTrue(ret.containsAll(expect) && expect.containsAll(ret));

            ret = s.addOperators("105", 5);
            expect = Arrays.asList("1*0+5", "10-5");
            Assert.assertTrue(ret.containsAll(expect) && expect.containsAll(ret));

            ret = s.addOperators("00", 0);
            expect = Arrays.asList("0+0", "0-0", "0*0");
            Assert.assertTrue(ret.containsAll(expect) && expect.containsAll(ret));

            ret = s.addOperators("3456237490", 9191);
            Assert.assertEquals(ret.size(), 0);
        }
    }
}
