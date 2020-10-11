package com.leetcode.algorithms.bestTimetoBuyandSellStockIV_188;

public class DirectCalculateUsingDoubleLinkedList extends Solution {
    private static class Trend {
        int profit;
        Trend next, pre;

        Trend(int profit, Trend pre) {
            this.profit = profit;
            this.pre = pre;
        }
    }

    @Override
    public int maxProfit(int k, int[] prices) {
        if (k < 1 || prices.length == 0) {
            return 0;
        }

        Trend root = new Trend(0, null), tail = root;
        int len = prices.length, low = prices[0], high = 0, ret = 0, count = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] < prices[i - 1]) {
                if (prices[i - 1] > low) {
                    if (high > low) {
                        tail.next = new Trend(high - low, tail);
                        tail = tail.next;
                    }
                    high = prices[i - 1];
                    ret += high - low;
                    tail.next = new Trend(high - low, tail);
                    tail = tail.next;
                    count += 1;
                }
                low = prices[i];
            }
        }

        if (prices[len - 1] > low) {
            if (high > low) {
                tail.next = new Trend(high - low, tail);
                tail = tail.next;
            }
            ret += prices[len - 1] - low;
            tail.next = new Trend(prices[len - 1] - low, tail);
            count += 1;
        }

        for (int i = 0; i < count - k; i++) {
            Trend p = root.next, picked = null;
            int min = Integer.MAX_VALUE;
            while (p != null) {
                if (p.profit < min) {
                    min = p.profit;
                    picked = p;
                }
                p = p.next;
            }

            ret -= min;
            if (picked.next == null) {
                picked.pre.pre.next = null;
            } else if (picked.pre == root) {
                root.next = picked.next.next;
            } else {
                picked.pre.profit = picked.pre.profit + picked.next.profit - picked.profit;
                picked.pre.next = picked.next.next;
                if (picked.next.next != null) {
                    picked.next.next.pre = picked.pre;
                }
            }
        }
        return ret;
    }
}
