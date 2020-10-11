package com.leetcode.algorithms.tripleswithBitwiseANDEqualToZero_982;

import org.junit.Assert;

abstract public class Solution {
    abstract public int countTriplets(int[] A);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new BruteForce(),
                new Trie(),
                new SuffixTree(),
                new Trie_4(),
                new Trie_16(),
                new Trie_256()
        };

        int ret;

        for (Solution s : solutions) {
            ret = s.countTriplets(new int[]{2, 4, 7, 3});
            Assert.assertEquals(30, ret);

            ret = s.countTriplets(new int[]{1, 1, 1});
            Assert.assertEquals(0, ret);

            ret = s.countTriplets(new int[]{0, 0, 0});
            Assert.assertEquals(27, ret);

            ret = s.countTriplets(new int[]{2, 1, 3});
            Assert.assertEquals(12, ret);

            ret = s.countTriplets(new int[]{
                    55340, 49673, 27562, 16968, 33506, 26537});
            Assert.assertEquals(6, ret);

            ret = s.countTriplets(new int[]{16968, 51367, 19877, 31234, 38232});
            Assert.assertEquals(36, ret);

            ret = s.countTriplets(new int[]{
                    55340, 49673, 27562, 16968, 33506, 26537, 51367, 19877, 31234, 38232, 59514,
                    33075, 18470, 49532, 40525, 16417, 59621, 64407, 53098, 59124, 20325, 47830,
                    58906, 44825, 30942, 6599, 28453, 40035, 59835, 63347, 31261, 56708, 17071,
                    52758, 35959, 920, 47166, 26137, 54057, 43788, 74, 32347, 56859, 15984, 21312,
                    57047, 12521, 37192, 15637, 63408});
            Assert.assertEquals(14916, ret);
        }
    }
}
