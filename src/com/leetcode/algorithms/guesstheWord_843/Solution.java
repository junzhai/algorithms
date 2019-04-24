package com.leetcode.algorithms.guesstheWord_843;

abstract public class Solution {
    abstract public void findSecretWord(String[] wordlist, Master master);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new UseSet(),
                new UseArrayNoSaving(),
                new UseArray()
        };

        for (Solution s : solutions) {
            String[] wordlist = new String[]{
                    "mjpsce", "giwiyk", "slbnia", "pullbr", "ezvczd", "dwkrmt", "qgzebh", "wvhhlm", "kqbmny", "zpvrkz",
                    "pdwxvy", "gilywa", "gmrrdc", "vvqvla", "rmjirt", "qmvykq", "mhbmuq", "unplzn", "qkcied", "eignxg",
                    "fbfgng", "xpizga", "twubzr", "nnfaxr", "skknhe", "twautl", "nglrst", "mibyks", "qrbmpx", "ukgjkq",
                    "mhxxfb", "deggal", "bwpvsp", "uirtak", "tqkzfk", "hfzawa", "jahjgn", "mteyut", "jzbqbv", "ttddtf",
                    "auuwgn", "untihn", "gbhnog", "zowaol", "feitjl", "omtiur", "kwdsgx", "tggcqq", "qachdn", "dixtat",
                    "hcsvbw", "chduyy", "gpdtft", "bjxzky", "uvvvko", "jzcpiv", "gtyjau", "unsmok", "vfcmhc", "hvxnut",
                    "orlwku", "ejllrv", "jbrskt", "xnxxdi", "rfreiv", "njbvwj", "pkydxy", "jksiwj", "iaembk", "pyqdip",
                    "exkykx", "uxgecc", "khzqgy", "dehkbu", "ahplng", "jomiik", "nmcsfe", "bclcbp", "xfiefi", "soiwde",
                    "tcjkjp", "wervlz", "dcthgv", "hwwghe", "hdlkll", "dpzoxb", "mpiviy", "cprcwo", "molttv", "dwjtdp",
                    "qiilsr", "dbnaxs", "dbozaw", "webcyp", "vftnkr", "iurlzf", "giqcfc", "pcghoi", "zupyzn", "xckegy"
            };

            Master master = new Master() {
                @Override
                public int guess(String word) {
                    int ret = 0;
                    for (int i = 0; i < 6; i++) {
                        if (word.charAt(i) == "vftnkr".charAt(i)) {
                            ret += 1;
                        }
                    }
                    return ret;
                }
            };

            s.findSecretWord(wordlist, master);
        }
    }
}
