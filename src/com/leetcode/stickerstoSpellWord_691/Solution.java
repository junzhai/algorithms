package com.leetcode.stickerstoSpellWord_691;

import org.junit.Assert;

abstract public class Solution {
    abstract public int minStickers(String[] stickers, String target);

    public static void main(String[] args) {
        Solution s = new BackTrack();
        int ret;

        ret = s.minStickers(new String[]{
                "control",
                "heart",
                "interest",
                "stream",
                "sentence",
                "soil",
                "wonder",
                "them",
                "month",
                "slip",
                "table",
                "miss",
                "boat",
                "speak",
                "figure",
                "no",
                "perhaps",
                "twenty",
                "throw",
                "rich",
                "capital",
                "save",
                "method",
                "store",
                "meant",
                "life",
                "oil",
                "string",
                "song",
                "food",
                "am",
                "who",
                "fat",
                "if",
                "put",
                "path",
                "come",
                "grow",
                "box",
                "great",
                "word",
                "object",
                "stead",
                "common",
                "fresh",
                "the",
                "operate",
                "where",
                "road",
                "mean"}, "stoodcrease");
        Assert.assertEquals(3, ret);

//        ret = s.minStickers(new String[]{"with", "example", "science"}, "thehat");
//        Assert.assertEquals(3, ret);
//
//        ret = s.minStickers(new String[]{"notice", "possible"}, "basicbasic");
//        Assert.assertEquals(-1, ret);

    }
}
