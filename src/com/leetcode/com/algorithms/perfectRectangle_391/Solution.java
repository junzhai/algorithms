package com.leetcode.com.algorithms.perfectRectangle_391;

import org.junit.Assert;

abstract public class Solution {
    abstract public boolean isRectangleCover(final int[][] rectangles);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
//                new ScanOneDimension(),
//                new AreaCornorBoundary(),
                new CornerOnly(),
        };

        boolean ret;
        for (Solution s : solutions) {

            ret = s.isRectangleCover(new int[][]{
                    {0, 0, 1, 1},
                    {0, 2, 1, 3},
                    {1, 1, 2, 2},
                    {2, 0, 3, 1},
                    {2, 2, 3, 3},
                    {1, 0, 2, 3},
                    {0, 1, 3, 2}
            });
            Assert.assertFalse(ret);

            ret = s.isRectangleCover(new int[][]{
                    {0, 0, 1, 1},
                    {0, 1, 1, 2},
                    {0, 2, 1, 3},
                    {1, 0, 2, 1},
                    {1, 0, 2, 1},
                    {1, 2, 2, 3},
                    {2, 0, 3, 1},
                    {2, 1, 3, 2},
                    {2, 2, 3, 3}
            });
            Assert.assertFalse(ret);

            ret = s.isRectangleCover(new int[][]{
                    {0, 0, 1, 1},
                    {0, 0, 2, 1},
                    {1, 0, 2, 1},
                    {0, 2, 2, 3}
            });
            Assert.assertFalse(ret);

            ret = s.isRectangleCover(new int[][]{
                    {0, 0, 3, 3},
                    {1, 1, 2, 2},
                    {1, 1, 2, 2}
            });
            Assert.assertFalse(ret);

            ret = s.isRectangleCover(new int[][]{
                    {0, 0, 1, 1},
                    {0, 1, 3, 2},
                    {1, 0, 2, 2}
            });
            Assert.assertFalse(ret);

            ret = s.isRectangleCover(new int[][]{
                    {0, 0, 1, 1},
                    {0, 1, 3, 2},
                    {1, 0, 2, 2}
            });
            Assert.assertFalse(ret);

            ret = s.isRectangleCover(new int[][]{
                    {0, 0, 4, 1},
                    {7, 0, 8, 2},
                    {6, 2, 8, 3},
                    {5, 1, 6, 3},
                    {4, 0, 5, 1},
                    {6, 0, 7, 2},
                    {4, 2, 5, 3},
                    {2, 1, 4, 3},
                    {0, 1, 2, 2},
                    {0, 2, 2, 3},
                    {4, 1, 5, 2},
                    {5, 0, 6, 1}
            });
            Assert.assertTrue(ret);

            ret = s.isRectangleCover(new int[][]{
                    {0, 0, 4, 1},
                    {7, 0, 8, 2},
                    {5, 1, 6, 3},
                    {6, 0, 7, 2},
                    {4, 0, 5, 1},
                    {4, 2, 5, 3},
                    {2, 1, 4, 3},
                    {-1, 2, 2, 3},
                    {0, 1, 2, 2},
                    {6, 2, 8, 3},
                    {5, 0, 6, 1},
                    {4, 1, 5, 2}
            });
            Assert.assertFalse(ret);

            ret = s.isRectangleCover(new int[][]{
                    {1, 1, 3, 3},
                    {3, 1, 4, 2},
                    {3, 2, 4, 4},
                    {1, 3, 2, 4},
                    {2, 3, 3, 4}
            });
            Assert.assertTrue(ret);

            ret = s.isRectangleCover(new int[][]{
                    {1, 1, 2, 3},
                    {1, 3, 2, 4},
                    {3, 1, 4, 2},
                    {3, 2, 4, 4}
            });
            Assert.assertFalse(ret);

            ret = s.isRectangleCover(new int[][]{
                    {1, 1, 3, 3},
                    {3, 1, 4, 2},
                    {1, 3, 2, 4},
                    {3, 2, 4, 4}
            });
            Assert.assertFalse(ret);

            ret = s.isRectangleCover(new int[][]{
                    {1, 1, 3, 3},
                    {3, 1, 4, 2},
                    {1, 3, 2, 4},
                    {2, 2, 4, 4}
            });
            Assert.assertFalse(ret);

            ret = s.isRectangleCover(new int[][]{{0, 0, 4, 1}, {0, 0, 4, 1}});
            Assert.assertFalse(ret);
        }
    }
}
