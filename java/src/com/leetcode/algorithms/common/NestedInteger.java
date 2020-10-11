package com.leetcode.algorithms.common;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
    private int val;
    private List<NestedInteger> l;

    // Constructor initializes an empty nested list.
    public NestedInteger() {
        l = new ArrayList<>();
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        l = null;
        val = value;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return l == null;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        if (isInteger()) {
            return val;
        }
        return null;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
        val = value;
        l = null;
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        if (l == null) {
            l = new ArrayList<>();
        }
        l.add(ni);
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return l;
    }
}
