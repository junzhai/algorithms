package com.leetcode.algorithms.minimumAreaRectangleII_963;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public double minAreaFreeRect(int[][] points) {
        int[][] ds = buildDist(points);
        int len = points.length;
        double ret = Double.MAX_VALUE;
        for (int i = 0; i < len - 3; i++) {
            Integer[] pos = new Integer[len - i - 1];
            for (int j = i + 1; j < len; j++) {
                pos[j - i - 1] = j;
            }
            final int o = i;
            Arrays.sort(pos, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return ds[o][o1] - ds[o][o2];
                }
            });
            ret = Math.min(ret, cal(i, pos, ds));
        }
        return ret == Double.MAX_VALUE ? 0 : ret;
    }

    private int[][] buildDist(int[][] points) {
        int len = points.length;
        int[][] ret = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int d = dist(points[i], points[j]);
                ret[i][j] = d;
                ret[j][i] = d;
            }
        }
        return ret;
    }

    private int dist(int[] s, int[] t) {
        int x = s[0] - t[0], y = s[1] - t[1];
        return x * x + y * y;
    }

    private double cal(int index, Integer[] pos, int[][] ds) {
        double ret = Double.MAX_VALUE;
        int len = pos.length;
        for (int i = len - 1; i > 1; i--) {
            int l = 0, r = i - 1, target = ds[index][pos[i]];
            while (l < r) {
                int lv = ds[index][pos[l]], rv = ds[index][pos[r]], s = lv + rv;
                if (s > target) {
                    r -= 1;
                } else if (s < target) {
                    l += 1;
                } else {
                    int ll = l, rr = r;
                    for (ll = l; ds[index][pos[ll]] == lv && ll < r; ll++) {
                        for (rr = r; ds[index][pos[rr]] == rv && rr > ll; rr--) {
                            if (ds[pos[ll]][pos[rr]] == target && ds[pos[ll]][pos[i]] + ds[pos[rr]][pos[i]] == target) {
                                ret = Math.min(ret, Math.sqrt(ds[index][pos[ll]]) * Math.sqrt(ds[index][pos[rr]]));
                            }
                        }
                    }
                    l = ll;
                    r = rr;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        double diff = Math.pow(10, -5);
        Solution s = new Solution();
        double ret;

        ret = s.minAreaFreeRect(new int[][]{{0, 2}, {1, 0}, {2, 3}, {1, 2}, {1, 3}, {2, 2}, {3, 3}, {2, 1}});
        Assert.assertEquals(1.0, ret, 0.0);

        ret = s.minAreaFreeRect(new int[][]{{3, 1}, {1, 1}, {0, 1}, {2, 1}, {3, 3}, {3, 2}, {0, 2}, {2, 3}});
        Assert.assertEquals(2.0, ret, 0.0);

        ret = s.minAreaFreeRect(new int[][]{{0, 3}, {1, 2}, {3, 1}, {1, 3}, {2, 1}});
        Assert.assertEquals(0.0, ret, 0.0);

        ret = s.minAreaFreeRect(new int[][]{{0, 1}, {2, 1}, {1, 1}, {1, 0}, {2, 0}});
        Assert.assertEquals(1.0, ret, 0.0);

        ret = s.minAreaFreeRect(new int[][]{{1, 2}, {2, 1}, {1, 0}, {0, 1}});
        Assert.assertEquals(2.0, ret, diff);
    }
}
