package com.leetcode.premium.IPtoCIDR_751;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a start IP address ip and a number of ips we need to cover n, return a representation of the range as a list
 * (of smallest possible length) of CIDR blocks.
 * <p>
 * A CIDR block is a string consisting of an IP, followed by a slash, and then the prefix length. For example:
 * "123.45.67.89/20". That prefix length "20" represents the number of common prefix bits in the specified range.
 * <p>
 * Example 1:
 * Input: ip = "255.0.0.7", n = 10
 * Output: ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
 * Explanation:
 * The initial ip address, when converted to binary, looks like this (spaces added for clarity):
 * 255.0.0.7 -> 11111111 00000000 00000000 00000111
 * The address "255.0.0.7/32" specifies all addresses with a common prefix of 32 bits to the given address,
 * ie. just this one address.
 * <p>
 * The address "255.0.0.8/29" specifies all addresses with a common prefix of 29 bits to the given address:
 * 255.0.0.8 -> 11111111 00000000 00000000 00001000
 * Addresses with common prefix of 29 bits are:
 * 11111111 00000000 00000000 00001000
 * 11111111 00000000 00000000 00001001
 * 11111111 00000000 00000000 00001010
 * 11111111 00000000 00000000 00001011
 * 11111111 00000000 00000000 00001100
 * 11111111 00000000 00000000 00001101
 * 11111111 00000000 00000000 00001110
 * 11111111 00000000 00000000 00001111
 * <p>
 * The address "255.0.0.16/32" specifies all addresses with a common prefix of 32 bits to the given address,
 * ie. just 11111111 00000000 00000000 00010000.
 * <p>
 * In total, the answer specifies the range of 10 ips starting with the address 255.0.0.7 .
 * <p>
 * There were other representations, such as:
 * ["255.0.0.7/32","255.0.0.8/30", "255.0.0.12/30", "255.0.0.16/32"],
 * but our answer was the shortest possible.
 * <p>
 * Also note that a representation beginning with say, "255.0.0.7/30" would be incorrect,
 * because it includes addresses like 255.0.0.4 = 11111111 00000000 00000000 00000100
 * that are outside the specified range.
 * Note:
 * ip will be a valid IPv4 address.
 * Every implied address ip + x (for x < n) will be a valid IPv4 address.
 * n will be an integer in the range [1, 1000].
 */
public class Solution {
    public List<String> ipToCIDR(String ip, int range) {
        List<String> ret = new ArrayList<>();
        int ipp = IPInt(ip);
        while (range > 0) {
            int bit = 0, count = 1, mask = 1;
            while (count < range && (ipp & mask) == 0) {
                bit += 1;
                count <<= 1;
                mask <<= 1;
            }
            if (count > range) {
                bit -= 1;
                count >>>= 1;
            }
            ret.add(IPString(ipp) + "/" + (32 - bit));
            range -= count;
            ipp += count;
        }
        return ret;
    }

    private int IPInt(String ip) {
        int ret = 0;
        String[] arr = ip.split("\\.");
        for (String s : arr) {
            ret <<= 8;
            ret += Integer.parseInt(s);
        }
        return ret;
    }

    private String IPString(int ip) {
        String ret = String.valueOf(ip & 255);
        ip >>>= 8;
        for (int i = 0; i < 3; i++) {
            ret = (ip & 255) + "." + ret;
            ip >>>= 8;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> ret;
        ret = s.ipToCIDR("255.0.0.7", 10);

    }
}
