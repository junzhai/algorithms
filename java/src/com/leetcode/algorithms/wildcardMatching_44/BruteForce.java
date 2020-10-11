package com.leetcode.algorithms.wildcardMatching_44;

public class BruteForce extends Solution {
    @Override
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }

    private boolean helper(String s, String p, int si, int pi) {
        if (si <= s.length() && pi < p.length()) {
            char c = p.charAt(pi);
            if (si < s.length() && (Character.isLetter(c) && c == s.charAt(si) || c == '?')) {
                return helper(s, p, si + 1, pi + 1);
            }

            if (c == '*') {
                int npi = pi + 1;
                char nc = c;
                while (npi < p.length() && nc == '*') {
                    nc = p.charAt(npi);
                    npi += 1;
                }

                if (nc == '*') {
                    return true;
                }

                if (nc == '?') {
                    for (int i = si + 1; i <= s.length(); i++) {
                        if (helper(s, p, i, npi)) {
                            return true;
                        }
                    }
                    return false;
                }

                int from = si;
                while (from < s.length()) {
                    int i = s.indexOf(nc, from);
                    if (i == -1) {
                        break;
                    }
                    if (helper(s, p, i + 1, npi)) {
                        return true;
                    }
                    from = i + 1;
                }
                return false;
            }

            return false;
        } else {
            return si >= s.length() && pi >= p.length();
        }
    }
}
