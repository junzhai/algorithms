package com.leetcode.algorithms.designTwitter_355;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {
    private static class CircularQueue {
        private static volatile int id = 0;
        int[] msg = new int[10], seq = new int[10];
        int len = 0, head = 0;

        void offer(int tweetId) {
            int pos = (head + len) % 10;
            msg[pos] = tweetId;
            seq[pos] = id++;
            if (len == 10) {
                head = (head + 1) % 10;
            } else {
                len += 1;
            }
        }
    }

    private final Map<Integer, Set<Integer>> follow;
    private final Map<Integer, CircularQueue> tweet;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        follow = new HashMap<>();
        tweet = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!tweet.containsKey(userId)) {
            tweet.put(userId, new CircularQueue());
        }
        tweet.get(userId).offer(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by
     * users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        Map<CircularQueue, Integer> index = new HashMap<>();
        PriorityQueue<CircularQueue> pq = new PriorityQueue<>(10, new Comparator<CircularQueue>() {
            public int compare(CircularQueue q1, CircularQueue q2) {
                return q2.seq[index.get(q2)] - q1.seq[index.get(q1)];
            }
        });

        CircularQueue q = tweet.get(userId);
        if (q != null && q.len > 0) {
            index.put(q, (q.head + q.len - 1) % 10);
            pq.offer(q);
        }

        if (follow.containsKey(userId)) {
            for (int uid : follow.get(userId)) {
                q = tweet.get(uid);
                if (q != null && q.len > 0) {
                    index.put(q, (q.head + q.len - 1) % 10);
                    pq.offer(q);
                }
            }
        }

        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (pq.isEmpty()) {
                break;
            }
            q = pq.poll();
            int pos = index.get(q);
            ret.add(q.msg[pos]);
            if (pos != q.head) {
                index.put(q, (pos + 9) % 10);
                pq.offer(q);
            }
        }
        return ret;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        if (!follow.containsKey(followerId)) {
            follow.put(followerId, new HashSet<>());
        }
        follow.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (follow.containsKey(followerId)) {
            follow.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        TestCases tests = new TestCases();
        tests.test1();
        tests.test2();
        tests.test3();
        tests.test4();
    }
}
