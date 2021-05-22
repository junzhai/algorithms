package com.leetcode.algorithms.escapeaLargeMaze_1036;

import com.pattern.algorithms.DP;

import java.util.Arrays;
import java.util.Comparator;

@DP
public class UseDP extends Solution {
    @Override
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int len = blocked.length;
        if (len == 0) {
            return true;
        }

        Arrays.sort(blocked, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int r = o1[1] - o2[1];
                if (r == 0) {
                    r = o1[0] - o2[0];
                }
                return r;
            }
        });

        int l = 0, s = 0;
        int[] bc = new int[len + 2];
        int[][] br = new int[len + 2][0];
        if (blocked[0][1] > 0) {
            bc[0] = blocked[0][1] - 1;
            br[0] = new int[]{-1};
            l += 1;
        }
        for (int i = 0, cur = blocked[0][1]; i < len; i++) {
            if (blocked[i][1] != cur) {
                bc[l] = blocked[s][1];
                br[l] = new int[i - s + 1];
                br[l][0] = -1;
                for (int j = s; j < i; j++) {
                    br[l][j - s + 1] = blocked[j][0];
                }
                cur = blocked[i][1];
                s = i;
                l += 1;
            }
        }

        bc[l] = blocked[s][1];
        br[l] = new int[len - s + 1];
        br[l][0] = -1;
        for (int j = s; j < len; j++) {
            br[l][j - s + 1] = blocked[j][0];
        }
        l += 1;

        if (bc[l - 1] + 1 < 1000000) {
            bc[l] = bc[l - 1] + 1;
            br[l] = new int[]{-1};
            l += 1;
        }

        int[] srcPath = calReachability(bc, br, l, source), targetPath = calReachability(bc, br, l, target);
        for (int i = 0; i < l; i++) {
            if ((srcPath[i] & targetPath[i]) > 0) {
                return true;
            }
        }

        return false;
    }

    private int[] calReachability(int[] blockerCols, int[][] blockerRows, int len, int[] position) {
        int p = Arrays.binarySearch(blockerCols, 0, len, position[1]);
        p = p < 0 ? -p - 1 : p;

        int[] ret = new int[len];
        for (int i = p; i < len; i++) {
            int[] r = blockerRows[i];
            if (blockerCols[i] == position[1]) {
                int m = 1;
                for (int j = 1; j < r.length; j++, m <<= 1) {
                    if (position[0] < blockerRows[i][j]) {
                        break;
                    }
                }
                ret[i] = m;
                continue;
            }

            if (i == 0 || blockerCols[i] > blockerCols[i - 1] + 1) {
                ret[i] = (1 << r.length) - 1;
                continue;
            }

            int m = 1;
            for (int j = 1; j < r.length; j++, m <<= 1) {
                if (reach(r[j - 1], r[j], blockerRows[i - 1], ret[i - 1])) {
                    ret[i] += m;
                }
            }
            if (reach(r[r.length - 1], 1000000, blockerRows[i - 1], ret[i - 1])) {
                ret[i] += m;
            }

            if (ret[i] == 0) {
                break;
            }
        }

        for (int i = p - 1; i >= 0; i--) {
            int[] r = blockerRows[i];
            if (i == len - 1 || blockerCols[i] + 1 < blockerCols[i + 1]) {
                ret[i] = (1 << r.length) - 1;
                continue;
            }

            int m = 1;
            for (int j = 1; j < r.length; j++, m <<= 1) {
                if (reach(r[j - 1], r[j], blockerRows[i + 1], ret[i + 1])) {
                    ret[i] += m;
                }
            }
            if (reach(r[r.length - 1], 1000000, blockerRows[i + 1], ret[i + 1])) {
                ret[i] += m;
            }

            if (ret[i] == 0) {
                break;
            }
        }

        return ret;
    }

    private boolean reach(int b, int e, int[] rows, int path) {
        if (e - b < 2) {
            return false;
        }

        b += 1;
        e -= 1;
        boolean ret = false;
        int m = 1;
        for (int i = 1; i < rows.length; i++, m <<= 1) {
            if (overlap(b, e, rows[i - 1] + 1, rows[i] - 1)) {
                ret |= (path & m) > 0;
            }
        }
        if (overlap(b, e, rows[rows.length - 1] + 1, 999999)) {
            ret |= (path & m) > 0;
        }

        return ret;
    }

    private boolean overlap(int a, int b, int c, int d) {
        return b >= c && d >= a;
    }
}
