package com.leetcode.algorithms.k_SimilarStrings_854;

import com.leetcode.algorithms.pattern.Bitwise;
import com.leetcode.algorithms.pattern.DP;
import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@DP
@Bitwise
public class Solution {
    public int kSimilarity(String A, String B) {
        char[] a = A.toCharArray(), b = B.toCharArray();
        int len = a.length, key = 0;

        int[][] pos = new int[6][0];
        for (int i = 0; i < len; i++) {
            int index = a[i] - 'a';
            int[] aa = pos[index];
            aa = Arrays.copyOf(aa, aa.length + 1);
            aa[aa.length - 1] = i;
            pos[index] = aa;
            if (a[i] != b[i]) {
                key += 1 << i;
            }
        }

        Map<Integer, Integer> dp = new HashMap<>();
        return helper(dp, pos, a, b, key);
    }

    private int helper(Map<Integer, Integer> dp, int[][] pos, char[] a, char[] b, int key) {
        int len = a.length;
        if (key == 0) {
            return 0;
        }

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int start = 0;
        for (int m = 1; start < len && (key & m) == 0; start++, m <<= 1) {
        }

        int ret = dfs(dp, pos, a, b, start, start, key, 0);
        dp.put(key, ret);
        return ret;
    }

    private int dfs(Map<Integer, Integer> dp, int[][] pos, char[] a, char[] b, int start, int i, int key, int pl) {
        int m = 1 << i;
        if (b[i] == a[start]) {
            return pl + helper(dp, pos, a, b, key - m);
        }

        int ret = Integer.MAX_VALUE;
        for (int ii : pos[b[i] - 'a']) {
            if ((key & (1 << ii)) > 0) {
                ret = Math.min(ret, dfs(dp, pos, a, b, start, ii, key - m, pl + 1));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;

        ret = s.kSimilarity("ab", "ba");
        Assert.assertEquals(1, ret);

        ret = s.kSimilarity("abc", "bca");
        Assert.assertEquals(2, ret);

        ret = s.kSimilarity("abac", "baca");
        Assert.assertEquals(2, ret);

        ret = s.kSimilarity("aabc", "abca");
        Assert.assertEquals(2, ret);

        ret = s.kSimilarity("aabbccddee", "cdacbeebad");
        Assert.assertEquals(6, ret);

        ret = s.kSimilarity("abccaacceecdeea", "bcaacceeccdeaae");
        Assert.assertEquals(9, ret);

        ret = s.kSimilarity("abcdefabcdefabcdef", "acccafdeaddbbefbef");
        Assert.assertEquals(8, ret);
    }
}
