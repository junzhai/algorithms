package com.leetcode.com.algorithms.decodeWaysII_639;

public class ForwardDP extends Solution {
    @Override
    public int numDecodings(String s) {
        long dp0 = 1, dp1, m = (long) Math.pow(10, 9) + 7;
        switch (s.charAt(0)) {
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

        for (int i = 1; i < s.length(); i++) {
            char pc = s.charAt(i - 1), c = s.charAt(i);
            switch (pc) {
                case '1':
                    switch (c) {
                        case '*':
                            dp = 9 * (dp1 + dp0) % m;
                            break;
                        case '0':
                            dp = dp0;
                            break;
                        default:
                            dp = (dp1 + dp0) % m;
                    }
                    break;
                case '2':
                    switch (c) {
                        case '*':
                            dp = (9 * dp1 % m + 6 * dp0 % m) % m;
                            break;
                        case '0':
                            dp = dp0;
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
                    switch (c) {
                        case '*':
                            dp = (9 * dp1 % m + 15 * dp0 % m) % m;
                            break;
                        case '0':
                            dp = 2 * dp0 % m;
                            break;
                        case '7':
                        case '8':
                        case '9':
                            dp = (dp1 + dp0) % m;
                            break;
                        default:
                            dp = (dp1 + 2 * dp0 % m) % m;
                    }
                    break;
                default:
                    switch (c) {
                        case '*':
                            dp = 9 * dp1 % m;
                            break;
                        case '0':
                            dp = 0;
                            break;
                        default:
                            dp = dp1;
                    }
            }
            dp0 = dp1;
            dp1 = dp;
        }
        return (int) dp;
    }
}
