package com.leetcode.algorithms.studentAttendanceRecordII_552;

import org.junit.Assert;

abstract public class Solution {
    abstract public int checkRecord(int n);

    public static void main(String[] args) {
        Solution s = new UseDP();
        int ret;
        ret = s.checkRecord(100000);

        ret = s.checkRecord(3);
        Assert.assertEquals(19, ret);

        ret = s.checkRecord(4);
        Assert.assertEquals(43, ret);

        ret = s.checkRecord(5);
        Assert.assertEquals(94, ret);

        ret = s.checkRecord(100);
        Assert.assertEquals(985598218, ret);
    }
}
