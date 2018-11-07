package com.leetcode.premium.serializeAndDeserializeN_AryTree_428;

import com.leetcode.common.Node;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Codec {
    public String serialize(Node root) {
        return helper(root);
    }

    private String helper(Node root) {
        if (root == null) {
            return "";
        }

        String ret = String.valueOf(root.val);
        if (root.children == null || root.children.isEmpty()) {
            return ret;
        }

        ret += "(";
        for (Node child : root.children) {
            if (!ret.endsWith(")") && !ret.endsWith("(")) {
                ret += " ";
            }
            ret += helper(child);
        }
        ret += ")";
        return ret;
    }

    public Node deserialize(String data) {
        Stack<Integer> cs = new Stack<>();
        List<Node> ns = new ArrayList<>();

        for (int i = 0, sum = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            switch (c) {
                case '(':
                    cs.push(sum);
                    sum = 0;
                    break;
                case ')':
                    Node p = ns.get(ns.size() - sum - 1);
                    for (int k = 0; k < sum; k++) {
                        p.children.add(0, ns.remove(ns.size() - 1));
                    }
                    sum = cs.pop();
                    break;
                case ' ':
                    break;
                default:
                    int b = i;
                    while (i < data.length() && Character.isDigit(data.charAt(i))) {
                        i += 1;
                    }
                    ns.add(new Node(Integer.valueOf(data.substring(b, i))));
                    i -= 1;
                    sum += 1;

            }
        }

        return ns.get(0);
    }

    public static void main(String[] arg) {
        Codec codec = new Codec();

        Node root = codec.deserialize("1(3(5 6)2 4)");
        String ret = codec.serialize(root);
        Assert.assertEquals("1(3(5 6)2 4)", ret);

        root = codec.deserialize("11(13(15 16)12 14)");
        ret = codec.serialize(root);
        Assert.assertEquals("11(13(15 16)12 14)", ret);
    }
}
