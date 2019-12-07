package com.leetcode.algorithms.shortestPathtoGetAllKeys_864;

import org.junit.Assert;

abstract public class Solution {
    abstract public int shortestPathAllKeys(String[] grid);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new BruteForce(),
                new DFSDP(),
                new UseDP(),
                new UseBFS()
        };
        int ret;

        for (Solution s : solutions) {
            ret = s.shortestPathAllKeys(new String[]{"@abcdeABCDEFf"});
            Assert.assertEquals(-1, ret);

            ret = s.shortestPathAllKeys(new String[]{
                    "@...a",
                    ".###A",
                    "b.BCc"});
            Assert.assertEquals(10, ret);

            ret = s.shortestPathAllKeys(new String[]{"@Aa"});
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

            ret = s.shortestPathAllKeys(new String[]{
                    "###.D.B.F.",
                    "..#b......",
                    "##....#..#",
                    "....@..#..",
                    "#d.AE.##c#",
                    ".....##.f.",
                    "#........C",
                    "..a#.#....",
                    "#....#e..#",
                    "........##"});
            Assert.assertEquals(25, ret);

            ret = s.shortestPathAllKeys(new String[]{"@Aa"});
            Assert.assertEquals(-1, ret);

            ret = s.shortestPathAllKeys(new String[]{
                    "...#.",
                    "a..@.",
                    "#..#.",
                    "b.#B.",
                    ".##.A"});
            Assert.assertEquals(7, ret);

            ret = s.shortestPathAllKeys(new String[]{
                    "Dd#b@",
                    ".fE.e",
                    "##.B.",
                    "#.cA.",
                    "aF.#C"});
            Assert.assertEquals(14, ret);
        }
    }
}