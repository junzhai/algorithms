package com.leetcode.cutOffTreesforGolfEvent_675;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract public class Solution {
    abstract public int cutOffTree(List<List<Integer>> forest);

    public static void main(String[] args) {
//        Solution s = new DFS();
//        Solution s = new BFS();
        Solution s = new BFS();

        int ret;
        List<List<Integer>> forest;

        forest = new ArrayList<>();
        forest.add(Arrays.asList(54581641, 64080174, 24346381, 69107959));
        forest.add(Arrays.asList(86374198, 61363882, 68783324, 79706116));
        forest.add(Arrays.asList(668150, 92178815, 89819108, 94701471));
        forest.add(Arrays.asList(83920491, 22724204, 46281641, 47531096));
        forest.add(Arrays.asList(89078499, 18904913, 25462145, 60813308));
        ret = s.cutOffTree(forest);
        Assert.assertEquals(57, ret);

        forest = new ArrayList<>();
        forest.add(Arrays.asList(63750247, 40643210, 95516857, 89928134, 66334829, 58741187, 76532780, 45104329));
        forest.add(Arrays.asList(3219401, 97566322, 9135413, 75944198, 93735601, 33923288, 50116695, 83660397));
        forest.add(Arrays.asList(64460750, 53045740, 31903386, 78155821, 90848739, 38769489, 99349027, 85982891));
        forest.add(Arrays.asList(30628785, 51077683, 70534803, 67460877, 91077770, 74197235, 5696362, 91459886));
        forest.add(Arrays.asList(56105195, 82479378, 45937951, 52817583, 2768114, 43329099, 28189138, 21418604));
        ret = s.cutOffTree(forest);
        Assert.assertEquals(192, ret);

        forest = new ArrayList<>();
        forest.add(Arrays.asList(3154, 0, 0, 0, 6831, 5854, 0, 0, 0));
        forest.add(Arrays.asList(607, 0, 9454, 9170, 3234, 1006, 9080, 8700, 0));
        forest.add(Arrays.asList(0, 198, 0, 5148, 2003, 0, 0, 0, 0));
        forest.add(Arrays.asList(0, 0, 3251, 0, 1346, 7432, 8783, 0, 7211));
        forest.add(Arrays.asList(6625, 5441, 0, 0, 0, 5444, 4343, 0, 0));
        forest.add(Arrays.asList(0, 8127, 2303, 3099, 0, 2371, 5732, 0, 940));
        ret = s.cutOffTree(forest);
        Assert.assertEquals(-1, ret);

        forest = new ArrayList<>();
        forest.add(Arrays.asList(1, 2, 3));
        forest.add(Arrays.asList(0, 0, 4));
        forest.add(Arrays.asList(7, 6, 5));
        ret = s.cutOffTree(forest);
        Assert.assertEquals(6, ret);

        forest = new ArrayList<>();
        forest.add(Arrays.asList(1, 2, 3));
        forest.add(Arrays.asList(0, 0, 0));
        forest.add(Arrays.asList(7, 6, 5));
        ret = s.cutOffTree(forest);
        Assert.assertEquals(-1, ret);

        forest = new ArrayList<>();
        forest.add(Arrays.asList(2, 3, 4));
        forest.add(Arrays.asList(0, 0, 5));
        forest.add(Arrays.asList(8, 7, 6));
        ret = s.cutOffTree(forest);
        Assert.assertEquals(6, ret);

        forest = new ArrayList<>();
        forest.add(Arrays.asList(1, 0, 4, 0));
        forest.add(Arrays.asList(3, 8, 5, 0));
        forest.add(Arrays.asList(9, 0, 2, 0));
        forest.add(Arrays.asList(10, 11, 7, 6));
        ret = s.cutOffTree(forest);
        Assert.assertEquals(22, ret);

        forest = new ArrayList<>();
        forest.add(Arrays.asList(0));
        forest.add(Arrays.asList(0));
        forest.add(Arrays.asList(6014));
        ret = s.cutOffTree(forest);
        Assert.assertEquals(-1, ret);
    }
}
