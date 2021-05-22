package com.leetcode.algorithms.rectangleAreaII_850;

import com.pattern.algorithms.SegmentOrAreaOrKDTree;

@SegmentOrAreaOrKDTree
public class UsingAreaTree extends Solution {
    private class AreaNode {
        int x0, y0, x1, y1;
        AreaNode[] children = new AreaNode[8];

        AreaNode(int x0, int y0, int x1, int y1) {
            this.x0 = x0;
            this.y0 = y0;
            this.x1 = x1;
            this.y1 = y1;
        }
    }

    @Override
    public int rectangleArea(int[][] rectangles) {
        int len = rectangles.length, m = (int) Math.pow(10, 9) + 7;
        AreaNode root = new AreaNode(rectangles[0][0], rectangles[0][1], rectangles[0][2], rectangles[0][3]);
        long ret = (long) (rectangles[0][2] - rectangles[0][0]) * (rectangles[0][3] - rectangles[0][1]);
        for (int i = 1; i < len; i++) {
            int[] r = rectangles[i];
            ret += addArea(root, r[0], r[1], r[2], r[3]);
        }
        return (int) (ret % m);
    }

    private long addArea(AreaNode p, int x0, int y0, int x1, int y1) {
        long ret = 0L;
        int xx0, yy0, xx1, yy1;
        if (p.x0 > x0 && p.y1 < y1) {
            xx0 = x0;
            yy0 = Math.max(y0, p.y1);
            xx1 = Math.min(x1, p.x0);
            yy1 = y1;
            if (p.children[0] == null) {
                ret += (long) (xx1 - xx0) * (yy1 - yy0);
                p.children[0] = new AreaNode(xx0, yy0, xx1, yy1);
            } else {
                ret += addArea(p.children[0], xx0, yy0, xx1, yy1);
            }
        }

        if (p.x0 < x1 && p.x1 > x0 && p.y1 < y1) {
            xx0 = Math.max(x0, p.x0);
            yy0 = Math.max(y0, p.y1);
            xx1 = Math.min(x1, p.x1);
            yy1 = y1;
            if (p.children[1] == null) {
                ret += (long) (xx1 - xx0) * (yy1 - yy0);
                p.children[1] = new AreaNode(xx0, yy0, xx1, yy1);
            } else {
                ret += addArea(p.children[1], xx0, yy0, xx1, yy1);
            }
        }

        if (p.x1 < x1 && p.y1 < y1) {
            xx0 = Math.max(x0, p.x1);
            yy0 = Math.max(y0, p.y1);
            xx1 = x1;
            yy1 = y1;
            if (p.children[2] == null) {
                ret += (long) (xx1 - xx0) * (yy1 - yy0);
                p.children[2] = new AreaNode(xx0, yy0, xx1, yy1);
            } else {
                ret += addArea(p.children[2], xx0, yy0, xx1, yy1);
            }
        }

        if (p.x1 < x1 && p.y1 > y0 && p.y0 < y1) {
            xx0 = Math.max(x0, p.x1);
            yy0 = Math.max(y0, p.y0);
            xx1 = x1;
            yy1 = Math.min(y1, p.y1);
            if (p.children[3] == null) {
                ret += (long) (xx1 - xx0) * (yy1 - yy0);
                p.children[3] = new AreaNode(xx0, yy0, xx1, yy1);
            } else {
                ret += addArea(p.children[3], xx0, yy0, xx1, yy1);
            }
        }

        if (p.x1 < x1 && p.y0 > y0) {
            xx0 = Math.max(x0, p.x1);
            yy0 = y0;
            xx1 = x1;
            yy1 = Math.min(y1, p.y0);
            if (p.children[4] == null) {
                ret += (long) (xx1 - xx0) * (yy1 - yy0);
                p.children[4] = new AreaNode(xx0, yy0, xx1, yy1);
            } else {
                ret += addArea(p.children[4], xx0, yy0, xx1, yy1);
            }
        }

        if (p.x0 < x1 && p.x1 > x0 && p.y0 > y0) {
            xx0 = Math.max(x0, p.x0);
            yy0 = y0;
            xx1 = Math.min(x1, p.x1);
            yy1 = Math.min(y1, p.y0);
            if (p.children[5] == null) {
                ret += (long) (xx1 - xx0) * (yy1 - yy0);
                p.children[5] = new AreaNode(xx0, yy0, xx1, yy1);
            } else {
                ret += addArea(p.children[5], xx0, yy0, xx1, yy1);
            }
        }

        if (p.x0 > x0 && p.y0 > y0) {
            xx0 = x0;
            yy0 = y0;
            xx1 = Math.min(x1, p.x0);
            yy1 = Math.min(y1, p.y0);
            if (p.children[6] == null) {
                ret += (long) (xx1 - xx0) * (yy1 - yy0);
                p.children[6] = new AreaNode(xx0, yy0, xx1, yy1);
            } else {
                ret += addArea(p.children[6], xx0, yy0, xx1, yy1);
            }
        }

        if (p.x0 > x0 && p.y0 < y1 && p.y1 > y0) {
            xx0 = x0;
            yy0 = Math.max(y0, p.y0);
            xx1 = Math.min(x1, p.x0);
            yy1 = Math.min(y1, p.y1);
            if (p.children[7] == null) {
                ret += (long) (xx1 - xx0) * (yy1 - yy0);
                p.children[7] = new AreaNode(xx0, yy0, xx1, yy1);
            } else {
                ret += addArea(p.children[7], xx0, yy0, xx1, yy1);
            }
        }
        return ret;
    }
}
