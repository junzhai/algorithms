package com.leetcode.algorithms.largestComponentSizebyCommonFactor_952;

import com.leetcode.algorithms.common.LargeCaseUtil;
import org.junit.Assert;

public class Solution {
    public int largestComponentSize(int[] A) {
        int[] parent = new int[100000], count = new int[100000];
        int ret = 0;
        for (int a : A) {
            int f = 0;
            if (a % 2 == 0) {
                while (a % 2 == 0) {
                    a /= 2;
                }
                f = 2;
            }

            for (int i = 3; i <= Math.sqrt(a); i += 2) {
                if (a % i == 0) {
                    while (a % i == 0) {
                        a /= i;
                    }
                    int cf = i;
                    while (parent[cf] != 0) {
                        cf = parent[cf];
                    }

                    if (f == 0) {
                        f = cf;
                    } else if (f < cf) {
                        parent[cf] = f;
                        count[f] += count[cf];
                        count[cf] = 0;
                    } else if (f > cf) {
                        parent[f] = cf;
                        count[cf] += count[f];
                        count[f] = 0;
                        f = cf;
                    }
                }
            }

            if (a > 1) {
                int cf = a;
                while (parent[cf] != 0) {
                    cf = parent[cf];
                }

                if (f == 0) {
                    f = cf;
                } else if (f < cf) {
                    parent[cf] = f;
                    count[f] += count[cf];
                    count[cf] = 0;
                } else if (f > cf) {
                    parent[f] = cf;
                    count[cf] += count[f];
                    count[f] = 0;
                    f = cf;
                }
            }

            count[f] += 1;
            ret = Math.max(ret, count[f]);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = LargeCaseUtil.readArray("src/com/leetcode/algorithms/largestComponentSizebyCommonFactor_952/case1");
        int ret = s.largestComponentSize(input);
        Assert.assertEquals(4878, ret);
    }
}
