package com.leetcode.algorithms.tripleswithBitwiseANDEqualToZero_982;

public class BruteForce extends Solution {
    @Override
    public int countTriplets(int[] A) {
        int ret = 0, len = A.length;
        for (int i = 0; i < len; i++) {
            if (A[i] == 0) {
                ret += 1;
                int c = len - i - 1;
                ret += c * (c + 1) * 3;
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                int m = A[i] & A[j];
                if (m == 0) {
                    ret += (len - j) * 6;
                    continue;
                }
                for (int k = j + 1; k < len; k++) {
                    if ((m & A[k]) == 0) {
                        ret += 6;
                    }
                }
            }
        }
        return ret;
    }
}
