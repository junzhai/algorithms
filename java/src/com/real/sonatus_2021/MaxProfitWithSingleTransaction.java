package com.real.sonatus_2021;

public class MaxProfitWithSingleTransaction {
    public int solution(int[] prices) {
        int min = prices[0], ret = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                ret = Math.max(ret, prices[i] - min);
            }
        }
        if (ret == Integer.MIN_VALUE) {
            for (int i = 1; i < prices.length; i++) {
                ret = Math.max(ret, prices[i] - prices[i - 1]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        MaxProfitWithSingleTransaction s = new MaxProfitWithSingleTransaction();
        System.out.println(s.solution(new int[]{10, 8, 2, 4, 16, 1}));
        System.out.println(s.solution(new int[]{10, 8, 5, 1}));
        System.out.println(s.solution(new int[]{10, 8, 2, 4, 6, 1, 3, 16}));
    }

}
