package com.leetcode.algorithms.cutOffTreesforGolfEvent_675;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS extends Solution {
    @Override
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest.get(0).get(0) == 0) {
            return -1;
        }

        int row = forest.size(), col = forest.get(0).size(), count = 0;

        int[][] order = new int[row * col][2];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                count += forest.get(i).get(j) == 0 ? 0 : 1;
                order[i * col + j] = new int[]{i, j};
            }
        }

        Arrays.sort(order, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int v1 = forest.get(o1[0]).get(o1[1]), v2 = forest.get(o2[0]).get(o2[1]);
                if (v1 == v2) {
                    return 0;
                }
                if (v1 == 0) {
                    return 1;
                }
                if (v2 == 0) {
                    return -1;
                }
                return v1 - v2;
            }
        });

        int[][] dist = new int[row][col];
        Queue<int[]> q = new LinkedList<>();

        if (forest.get(0).get(0) > 0) {
            q.offer(new int[]{0, 0});
        }

        int target = 0, s0 = 0, s1 = 0, ret = 0;
        while (!q.isEmpty() && target < count) {
            int[] p = q.poll();
            int r = p[0], c = p[1];

            if (r == order[target][0] && c == order[target][1]) {
                ret += dist[r][c];
                dist = new int[row][col];
                s0 = r;
                s1 = c;
                target += 1;
                q.clear();
                q.offer(p);
                continue;
            }

            if (r > 0 && (r - 1 != s0 || c != s1) && forest.get(r - 1).get(c) > 0 && dist[r - 1][c] == 0) {
                dist[r - 1][c] = dist[r][c] + 1;
                q.offer(new int[]{r - 1, c});
            }
            if (c + 1 < col && (r != s0 || c + 1 != s1) && forest.get(r).get(c + 1) > 0 && dist[r][c + 1] == 0) {
                dist[r][c + 1] = dist[r][c] + 1;
                q.offer(new int[]{r, c + 1});
            }
            if (r + 1 < row && (r + 1 != s0 || c != s1) && forest.get(r + 1).get(c) > 0 && dist[r + 1][c] == 0) {
                dist[r + 1][c] = dist[r][c] + 1;
                q.offer(new int[]{r + 1, c});
            }
            if (c > 0 && (r != s0 || c - 1 != s1) && forest.get(r).get(c - 1) > 0 && dist[r][c - 1] == 0) {
                dist[r][c - 1] = dist[r][c] + 1;
                q.offer(new int[]{r, c - 1});
            }
        }

        return target != count ? -1 : ret;
    }
}
