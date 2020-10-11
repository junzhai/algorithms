package com.leetcode.algorithms.countofSmallerNumbersAfterSelf_315;

import com.leetcode.algorithms.pattern.MergeSort;

import java.util.ArrayList;
import java.util.List;

@MergeSort
public class Merge extends Solution {
    @Override
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length, rlen = 0;
        int[][] range = new int[len / 2 + 1][2], newRange = new int[len / 2 + 1][2];
        int[] src = new int[len], dest = new int[len];
        int[] count = new int[len];

        int state = 0, b = 0;
        for (int i = 1; i < len; i++) {
            src[i] = i;
            switch (state) {
                case 0:
                    if (nums[i] > nums[i - 1]) {
                        state = 1;
                    } else if (nums[i] < nums[i - 1]) {
                        state = -1;
                    }
                    break;
                case 1:
                    if (nums[i] < nums[i - 1]) {
                        range[rlen++] = new int[]{b, i - 1};
                        b = i;
                        state = 0;
                    }
                    break;
                case -1:
                    if (nums[i] > nums[i - 1]) {
                        range[rlen++] = new int[]{b, i - 1};
                        for (int j = i - 1, k = b, c = 0; j >= b; j--, k++) {
                            if (j < i - 1 && nums[j] > nums[j + 1]) {
                                c = i - 1 - j;
                            }
                            src[k] = j;
                            count[j] = c;
                        }
                        b = i;
                        state = 0;
                    }
                    break;
            }
        }

        range[rlen++] = new int[]{b, len - 1};
        if (state == -1) {
            for (int j = len - 1, k = b, c = 0; j >= b; j--, k++) {
                if (j < len - 1 && nums[j] > nums[j + 1]) {
                    c = len - 1 - j;
                }
                src[k] = j;
                count[j] = c;
            }
        }

        while (rlen > 1) {
            int l = 0;
            for (int i = 0; i < rlen; i += 2) {
                if (i + 1 >= rlen) {
                    System.arraycopy(src, range[i][0], dest, range[i][0], range[i][1] + 1 - range[i][0]);
                    newRange[l++] = range[i];
                    continue;
                }
                int[] r1 = range[i], r2 = range[i + 1];
                int i1 = r1[0], i2 = r2[0], d = r1[0];
                while (i1 <= r1[1] && i2 <= r2[1]) {
                    if (nums[src[i1]] > nums[src[i2]]) {
                        dest[d++] = src[i2];
                        i2 += 1;
                    } else {
                        dest[d++] = src[i1];
                        count[src[i1]] += i2 - r2[0];
                        i1 += 1;
                    }
                }

                if (i1 <= r1[1]) {
                    for (int j = i1; j <= r1[1]; j++) {
                        dest[d++] = src[j];
                        count[src[j]] += i2 - r2[0];
                    }
                }

                if (i2 <= r2[1]) {
                    for (int j = i2; j <= r2[1]; j++) {
                        dest[d++] = src[j];
                    }
                }

                newRange[l++] = new int[]{r1[0], r2[1]};
            }

            int[][] tr = range;
            range = newRange;
            newRange = tr;
            rlen = l;

            int[] t = src;
            src = dest;
            dest = t;
        }

        List<Integer> ret = new ArrayList<>();
        for (int i : count) {
            ret.add(i);
        }

        return ret;
    }
}
