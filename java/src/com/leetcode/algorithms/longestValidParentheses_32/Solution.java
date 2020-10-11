package com.leetcode.algorithms.longestValidParentheses_32;

abstract public class Solution {
    abstract public int longestValidParentheses(String s);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new BruteForce(),
                new DynamicProgramming(),
                new ParenthesesLevel(),
                new UsingStack(),
                new WithoutExtraSpace()
        };

        for (Solution solution : solutions) {
            System.out.println();
            System.out.println(solution.getClass().getSimpleName() + ": ");
            int ret;

            ret = solution.longestValidParentheses("())");
            System.out.println("done --> 2, " + ret);

            ret = solution.longestValidParentheses("(()(()())()");
            System.out.println("done --> 10, " + ret);

            ret = solution.longestValidParentheses("(()()");
            System.out.println("done --> 4, " + ret);

            ret = solution.longestValidParentheses(")()())()()(");
            System.out.println("done --> 4, " + ret);

            ret = solution.longestValidParentheses("()(()");
            System.out.println("done --> 2, " + ret);

            ret = solution.longestValidParentheses(")()())");
            System.out.println("done --> 4, " + ret);

            ret = solution.longestValidParentheses("(()");
            System.out.println("done --> 2, " + ret);
        }
    }
}
