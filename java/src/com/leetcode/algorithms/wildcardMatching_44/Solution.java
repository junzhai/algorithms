package com.leetcode.algorithms.wildcardMatching_44;

import org.junit.Assert;

abstract public class Solution {
    abstract public boolean isMatch(String s, String p);

    public static void main(String[] args) {
        Solution s = new UpdatedKMP();
        boolean ret;

        ret = s.isMatch("zacabz", "*a?b*");
        Assert.assertEquals(false, ret);

        ret = s.isMatch("baab", "*?ab*");
        Assert.assertEquals(true, ret);

        ret = s.isMatch("", "ab*");
        Assert.assertEquals(false, ret);

        ret = s.isMatch("mississippi", "m??*ss*?i*pi");
        Assert.assertEquals(false, ret);

        ret = s.isMatch("b", "?*?");
        Assert.assertEquals(false, ret);

        ret = s.isMatch("", "*");
        Assert.assertEquals(true, ret);

        ret = s.isMatch("aaaa", "***a");
        Assert.assertEquals(true, ret);

        ret = s.isMatch("aa", "a");
        Assert.assertEquals(false, ret);

        ret = s.isMatch("aa", "*");
        Assert.assertEquals(true, ret);

        ret = s.isMatch("cb", "?a");
        Assert.assertEquals(false, ret);

        ret = s.isMatch("adceb", "*a*b");
        Assert.assertEquals(true, ret);

        ret = s.isMatch("acdcb", "a*c?b");
        Assert.assertEquals(false, ret);

        ret = s.isMatch
                ("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                        "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb" +
                                "*bb**a*b" +
                                "*bb");
        Assert.assertEquals(false, ret);
    }
}
