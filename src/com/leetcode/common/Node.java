package com.leetcode.common;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}
