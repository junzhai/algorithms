package com.leetcode.algorithms.largestTimeforGivenDigits_949;

import org.junit.Assert;

public class Solution {
    public String largestTimeFromDigits(int[] A) {
        boolean[] used = new boolean[4];
        int max = -1;
        String ret = "";
        for (int a = 0; a < 4; a++) {
            if (A[a] >= 3) {
                continue;
            }
            used[a] = true;
            for (int b = 0; b < 4; b++) {
                if (used[b] || A[a] == 2 && A[b] >= 4) {
                    continue;
                }
                used[b] = true;
                for (int c = 0; c < 4; c++) {
                    if (used[c] || A[c] >= 6) {
                        continue;
                    }
                    used[c] = true;
                    for (int d = 0; d < 4; d++) {
                        if (used[d]) {
                            continue;
                        }
                        int t = (A[a] * 10 + A[b]) * 60 + A[c] * 10 + A[d];
                        if (t > max) {
                            max = t;
                            ret = A[a] + "" + A[b] + ":" + A[c] + A[d];
                        }
                    }
                    used[c] = false;
                }
                used[b] = false;
            }
            used[a] = false;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ret;
        ret = s.largestTimeFromDigits(new int[]{1, 2, 3, 4});
        Assert.assertEquals("23:41", ret);
    }
}
