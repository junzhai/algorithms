package com.leetcode.algorithms.longestPalindromicSubsequence_516;

abstract public class Solution {
    abstract public int longestPalindromeSubseq(String s);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new RecursiveDP(),
                new Recursive2DP(),
        };

        for (Solution s : solutions) {
            int ret;

            ret = s.longestPalindromeSubseq("bbbab");
            System.out.println("done --> 4, " + ret);

            ret = s.longestPalindromeSubseq("abcdef");
            System.out.println("done --> 1, " + ret);

            ret = s.longestPalindromeSubseq("aabaaba");
            System.out.println("done --> 6, " + ret);

            ret = s.longestPalindromeSubseq("euazbipzncptldueeue");
            System.out.println("done --> 7, " + ret);

            ret = s.longestPalindromeSubseq(
                    "euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew");
            System.out.println("done --> 159, " + ret);
        }
    }
}
