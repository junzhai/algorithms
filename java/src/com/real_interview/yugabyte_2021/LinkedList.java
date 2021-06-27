package com.real_interview.yugabyte_2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Circular singly list in ascending order
 */
public class LinkedList {
    public static void main(String[] args) {
        Solution_1 s = new Solution_1();
        s.insert(2);
        s.insert(1);
        s.insert(5);
        s.insert(10);
        s.insert(0);
        s.insert(4);
        s.print();

        Solution_2 s2 = new Solution_2();
        s2.insert(2);
        s2.insert(1);
        s2.insert(5);
        s2.insert(10);
        s2.insert(0);
        s2.insert(4);
        s2.print();
    }

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private static class Solution_1 {
        private int sum = 0;
        private Node head = null, tail = null;

        public void insert(int x) {
            Node n = new Node(x);
            if (head == null) {
                head = n;
                tail = n;
                n.next = n;
            } else {
                Node p = head, pre = null;
                while (p != tail && p.val < x) {
                    pre = p;
                    p = p.next;
                }

                if (p.val >= x) {
                    if (pre == null) {
                        n.next = head;
                        head = n;
                        tail.next = n;
                    } else {
                        n.next = pre.next;
                        pre.next = n;
                    }
                } else {
                    p.next = n;
                    n.next = head;
                    tail = n;
                }
            }
            sum += x;
        }

        public int getSum() {
            return sum;
        }

        public void print() {
            Node p = head;
            while (p != tail) {
                System.out.print(p.val + ", ");
                p = p.next;
            }
            System.out.println(p.val);
        }
    }

    /**
     * unnecessary
     */
    private static class Solution_2 {
        private int sum = 0;
        private Node head = null, tail = null;
        private List<Node> arr = new ArrayList<>();

        private Comparator<Node> comp = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        };

        public void insert(int x) {
            Node n = new Node(x);
            if (head == null) {
                head = n;
                tail = n;
                n.next = n;
                arr.add(n);
            } else {
                int i = Collections.binarySearch(arr, n, comp);
                if (i < 0) {
                    i = -i - 1;
                }

                arr.add(i, n);

                if (i == 0) {
                    head = n;
                    tail.next = n;
                    n.next = arr.get(i + 1);
                } else if (i == arr.size() - 1) {
                    arr.get(i - 1).next = n;
                    n.next = head;
                    tail = n;
                } else {
                    arr.get(i - 1).next = n;
                    n.next = arr.get(i + 1);
                }
            }
            sum += x;
        }

        public int getSum() {
            return sum;
        }

        public void print() {
            Node p = head;
            while (p != tail) {
                System.out.print(p.val + ", ");
                p = p.next;
            }
            System.out.println(p.val);

        }
    }
}
