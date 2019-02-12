package com.leetcode.countofSmallerNumbersAfterSelf_315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch2 extends Solution {
    @Override
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if (nums.length == 0) {
            return ret;
        }
        ret.add(0);

        int len = nums.length, b = len - 1;
        int[] copy = new int[len];
        copy[len - 1] = nums[len - 1];

        while (b > 0) {
            int p = b - 1;
            while (p > 0 && nums[p - 1] <= nums[p]) {
                p -= 1;
            }

            for (int i = p, src = b, dest = p; i < b; i++) {
                if (src < len) {
                    int pos = Arrays.binarySearch(copy, src, len, nums[i]);
                    if (pos >= 0) {
                        while (pos > src && copy[pos - 1] == nums[i]) {
                            pos -= 1;
                        }
                    } else {
                        pos = -pos - 1;
                    }

                    System.arraycopy(copy, src, copy, dest, pos - src);
                    dest += pos - src;
                    src = pos;
                }
                ret.add(i - p, src - b);
                copy[dest++] = nums[i];
            }

            b = p;
        }
        return ret;
    }

    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if (nums.length == 0) {
            return ret;
        }
        ret.add(0);

        int len = nums.length, b = len - 1;
        int[] copy = new int[len];
        copy[len - 1] = nums[len - 1];

        while (b > 0) {
            int p = b - 1;
            while (p > 0 && nums[p - 1] >= nums[p]) {
                p -= 1;
            }

            for (int i = b - 1, src = b, dest = p; i >= p; i--) {
                if (src < len) {
                    int pos = Arrays.binarySearch(copy, src, len, nums[i]);
                    if (pos >= 0) {
                        while (pos > src && copy[pos - 1] == nums[i]) {
                            pos -= 1;
                        }
                    } else {
                        pos = -pos - 1;
                    }

                    System.arraycopy(copy, src, copy, dest, pos - src);
                    dest += pos - src;
                    src = pos;
                }

                ret.add(0, src - b + b - 1 - i);
                copy[dest++] = nums[i];
            }

            b = p;
        }
        return ret;
    }

    public List<Integer> countSmaller1(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if (nums.length == 0) {
            return ret;
        }
        ret.add(0);

        int len = nums.length, b = len - 1;
        int[] copy = new int[len];
        copy[len - 1] = nums[len - 1];

        while (b > 1) {
            int p = b - 1;
            while (p > 0 && nums[p - 1] >= nums[p]) {
                p -= 1;
            }

            if (b - p > 1) {
                for (int i = b - 1, src = b, dest = p; i >= p; i--) {
                    if (src < len) {
                        int pos = Arrays.binarySearch(copy, src, len, nums[i]);
                        if (pos >= 0) {
                            while (pos > src && copy[pos - 1] == nums[i]) {
                                pos -= 1;
                            }
                        } else {
                            pos = -pos - 1;
                        }

                        System.arraycopy(copy, src, copy, dest, pos - src);
                        dest += pos - src;
                        src = pos;
                    }

                    ret.add(0, src - b + b - 1 - i);
                    copy[dest++] = nums[i];
                }

                b = p;
                continue;
            }

            p = b - 1;
            while (p > 0 && nums[p - 1] <= nums[p]) {
                p -= 1;
            }

            if (b - p > 1) {
                for (int i = p, src = b, dest = p; i < b; i++) {
                    if (src < len) {
                        int pos = Arrays.binarySearch(copy, src, len, nums[i]);
                        if (pos >= 0) {
                            while (pos > src && copy[pos - 1] == nums[i]) {
                                pos -= 1;
                            }
                        } else {
                            pos = -pos - 1;
                        }

                        System.arraycopy(copy, src, copy, dest, pos - src);
                        dest += pos - src;
                        src = pos;
                    }
                    ret.add(i - p, src - b);
                    copy[dest++] = nums[i];
                }

                b = p;
            }
        }
        if (b == 1) {
            int pos = Arrays.binarySearch(copy, b, len, nums[0]);
            if (pos >= 0) {
                while (pos > 0 && copy[pos - 1] == nums[0]) {
                    pos -= 1;
                }
            } else {
                pos = -pos - 1;
            }
            ret.add(0, pos - 1);
        }

        return ret;
    }
}
