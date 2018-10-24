package com.leetcode.com;

import org.junit.Assert;

import java.util.Arrays;

class MyCalendarThree {
    private int len = 0, k = 0;
    private int[] starts, ends, ks;

    public MyCalendarThree() {
        starts = new int[400];
        ends = new int[400];
        ks = new int[400];
    }

    public int book(int start, int end) {
        int s = Arrays.binarySearch(starts, 0, len, start), s0 = s, s1 = s;
        if (s0 >= 0) {
            while (s0 < len && starts[s0] == start) {
                s0 += 1;
            }

            while (s1 > 0 && starts[s1 - 1] == start) {
                s1 -= 1;
            }
        } else {
            s = -(s + 1);
            s0 = s;
            s1 = s;
        }

        int p = Arrays.binarySearch(ends, 0, len, start);
        if (p >= 0) {
            while (p > 0 && ends[p - 1] == start) {
                p -= 1;
            }
        } else {
            p = -(p + 1);
        }

        for (int i = s1; i < len && starts[i] < end; i++) {
            ks[i] += 1;
            k = Math.max(k, ks[i]);
        }

        System.arraycopy(ks, s, ks, s + 1, len - s);
        ks[s] = s0 + 1 - p;
        k = Math.max(k, ks[s]);

        System.arraycopy(starts, s, starts, s + 1, len - s);
        starts[s] = start;

        int e = Arrays.binarySearch(ends, 0, len, end - 1);
        if (e < 0) {
            e = -(e + 1);
        }
        System.arraycopy(ends, e, ends, e + 1, len - e);
        ends[e] = end - 1;


        len += 1;
        return k;
    }

    public static void main(String[] args) {
        MyCalendarThree obj = new MyCalendarThree();
        Assert.assertEquals(obj.book(47, 50), 1);
        Assert.assertEquals(obj.book(1, 10), 1);
        Assert.assertEquals(obj.book(27, 36), 1);
        Assert.assertEquals(obj.book(40, 47), 1);
        Assert.assertEquals(obj.book(20, 27), 1);
        Assert.assertEquals(obj.book(15, 23), 2);
        Assert.assertEquals(obj.book(10, 18), 2);
//        ],[27,36],[17,25],[8,17],[24,33],[23,28],[21,27],[47,50],[14,21],[26,32],[16,21],[2,7],[24,33],[6,13],[44,
// 50],[33,39],[30,36],[6,15],[21,27],[49,50],[38,45],[4,12],[46,50],[13,21]]


//[null,1,1,1,1,1,2,2,2,3,3,3,4,5,5,5,5,5,5,6,6,6,6,6,6,7,7,7,7,7,7]
        obj = new MyCalendarThree();
        Assert.assertEquals(obj.book(10, 20), 1);
        Assert.assertEquals(obj.book(50, 60), 1);
        Assert.assertEquals(obj.book(10, 40), 2);
        Assert.assertEquals(obj.book(5, 15), 3);
        Assert.assertEquals(obj.book(5, 10), 3);
        Assert.assertEquals(obj.book(25, 55), 3);

        obj = new MyCalendarThree();
        Assert.assertEquals(obj.book(24, 40), 1);
        Assert.assertEquals(obj.book(43, 50), 1);
        Assert.assertEquals(obj.book(27, 43), 2);
        Assert.assertEquals(obj.book(5, 21), 2);
        Assert.assertEquals(obj.book(30, 40), 3);
        Assert.assertEquals(obj.book(14, 29), 3);
        Assert.assertEquals(obj.book(3, 19), 3);
        Assert.assertEquals(obj.book(3, 14), 3);
        Assert.assertEquals(obj.book(25, 39), 4);
        Assert.assertEquals(obj.book(6, 19), 4);

//        [null,1,1,2,2,3,3,3,3,3,7]
    }
}