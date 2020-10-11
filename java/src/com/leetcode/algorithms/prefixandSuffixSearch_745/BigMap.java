package com.leetcode.algorithms.prefixandSuffixSearch_745;

import java.util.HashMap;
import java.util.Map;

class BigMap extends WordFilter {
    private final Map<String, Integer> cache = new HashMap<>();

    public BigMap(String[] words) {
        cache.put("_", words.length - 1);

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            int len = w.length();

            for (int s = 1; s <= len; s++) {
                String key = "_" + w.substring(len - s, len);
                cache.put(key, i);
            }

            for (int p = 1; p <= len; p++) {
                String pre = w.substring(0, p) + "_";
                for (int s = 1; s <= len; s++) {
                    String key = pre + w.substring(len - s, len);
                    cache.put(key, i);
                }
                cache.put(pre, i);
            }
        }
    }

    @Override
    public int f(String prefix, String suffix) {
        String k = prefix + "_" + suffix;
        return cache.getOrDefault(k, -1);
    }
}