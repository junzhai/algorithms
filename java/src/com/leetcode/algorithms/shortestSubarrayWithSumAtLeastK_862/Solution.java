package com.leetcode.algorithms.shortestSubarrayWithSumAtLeastK_862;

import org.junit.Assert;

abstract public class Solution {
    abstract public int shortestSubarray(int[] A, int K);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new ArrayDeque(),
                new ArrayBinarySearch(),
                new JumpingSlidingWindow(),
                new SlidingWindowWithSortedArray()
        };

        int ret;
        for (Solution s : solutions) {
            ret = s.shortestSubarray(new int[]{1}, 1);
            Assert.assertEquals(ret, 1);

            ret = s.shortestSubarray(new int[]{1, 2}, 4);
            Assert.assertEquals(ret, -1);

            ret = s.shortestSubarray(new int[]{48, 99, 37, 4, -31}, 140);
            Assert.assertEquals(ret, 2);

            ret = s.shortestSubarray(new int[]{17, 85, 93, -45, -21}, 150);
            Assert.assertEquals(ret, 2);

            ret = s.shortestSubarray(new int[]{-28, 81, -20, 28, -29}, 89);
            Assert.assertEquals(ret, 3);

            ret = s.shortestSubarray(new int[]{-11, -15, 76, 41, -41, 68, 41, 12, 73, -8}, 50);
            Assert.assertEquals(ret, 1);

            ret = s.shortestSubarray(new int[]{44, -25, 75, -50, -38, -42, -32, -6, -40, -47}, 19);
            Assert.assertEquals(ret, 1);

            ret = s.shortestSubarray(new int[]{
                    -23, 51, -14, -6, 36, 33, 76, -26, -6, 58, -16, 1, 98, 2, -20, 48, -19, -41, -34, 62
            }, 221);
            Assert.assertEquals(ret, 9);

            ret = s.shortestSubarray(new int[]{
                    -34, 37, 51, 3, -12, -50, 51, 100, -47, 99, 34, 14, -13, 89, 31, -14, -44, 23, -38, 6
            }, 151);
            Assert.assertEquals(ret, 2);

            ret = s.shortestSubarray(new int[]{
                    18393, 13015, 39877, -46990, 84110, -16361, -42889, -10085, 46644, 91545,
                    71230, 48090, 34489, 2788, 56496, -32528, 77455, -44282, 80504, 77949, 70, 74450, -4005, 82184,
                    -19401, 49038, -10000, 31028, 26603, 62302, 76071, 73298, -20008, -12421, -11904, -8055, 50871,
                    20857, 56174, 88271, 37380, 56974, 85085, -29377, -39430, 86935, -42349, -12415, -21752, 95087
            }, 917790);
            Assert.assertEquals(ret, 24);

            ret = s.shortestSubarray(new int[]{
                            50794, 73683, 43162, 66528, 94958, -46678, 29835, 6598, 28966, 50644, 25061, 41941, 20342,
                            4731, 81995, 92244, 14120, 74565, -7594, 82273, 8420, -30048, -19402, 17709, -28100, -30214,
                            -40444, -43819, 23107, -333, 16503, -47179, 11469, -10072, -15801, 51458, 32970, -25433,
                            43444, -45779, 19814, -22683, 71867, 30849, 25578, 69862, 73092, -7947, 33630, -4959,
                            -10326,

                            41573, 9540, 14023, -40203, 39297, 29723, 89931, 98956, -15696, 37830, 19067, 85795, 27632,
                            -39559, -34491, 159, -16283, -25614, 27239, -37105, -11261, -2868, 21052, -2695, -30701,
                            -35337, 83438, -977, -1601, 45415, 3357, 80421, 40750, 73362, 76262, -32708, 32474, -34140,
                            3962, 61708, 56597, 13012, 57775, -4174, 72718, 21225, 45122, 5081, 28569
                    },
                    185822);
            Assert.assertEquals(ret, 2);

            ret = s.shortestSubarray(new int[]{
                            17985, -36292, -23941, 80618, 20594, -6181, 9181, 65796, -25716, 66593, -6873, 34062, 29878,
                            852, -4767, -36415, 11783, 8085, -41063, -39940, 74284, 66272, 82385, 51634, -48550, 9028,
                            -30777, 86509, 44623, 9413, -38369, -1822, 46408, 35217, 72635, -16560, 85373, 52105, 39477,
                            3852, 45974, -21593, 15481, 47280, 73889, -42981, 54978, 95169, -19615, 93133
                    }
                    , 387303);
            Assert.assertEquals(ret, 11);

            ret = s.shortestSubarray(new int[]{
                    -45920, 21585, 78217, 56215, 8480, -30307, 85801, -23309, 37466, 14949, 40753, 41694, 65382, 8738,
                    69957, -7108, -22199, 8368, -43562, 46592, -49459, 80106, -24014, -39742, 22839, 31731, 48196,
                    52866,
                    97193, -6483, -38614, 17145, 35105, -13875, -921, 89689, 14770, 61496, 40638, 22856, 70276, 71276,
                    -40474, 38744, -13868, 33468, 35697, 35989, -768, -25394, -41995, 3819, -23043, -10697, 60280, 8589,
                    47763, 9990, 32657, 70436, 66928, 51086, -9603, 55465, -25666, 2250, -35683, 19840, 80192, 20598,
                    -12612, -6004, 85768, 90328, -2821, -48599, 35203, -11913, 10164, 3526, 86466, -15671, -47459,
                    20271,
                    51106, 17007, -11406, 60423, 36966, 26891, 55126, 18974, -23178, 52652, 29681, 31744, -7003, 57481,
                    -30030, -19750
            }, 87750);
            Assert.assertEquals(ret, 1);
        }
    }
}