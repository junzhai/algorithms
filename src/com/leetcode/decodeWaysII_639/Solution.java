package com.leetcode.decodeWaysII_639;

abstract public class Solution {
    abstract public int numDecodings(String s);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new ForwardDP(),
                new BackwardDP()
        };

        for (Solution s : solutions) {
            int ret;

            ret = s.numDecodings("3*");
            System.out.println("done --> 9, " + ret);

            ret = s.numDecodings("1003");
            System.out.println("done --> 0, " + ret);

            ret = s.numDecodings("0");
            System.out.println("done --> 0, " + ret);

            ret = s.numDecodings("*");
            System.out.println("done --> 9, " + ret);

            ret = s.numDecodings("*1*1*0");
            System.out.println("done --> 404, " + ret);

            ret = s.numDecodings("**********1111111111");
            System.out.println("done --> 133236775, " + ret);

            ret = s.numDecodings("*********");
            System.out.println("done --> 291868912, " + ret);

            ret = s.numDecodings("1*");
            System.out.println("done --> 18, " + ret);
        }
    }
}
