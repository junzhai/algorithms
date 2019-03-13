package com.leetcode.algorithms.premium.zigzagIterator_281;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetocode: Zigzag Iterator
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * For example, given two 1d vectors:
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3,
 * 2, 4, 5, 6].
 * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 */
public class ZigzagIterator {
    private final int count;
    private final int[] index;
    private final List<List<Integer>> vals = new ArrayList<>();
    private int p = 0, finished = 0;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        count = 2;
        index = new int[count];
        vals.add(v1);
        vals.add(v2);
    }

    public int next() {
        while (index[p] < 0) {
            p = (p + 1) % count;
        }
        int ret = vals.get(p).get(index[p]);
        index[p] += 1;
        if (index[p] == vals.get(p).size()) {
            index[p] = -1;
            finished += 1;
        }

        p = (p + 1) % count;
        return ret;
    }

    public boolean hasNext() {
        return finished != count;
    }

    public static void main(String[] args) {
        ZigzagIterator it = new ZigzagIterator(Arrays.asList(1, 2), Arrays.asList(3, 4, 5, 6));
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
