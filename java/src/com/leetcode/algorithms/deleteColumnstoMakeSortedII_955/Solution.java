package com.leetcode.algorithms.deleteColumnstoMakeSortedII_955;

import org.junit.Assert;

public class Solution {
    public int minDeletionSize(String[] A) {
        int len = A.length;
        if (len < 2) {
            return 0;
        }

        int w = A[0].length(), ret = 0, l = 1;
        int[][] r0 = new int[len / 2][0], r1 = new int[len / 2][0];
        r0[0] = new int[]{0, len};

        for (int i = 0; i < w; i++) {
            int nl = 0;
            boolean removed = false;
            a:
            for (int j = 0; j < l; j++) {
                int b = r0[j][0];
                for (int k = r0[j][0] + 1; k < r0[j][1]; k++) {
                    if (A[k].charAt(i) > A[k - 1].charAt(i)) {
                        if (k - b > 1) {
                            r1[nl++] = new int[]{b, k};
                        }
                        b = k;
                    } else if (A[k].charAt(i) < A[k - 1].charAt(i)) {
                        ret += 1;
                        removed = true;
                        break a;
                    }
                }
                if (r0[j][1] - b > 1) {
                    r1[nl++] = new int[]{b, r0[j][1]};
                }
            }


            if (!removed) {
                int[][] tmp = r0;
                r0 = r1;
                r1 = tmp;
                l = nl;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;

        ret = s.minDeletionSize(new String[]{"abx", "agz", "bgc", "bfc"});
        Assert.assertEquals(1, ret);

        ret = s.minDeletionSize(new String[]{"xga", "xfb", "yfa"});
        Assert.assertEquals(1, ret);
    }
}
