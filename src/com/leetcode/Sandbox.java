package com.leetcode;

import org.junit.Assert;

import java.util.Arrays;

public class Sandbox {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int b = 0, l = people.length, ret = 0;
        while (b < l) {
            if (b == l - 1) {
                ret += 1;
                break;
            }
            int target = limit - people[b];
            int p = Arrays.binarySearch(people, b, l, target);
            if (p >= 0) {
                while (p < l - 1 && people[p + 1] == target) {
                    p += 1;
                }

                ret += l - p;
                l = p;
                b += 1;
            } else {
                p = -p - 1;
                ret += l - p;
                if (p <= b) {
                    break;
                }
                ret += 1;
                l = p - 1;
                b += 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Sandbox s = new Sandbox();
        int ret;

        ret = s.numRescueBoats(new int[]{4, 9, 3, 1, 1, 7, 6, 10, 10, 10, 1, 8, 8, 7, 8, 10, 7, 4, 6, 3, 6, 1, 2, 4,
                8, 8, 4, 7, 1, 2, 10, 3, 4, 6, 3, 5, 3, 1, 2, 6, 1, 5, 4, 5, 1, 10, 5, 9, 10, 4}, 10);
        Assert.assertEquals(29, ret);

        ret = s.numRescueBoats(new int[]{1, 3, 4, 3, 3, 5}, 5);
        Assert.assertEquals(5, ret);

    }
}