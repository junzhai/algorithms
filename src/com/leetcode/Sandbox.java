package com.leetcode;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

public class Sandbox {
    public boolean isBipartite(int[][] graph) {
        int[] nodes = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != 0) {
                continue;
            }

            nodes[i] = 1;
            q.offer(i);
            while (!q.isEmpty()) {
                int n = q.poll(), c = nodes[n] == 1 ? 2 : 1;
                for (int child : graph[n]) {
                    if (nodes[child] == 0) {
                        nodes[child] = c;
                        q.offer(child);
                    }
                    if (nodes[child] != c) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Sandbox s = new Sandbox();
        boolean ret;

        ret = s.isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}});
        Assert.assertEquals(false, ret);
    }
}