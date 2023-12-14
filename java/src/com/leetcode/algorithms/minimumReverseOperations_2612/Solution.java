package com.leetcode.algorithms.minimumReverseOperations_2612;

import com.leetcode.util.LargeCaseUtil;
import com.pattern.algorithms.BFS;
import org.junit.Assert;

@BFS
abstract public class Solution {

    abstract public int[] minReverseOperations(int n, int p, int[] banned, int k);

    public static void main(String[] args) {
        Solution s = new UseTreeSet();
        int[] banned = LargeCaseUtil.readArray("src/com/leetcode/algorithms/minimumReverseOperations_2612/case1");
        long start = System.currentTimeMillis();
//        int[] ret = s.minReverseOperations(4, 0, new int[]{}, 4);
//        int[] ret = s.minReverseOperations(5, 0, new int[]{}, 4);

        int[] ret = s.minReverseOperations(100000, 68887, banned, 39421);
        Assert.assertArrayEquals(new int[]{0, -1, -1, 1}, s.minReverseOperations(4, 0, new int[]{}, 4));
        System.out.println("Time used: " + (System.currentTimeMillis() - start));
    }
}
