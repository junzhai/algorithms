package com.leetcode.decodeWaysII_639;

public class BackwardDP extends Solution {
    @Override
    public int numDecodings(String s) {
        long dp0 = 1, m = (long) Math.pow(10, 9) + 7, dp1;
        switch (s.charAt(s.length() - 1)) {
            case '*':
                dp1 = 9;
                break;
            case '0':
                dp1 = 0;
                break;
            default:
                dp1 = 1;
        }
        long dp = dp1;

        for (int i = s.length() - 2; i >= 0; i--) {
            char c = s.charAt(i), nc = s.charAt(i + 1);
            switch (c) {
                case '0':
                    dp = 0;
                    break;
                case '1':
                    switch (nc) {
                        case '*':
                            dp = (dp1 + 9 * dp0 % m) % m;
                            break;
                        default:
                            dp = (dp1 + dp0) % m;
                    }
                    break;
                case '2':
                    switch (nc) {
                        case '*':
                            dp = (dp1 + 6 * dp0 % m) % m;
                            break;
                        case '7':
                        case '8':
                        case '9':
                            dp = dp1;
                            break;
                        default:
                            dp = (dp1 + dp0) % m;
                    }
                    break;
                case '*':
                    switch (nc) {
                        case '*':
                            dp = (9 * dp1 % m + 15 * dp0 % m) % m;
                            break;
                        case '7':
                        case '8':
                        case '9':
                            dp = (9 * dp1 % m + dp0) % m;
                            break;
                        default:
                            dp = (9 * dp1 % m + 2 * dp0 % m) % m;
                    }
                    break;
                default:
                    dp = dp1;
            }
            dp0 = dp1;
            dp1 = dp;
        }
        return (int) dp;
    }
}
