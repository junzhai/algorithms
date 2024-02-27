package com.leetcode.algorithms.minimumReverseOperations_2612;

import com.leetcode.util.LargeCaseUtil;
import com.pattern.algorithms.BFS;
import org.junit.Assert;

@BFS
abstract public class Solution {

    abstract public int[] minReverseOperations(int n, int p, int[] banned, int k);

    public static void main(String[] args) {
        Solution s = new UseTreeSet_1();
        s = new TreeMapInterval();
        s = new UseSegmentTree();
        int[] ret;
        Assert.assertArrayEquals(new int[]{0}, s.minReverseOperations(1, 0, new int[]{}, 1));
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4}, s.minReverseOperations(5, 0, new int[]{}, 2));


        int[] banned = LargeCaseUtil.readArray("src/com/leetcode/algorithms/minimumReverseOperations_2612/case1");

        ret = s.minReverseOperations(4, 0, new int[]{}, 4);
        ret = s.minReverseOperations(5, 0, new int[]{}, 4);
        Assert.assertArrayEquals(new int[]{0, -1, -1, 1}, s.minReverseOperations(4, 0, new int[]{}, 4));
        Assert.assertArrayEquals(new int[]{0, 3, 2, 1, 2, 3}, s.minReverseOperations(6, 0, new int[]{}, 4));
        ret = s.minReverseOperations(100000, 68887, banned, 39421);
    }
}
