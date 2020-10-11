package com.leetcode.algorithms.superUglyNumber_313;

/**
 * Time Limit Exceeded
 */
public class BruteForce extends Solution {
    @Override
    public int nthSuperUglyNumber(int n, int[] primes) {
        int cur = 1, c = 1, k = primes.length;
        while (c < n) {
            cur += 1;
            int d = cur, dd = cur + 1;
            while (d < dd && d != 1) {
                dd = d;
                for (int p : primes) {
                    if (d % p == 0) {
                        d /= p;
                        break;
                    }
                }
            }
            if (d == 1) {
                c += 1;
            }
        }
        return cur;
    }
}
