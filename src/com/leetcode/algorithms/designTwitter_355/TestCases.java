package com.leetcode.algorithms.designTwitter_355;

import org.junit.Assert;

import java.util.List;

class TestCases {
    void test1() {
        Twitter t = new Twitter();
        List<Integer> ret;

        t.postTweet(1, 5);
        ret = t.getNewsFeed(1);
        Assert.assertEquals(5, ret.get(0).intValue());

        t.follow(1, 2);
        t.postTweet(2, 6);
        ret = t.getNewsFeed(1);
        Assert.assertEquals(6, ret.get(0).intValue());
        Assert.assertEquals(5, ret.get(1).intValue());

        t.unfollow(1, 2);
        ret = t.getNewsFeed(1);
        Assert.assertEquals(5, ret.get(0).intValue());
    }

    void test2() {
        Twitter t = new Twitter();
        List<Integer> ret;

        t.postTweet(1, 5);
        t.postTweet(1, 3);
        t.postTweet(1, 101);
        t.postTweet(1, 13);
        t.postTweet(1, 10);
        t.postTweet(1, 2);
        t.postTweet(1, 94);
        t.postTweet(1, 505);
        t.postTweet(1, 333);
        t.postTweet(1, 22);
        t.postTweet(1, 11);
        ret = t.getNewsFeed(1);
    }

    void test3() {
        Twitter t = new Twitter();
        List<Integer> ret;

        t.postTweet(1, 5);
        t.postTweet(1, 1);
        ret = t.getNewsFeed(1);
        Assert.assertEquals(1, ret.get(0).intValue());
        Assert.assertEquals(5, ret.get(1).intValue());
    }

    void test4() {
        Twitter t = new Twitter();
        List<Integer> ret;

        t.postTweet(1, 4);
        t.postTweet(2, 5);
        t.unfollow(1, 2);
        t.follow(1, 2);
        ret = t.getNewsFeed(1);
        Assert.assertEquals(5, ret.get(0).intValue());
        Assert.assertEquals(4, ret.get(1).intValue());
    }
}
