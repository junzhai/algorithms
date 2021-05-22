package com.leetcode.algorithms.longestDuplicateSubstring_1044;

import com.pattern.algorithms.DivideAndConquer;
import com.pattern.algorithms.QuickSortSelect;

import java.util.Arrays;

@DivideAndConquer
@QuickSortSelect
public class DivideAndConquerWithQuickSortPartition extends Solution {
    private class BSTNode {
        int low, high;
        BSTNode left, right;

        BSTNode(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }

    @Override
    public String longestDupSubstring(String S) {
        char[] s = S.toCharArray();
        int len = s.length;
        s = Arrays.copyOf(s, len + 1);
        s[len] = '*';

        int[] dp = new int[len], chs = new int[26];
        for (int i = 0; i < len; i++) {
            dp[i] = i;
            chs[s[i] - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (chs[i] == len) {
                return S.substring(1);
            }
        }

        int[] r = helper(s, dp, 0, len);
        return String.valueOf(s, r[0], r[1]);
    }

    private int[] helper(char[] s, int[] dp, int l, int r) {
        int pos = 0, max = -1, len = dp.length;
        while (l < r) {
            int nl = partitionAndMoveForward(s, dp, l, r);
            if (nl - l == 1) {
                if (0 > max) {
                    pos = dp[l] - 1;
                    max = 0;
                }
            } else if (nl - l == 2) {
                int count = 1, a = dp[l], b = dp[l + 1];
                while (a < len && b < len && s[a] == s[b]) {
                    count += 1;
                    a += 1;
                    b += 1;
                }
                if (count > max) {
                    pos = dp[l] - 1;
                    max = count;
                }
            } else {
                int[] m = helper(s, dp, l, nl);
                if (m[1] + 1 > max) {
                    pos = m[0] - 1;
                    max = m[1] + 1;
                }
            }
            l = nl;
        }
        return new int[]{pos, max};
    }

    private int partitionAndMoveForward(char[] s, int[] dp, int l, int r) {
        char target = s[dp[l]];
        while (l < r) {
            if (s[dp[l]] == target) {
                dp[l] += 1;
                l += 1;
                continue;
            }

            if (s[dp[r - 1]] != target) {
                r -= 1;
                continue;
            }

            int tmp = dp[l];
            dp[l] = dp[r - 1] + 1;
            dp[r - 1] = tmp;
            l += 1;
            r -= 1;
        }
        return l;
    }
}
