package com.real_interview.amazon_2021;

public class FindInterleave {
    private class Node {
        int v;
        Node next;
    }

    public boolean solution1(Node l1, Node l2) {
        Node p1 = l1;
        while (p1 != null && p1.next != null) {
            p1 = p1.next;
        }
        Node p2 = l2;
        while (p2 != null && p2.next != null) {
            p2 = p2.next;
        }

        return p1 != null && p1 == p2;
    }

    private Node reverse(Node l) {
        Node p = l, pre = null;
        while (p != null) {
            Node next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    public boolean solution2(Node l1, Node l2) {
        Node p1 = reverse(l1);

        Node p2 = l2;
        while (p2 != null && p2.next != null) {
            p2 = p2.next;
        }

        boolean ret = p2 == l1;
        reverse(p1);
        return ret;
    }
}
