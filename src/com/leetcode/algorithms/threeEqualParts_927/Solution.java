package com.leetcode.algorithms.threeEqualParts_927;

import org.junit.Assert;

public class Solution {
    public int[] threeEqualParts(int[] A) {
        int count = 0;
        for (int a : A) {
            if (a == 1) {
                count += 1;
            }
        }

        if (count == 0) {
            return new int[]{0, 2};
        }

        if (count % 3 != 0) {
            return new int[]{-1, -1};
        }

        int p1 = count / 3, p2 = p1 << 1, zero0 = 0, zero1 = 0, zero2 = 0, index1 = 0, index2 = 0;
        for (int i = A.length - 1, seq = 0, c = 0; i >= 0; i--) {
            if (A[i] == 0) {
                c += 1;
                continue;
            }

            if (seq == 0) {
                zero0 = c;
            } else if (seq == p1) {
                zero1 = c;
                index1 = i;
            } else if (seq == p2) {
                zero2 = c;
                index2 = i;
            }
            seq += 1;
            c = 0;
        }

        if (zero2 < zero0 || zero1 < zero0) {
            return new int[]{-1, -1};
        }

        int i0 = A.length - 1, i1 = index1 + zero0, i2 = index2 + zero0;
        for (; i0 > index1 + zero0 && i1 > index2 + zero0 && i2 >= 0; i0--, i1--, i2--) {
            if (A[i0] != A[i1] || A[i1] != A[i2]) {
                return new int[]{-1, -1};
            }
        }

        for (int i = i0; i > index1 + zero0; i--) {
            if (A[i] != 0) {
                return new int[]{-1, -1};
            }
        }

        for (int i = i1; i > index2 + zero0; i--) {
            if (A[i] != 0) {
                return new int[]{-1, -1};
            }
        }
        for (int i = i2; i >= 0; i--) {
            if (A[i] != 0) {
                return new int[]{-1, -1};
            }
        }

        return new int[]{index2 + zero0, index1 + zero0 + 1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ret;

        ret = s.threeEqualParts(new int[]{0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0});
        Assert.assertArrayEquals(new int[]{-1, -1}, ret);

        ret = s.threeEqualParts(new int[]{1, 1, 0, 0, 1});
        Assert.assertArrayEquals(new int[]{0, 2}, ret);
    }
}
