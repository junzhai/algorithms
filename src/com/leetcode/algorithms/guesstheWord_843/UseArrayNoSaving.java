package com.leetcode.algorithms.guesstheWord_843;

public class UseArrayNoSaving extends Solution {
    @Override
    public void findSecretWord(String[] wordlist, Master master) {
        String pick = "";
        for (int t = 0, len = wordlist.length; t < 10; t++) {
            int min = len;
            for (int i = 0; i < len; i++) {
                int[] count = new int[6];
                for (int j = 0; j < len; j++) {
                    if (i != j) {
                        int match = match(wordlist[i], wordlist[j]);
                        count[match] += 1;
                    }
                }

                int max = 0;
                for (int j = 0; j < 6; j++) {
                    max = Math.max(max, count[j]);
                }

                if (max < min) {
                    min = max;
                    pick = wordlist[i];
                }
            }


            int match = master.guess(pick);
            if (match == 6) {
                break;
            }

            int nl = 0;
            for (int i = 0; i < len; i++) {
                if (match(pick, wordlist[i]) == match) {
                    wordlist[nl++] = wordlist[i];
                }
            }
            len = nl;
        }
    }

    private int match(String a, String b) {
        int ret = 0;
        for (int i = 0; i < 6; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                ret += 1;
            }
        }
        return ret;
    }
}
