package com.leetcode.algorithms.escapeaLargeMaze_1036;

import com.leetcode.algorithms.pattern.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

@BFS
public class UseBFS extends Solution {
    @Override
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> b = new HashSet<>();
        for (int[] p : blocked) {
            b.add(p[0] * 1000000L + p[1]);
        }

        int len = blocked.length, maxArea = len * (len - 1) / 2;
        long src = source[0] * 1000000L + source[1], tar = target[0] * 1000000L + target[1], last = 1000000000000L;
        Set<Long> visited = new HashSet<>();
        Queue<Long> q = new LinkedList<>();
        q.offer(src);
        visited.add(src);

        while (visited.size() <= maxArea && !q.isEmpty()) {
            long v = q.poll(), y = v % 1000000, n = v - 1000000;
            if (n == tar) {
                return true;
            }
            if (n >= 0 && !b.contains(n) && !visited.contains(n)) {
                q.offer(n);
                visited.add(n);
            }

            if (y + 1 < 1000000) {
                n = v + 1;
                if (n == tar) {
                    return true;
                }
                if (!b.contains(n) && !visited.contains(n)) {
                    q.offer(n);
                    visited.add(n);
                }
            }

            n = v + 1000000;
            if (n == tar) {
                return true;
            }
            if (n < last && !b.contains(n) && !visited.contains(n)) {
                q.offer(n);
                visited.add(n);
            }

            if (y > 0) {
                n = v - 1;
                if (n == tar) {
                    return true;
                }
                if (!b.contains(n) && !visited.contains(n)) {
                    q.offer(n);
                    visited.add(n);
                }
            }
        }

        if (q.isEmpty()) {
            return false;
        }

        visited.clear();
        q.clear();
        q.offer(tar);
        visited.add(tar);

        while (visited.size() <= maxArea && !q.isEmpty()) {
            long v = q.poll(), y = v % 1000000, n = v - 1000000;
            if (n == src) {
                return true;
            }
            if (n >= 0 && !b.contains(n) && !visited.contains(n)) {
                q.offer(n);
                visited.add(n);
            }

            if (y + 1 < 1000000) {
                n = v + 1;
                if (n == src) {
                    return true;
                }
                if (!b.contains(n) && !visited.contains(n)) {
                    q.offer(n);
                    visited.add(n);
                }
            }

            n = v + 1000000;
            if (n == src) {
                return true;
            }
            if (n < last && !b.contains(n) && !visited.contains(n)) {
                q.offer(n);
                visited.add(n);
            }

            if (y > 0) {
                n = v - 1;
                if (n == src) {
                    return true;
                }
                if (n >= 0 && !b.contains(n) && !visited.contains(n)) {
                    q.offer(n);
                    visited.add(n);
                }
            }
        }

        return !q.isEmpty();
    }
}
