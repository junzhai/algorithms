package com.leetcode.algorithms.numberofMusicPlaylists_920;

import com.leetcode.algorithms.pattern.DP;
import org.junit.Assert;

import java.math.BigInteger;

@DP
public class Solution {
    public int numMusicPlaylists(int N, int L, int K) {
        int m = (int) Math.pow(10, 9) + 7;
        BigInteger mm = BigInteger.valueOf(m);

        if (N == L) {
            return factorial(N, m);
        }
        int[] comb1 = new int[N - K], comb2 = new int[N - K], dp = new int[N - K];
        comb1[0] = 1;
        if (N - K > 1) {
            comb1[1] = 1;
        }
        dp[0] = factorial(K + 1, m);

        for (int n = 2; n <= N; n++) {
            int sub = 0;
            comb2[0] = 1;
            for (int i = 1; i <= Math.min(n, N - K - 1); i++) {
                comb2[i] = comb1[i] + comb1[i - 1];
                comb2[i] %= m;
                if (n > i + K) {
                    sub += BigInteger.valueOf(dp[n - i - K - 1])
                            .multiply(BigInteger.valueOf(comb2[i])).mod(mm).intValue();
                    sub %= m;
                }
            }

            if (n > K + 1) {
                dp[n - K - 1] = (permutation(n, L, K, m) - sub) % m;
                dp[n - K - 1] = dp[n - K - 1] < 0 ? dp[n - K - 1] + m : dp[n - K - 1];
            }

            int[] t = comb1;
            comb1 = comb2;
            comb2 = t;
        }

        return dp[N - K - 1];
    }

    private int permutation(int n, int l, int k, int m) {
        long ret = 1;
        for (int i = n; i > n - k; i--) {
            ret *= i;
            ret %= m;
        }
        for (int i = 0; i < l - k; i++) {
            ret *= n - k;
            ret %= m;
        }
        return (int) ret;
    }

    private int factorial(int x, int m) {
        long ret = 1;
        for (int i = 2; i <= x; i++) {
            ret *= i;
            ret %= m;
        }
        return (int) ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret;

        ret = s.numMusicPlaylists(67, 70, 29);
        Assert.assertEquals(205197904, ret);

        ret = s.numMusicPlaylists(37, 50, 8);
        Assert.assertEquals(32125759, ret);

        ret = s.numMusicPlaylists(16, 19, 5);
        Assert.assertEquals(64612811, ret);

        ret = s.numMusicPlaylists(16, 16, 4);
        Assert.assertEquals(789741546, ret);

        ret = s.numMusicPlaylists(3, 4, 1);
        Assert.assertEquals(18, ret);

        ret = s.numMusicPlaylists(2, 4, 0);
        Assert.assertEquals(14, ret);

        ret = s.numMusicPlaylists(1, 4, 0);
        Assert.assertEquals(1, ret);

        ret = s.numMusicPlaylists(3, 3, 1);
        Assert.assertEquals(6, ret);

        ret = s.numMusicPlaylists(2, 3, 1);
        Assert.assertEquals(2, ret);

        ret = s.numMusicPlaylists(2, 3, 0);
        Assert.assertEquals(6, ret);
    }
}
