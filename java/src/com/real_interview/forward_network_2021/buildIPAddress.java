package com.real_interview.forward_network_2021;

import java.util.ArrayList;
import java.util.List;

/*
    Time: O(1), Space: O(1)
 */
public class buildIPAddress {
    public static void main(String[] args) throws java.lang.Exception {
//        List<String> ret = test("25525511135");
        List<String> ret = solution("101023");
//        List<String> ret = test("0011255245");
        System.out.println(ret);
    }

    private static List<String> solution(String s) {
        List<String> ret = new ArrayList<>();
        helper(s, 0, new String[4], 0, ret);
        return ret;
    }

    private static void helper(String s, int i, String[] ip, int l, List<String> ret) {
        if (l >= 4 || i >= s.length()) {
            if (l == 4 && i == s.length()) {
                StringBuilder sb = new StringBuilder(ip[0]);
                for (int j = 1; j < 4; j++) {
                    sb.append('.');
                    sb.append(ip[j]);
                }
                ret.add(sb.toString());
            }
            return;
        }

        int v = 0;
        for (int j = i; j < s.length(); j++) {
            v = v * 10 + (s.charAt(j) - '0');
            if (v >= 256) {
                return;
            }

            ip[l] = String.valueOf(v);
            helper(s, j + 1, ip, l + 1, ret);
            if (v == 0) {
                return;
            }
        }
    }
}
