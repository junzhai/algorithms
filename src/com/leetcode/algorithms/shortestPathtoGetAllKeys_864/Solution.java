package com.leetcode.algorithms.shortestPathtoGetAllKeys_864;

import org.junit.Assert;

abstract public class Solution {
    abstract public int shortestPathAllKeys(String[] grid);

    public static void main(String[] args) {
//        Solution s = new BruteForce();
//        Solution s = new UseDP();
        Solution s = new UseBFS();
        int ret;

//        ret = s.shortestPathAllKeys(new String[]{
//                "@abcdeABCDEFf"});
//        Assert.assertEquals(-1, ret);

        ret = s.shortestPathAllKeys(new String[]{
                "@...a",
                ".###A",
                "b.BCc"});
        Assert.assertEquals(10, ret);

        ret = s.shortestPathAllKeys(new String[]{
                "@Aa"});
        Assert.assertEquals(-1, ret);


        ret = s.shortestPathAllKeys(new String[]{
                "#..#.#.#..#.#.#.....#......#..",
                ".#.......#....#A.....#.#......",
                "#....#.....#.........#........",
                "...#.#.........#..@....#....#.",
                ".#.#.##...#.........##....#..#",
                "..........#..#..###....##..#.#",
                ".......#......#...#...#.....c#",
                ".#...#.##......#...#.###...#..",
                "..........##...#.......#......",
                "#...#.........a#....#.#.##....",
                "..#..#...#...#..#....#.....##.",
                "..........#...#.##............",
                "...#....#..#.........#..D.....",
                "....#E.#....##................",
                "...........##.#.......#.#....#",
                "...#..#...#.#............#e...",
                "..#####....#.#...........##..#",
                "##......##......#.#...#..#.#..",
                ".#F.......#..##.......#....#..",
                "............#....#..#..#...#..",
                ".............#...#f...#..##...",
                "....#..#...##.........#..#..#.",
                ".....#.....##.###..##.#......#",
                ".#..#.#...#.....#........###..",
                ".....#.#...#...#.....#.....#..",
                "##.....#....B.....#..#b.......",
                ".####....##..#.##..d.#......#.",
                "..#.....#....##........##...##",
                "...#...#...C..#..#....#.......",
                "#.....##.....#.#......#......."});
        Assert.assertEquals(70, ret);

        ret = s.shortestPathAllKeys(new String[]{
                "@..aA",
                "..B#.",
                "....b"});
        Assert.assertEquals(6, ret);

        ret = s.shortestPathAllKeys(new String[]{
                "@.a.#",
                "###.#",
                "b.A.B"});
        Assert.assertEquals(8, ret);
    }
}