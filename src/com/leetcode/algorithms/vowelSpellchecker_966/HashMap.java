package com.leetcode.algorithms.vowelSpellchecker_966;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMap extends Solution {
    @Override
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> l1 = new HashSet<>();
        Map<String, String> l2 = new java.util.HashMap<>(), l3 = new java.util.HashMap<>();
        for (int i = 0; i < wordlist.length; i++) {
            String w = wordlist[i];
            if (l1.contains(w)) {
                continue;
            }

            l1.add(w);

            String ww = w.toLowerCase();
            if (l2.containsKey(ww)) {
                continue;
            }

            l2.put(ww, w);

            ww = ww.replaceAll("a|e|i|o|u", "_");
            if (l3.containsKey(ww)) {
                continue;
            }

            l3.put(ww, w);
        }

        String[] ret = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (l1.contains(q)) {
                ret[i] = q;
                continue;
            }

            q = q.toLowerCase();
            if (l2.containsKey(q)) {
                ret[i] = l2.get(q);
                continue;
            }

            q = q.replaceAll("a|e|i|o|u", "_");
            if (l3.containsKey(q)) {
                ret[i] = l3.get(q);
                continue;
            }
            ret[i] = "";
        }
        return ret;
    }
}
