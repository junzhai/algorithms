package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class Node {
        int key, val;
        Node pre, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private Node h, t;
    private Map<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    private void move2Top(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;
            if (n.next != null) {
                n.next.pre = n.pre;
            } else {
                t = n.pre;
            }
            n.next = h;
            h.pre = n;
            n.pre = null;
            h = n;
        }
    }

    public int get(int key) {
        Node n = cache.get(key);
        if (n == null) {
            return -1;
        }

        move2Top(n);
        return n.val;
    }

    public void put(int key, int value) {
        Node n = cache.get(key);
        if (n == null) {
            n = new Node(key, value);
            cache.put(key, n);
            n.next = h;
            if (h == null) {
                t = n;
            } else {
                h.pre = n;
            }
            h = n;

            if (cache.size() > capacity) {
                cache.remove(t.key);
                t = t.pre;
                t.next = null;
            }
            return;
        }

        n.val = value;
        move2Top(n);
    }

    public static void main(String[] args) {
        LRUCache c = new LRUCache(2);
        c.put(1, 1);
        c.put(2, 2);
        org.junit.Assert.assertEquals(c.get(1), 1);
        c.put(3, 3);
        org.junit.Assert.assertEquals(c.get(2), -1);
        c.put(4, 4);
        org.junit.Assert.assertEquals(c.get(1), -1);
        org.junit.Assert.assertEquals(c.get(3), 3);
        org.junit.Assert.assertEquals(c.get(4), 4);
    }
}
