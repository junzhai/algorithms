package com.leetcode.miniParser_385;

import com.leetcode.common.NestedInteger;

abstract public class Solution {
    abstract public NestedInteger deserialize(String s);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
//                new Recursive(),
                new NonRecursive()
        };

        NestedInteger ret;
        for (Solution s : solutions) {
            ret = s.deserialize("-3");
            ret = s.deserialize("[123,[456,[789]]]");
        }
    }
}