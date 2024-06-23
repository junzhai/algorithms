package com.hackerrank.emasSupercomputer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Result {
    public static int twoPluses(List<String> grid) {
        int row = grid.size(), col = grid.get(0).length();
        int[][] buf = new int[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                buf[r][c] = Math.max(row, col) + 1;
            }
        }

        for (int r = 0; r < row; r++) {
            String rr = grid.get(r);
            for (int c = 0, s = 0; c < col; c++) {
                s = rr.charAt(c) == 'G' ? s + 1 : 0;
                buf[r][c] = Math.min(buf[r][c], s);
            }
            for (int c = col - 1, s = 0; c >= 0; c--) {
                s = rr.charAt(c) == 'G' ? s + 1 : 0;
                buf[r][c] = Math.min(buf[r][c], s);
            }
        }

        for (int c = 0; c < col; c++) {
            for (int r = 0, s = 0; r < row; r++) {
                s = grid.get(r).charAt(c) == 'G' ? s + 1 : 0;
                buf[r][c] = Math.min(buf[r][c], s);
            }
            for (int r = row - 1, s = 0; r >= 0; r--) {
                s = grid.get(r).charAt(c) == 'G' ? s + 1 : 0;
                buf[r][c] = Math.min(buf[r][c], s);
            }
        }

        int len = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                len += buf[r][c];
            }
        }

        int[][] buf1 = new int[len][3];
        int idx = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                for (int n = buf[r][c]; n > 0; n--) {
                    buf1[idx][0] = n;
                    buf1[idx][1] = r;
                    buf1[idx][2] = c;
                    idx += 1;
                }
            }
        }

        Arrays.sort(buf1, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });

        int ret = 0;
        boolean[][] cache = new boolean[row][col];
        for (int i = 0; i < len; i++) {
            if (buf1[i][0] == 0) {
                break;
            }
            for (int r = buf1[i][1] - buf1[i][0] + 1; r <= buf1[i][1] + buf1[i][0] - 1; r++) {
                cache[r][buf1[i][2]] = true;
            }
            for (int c = buf1[i][2] - buf1[i][0] + 1; c <= buf1[i][2] + buf1[i][0] - 1; c++) {
                cache[buf1[i][1]][c] = true;
            }
            int max1 = 4 * (buf1[i][0] - 1) + 1;

            for (int j = i + 1; j < len; j++) {
                boolean overlap = false;
                for (int r = buf1[j][1] - buf1[j][0] + 1; r <= buf1[j][1] + buf1[j][0] - 1; r++) {
                    if (cache[r][buf1[j][2]]) {
                        overlap = true;
                        break;
                    }
                }
                if (overlap) {
                    continue;
                }
                for (int c = buf1[j][2] - buf1[j][0] + 1; c <= buf1[j][2] + buf1[j][0] - 1; c++) {
                    if (cache[buf1[j][1]][c]) {
                        overlap = true;
                        break;
                    }
                }
                if (overlap) {
                    continue;
                }

                int max2 = 4 * (buf1[j][0] - 1) + 1;
                ret = Math.max(ret, max1 * max2);
                break;
            }

            for (int r = buf1[i][1] - buf1[i][0] + 1; r <= buf1[i][1] + buf1[i][0] - 1; r++) {
                cache[r][buf1[i][2]] = false;
            }
            for (int c = buf1[i][2] - buf1[i][0] + 1; c <= buf1[i][2] + buf1[i][0] - 1; c++) {
                cache[buf1[i][1]][c] = false;
            }
        }

        return ret;
    }
}