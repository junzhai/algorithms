package com.leetcode.premium.lineReflecton_356;

import java.util.Arrays;
import java.util.Comparator;

public class Sort extends Solution {
    @Override
    public boolean isReflected(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                int ret = p1[1] - p2[1];
                if (ret == 0) {
                    ret = p1[0] - p2[0];
                }
                return ret;
            }
        });

        int m = 0;
        boolean found = false;
        for (int i = 0, b = 0, y = points[0][1]; i < points.length; i++) {
            if (points[i][1] != y) {
                if ((i - b) % 2 != 0) {
                    return false;
                }
                int e = i - 1;
                while (b < e) {
                    if (found) {
                        if (points[b][0] + points[e][0] != m) {
                            return false;
                        }
                    } else {
                        m = points[b][0] + points[e][0];
                        found = true;
                    }
                    b += 1;
                    e -= 1;
                }

                b = i;
                y = points[i][1];
            }
        }
        return true;
    }
}
