package com.leetcode.com.leetcode.Sliding_Window_Median;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    private Solution solution;

    @Before
    public void before() {
        solution = new Solution();
    }

    @Test
    public void test1() {
        assertArrayEquals(solution.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3),
                new double[]{1.0, -1.0, -1.0, 3.0, 5.0, 6.0}, 0);
    }

    @Test
    public void test2() {
        assertArrayEquals(solution.medianSlidingWindow(new int[]{1, 4, 2, 3}, 4),
                new double[]{2.5}, 0);
    }

    @Test
    public void test3() {
        assertArrayEquals(solution.medianSlidingWindow(new int[]{2147483647, 2147483647}, 2),
                new double[]{2147483647.0}, 0);
    }

    @Test
    public void test4() {
        assertArrayEquals(solution.medianSlidingWindow(new int[]{1, 2}, 1),
                new double[]{1.0, 2.0}, 0);
    }
}
