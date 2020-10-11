package com.leetcode.algorithms.premium.lineReflecton_356;

import org.junit.Assert;

/**
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflects the given points.
 * <p>
 * Example 1:
 * Given points = [[1,1],[-1,1]], return true.
 * Example 2:
 * Given points = [[1,1],[-1,-1]], return false.
 * <p>
 * Follow up:
 * Could you do better than O(n2)?
 */
public abstract class Solution {
    abstract public boolean isReflected(int[][] points);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new Sort(),
                new NoSort()
        };

        for (Solution s : solutions) {
            boolean ret = s.isReflected(new int[][]{{1, 1}, {-1, 1}});
            Assert.assertEquals(true, ret);

            ret = s.isReflected(new int[][]{{1, 1}, {-1, -1}});
            Assert.assertEquals(false, ret);
        }
    }
}
