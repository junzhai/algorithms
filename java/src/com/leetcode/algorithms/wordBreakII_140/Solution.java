package com.leetcode.algorithms.wordBreakII_140;

import com.pattern.algorithms.DFS;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DFS
public class Solution {

    private static class TrieNode {
        boolean isWord = false;
        TrieNode[] children = new TrieNode[26];
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        TrieNode root = buildTrie(wordDict);

        char[] ss = s.toCharArray();
        Map<Integer, int[]> g = new HashMap<>();

        if (!buildGraph(ss, root, g)) {
            return Collections.emptyList();
        }

        List<String> ret = new ArrayList<>();
        int[] buf = new int[ss.length + 1];
        buf[0] = 0;
        dfs(g, ss, buf, 1, ret);
        return ret;
    }

    private void dfs(Map<Integer, int[]> g, char[] s, int[] buf, int l, List<String> ret) {
        int cur = buf[l - 1], len = s.length;
        if (!g.containsKey(cur)) {
            return;
        }
        for (int child : g.get(cur)) {
            buf[l] = child;
            if (child == len) {
                String w = String.valueOf(s, 0, buf[1]);
                for (int i = 1; i < l; i++) {
                    w += " " + String.valueOf(s, buf[i], buf[i + 1] - buf[i]);
                }
                ret.add(w);
            } else {
                dfs(g, s, buf, l + 1, ret);
            }
        }
    }

    private boolean buildGraph(char[] s, TrieNode root, Map<Integer, int[]> g) {
        int len = s.length, l;
        boolean[] select = new boolean[len + 1];
        select[0] = true;
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            if (!select[i]) {
                continue;
            }

            l = 0;
            TrieNode p = root;
            for (int j = i; j < len; j++) {
                int index = s[j] - 'a';
                if (p.children[index] == null) {
                    break;
                }
                p = p.children[index];
                if (p.isWord) {
                    tmp[l++] = j + 1;
                    select[j + 1] = true;
                }
            }

            g.put(i, Arrays.copyOfRange(tmp, 0, l));
        }
        return select[len];
    }

    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode();
        int l = dict.size();
        for (int i = 0; i < l; i++) {
            String w = dict.get(i);
            int len = w.length();
            TrieNode p = root;
            for (int j = 0; j < len; j++) {
                int index = w.charAt(j) - 'a';
                if (p.children[index] == null) {
                    p.children[index] = new TrieNode();
                }
                p = p.children[index];
            }
            p.isWord = true;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> ret;

        ret = s.wordBreak("a", Arrays.asList("a"));
        Assert.assertEquals(1, ret.size());

        ret = s.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
        Assert.assertEquals(2, ret.size());

        ret = s.wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                        "aaaaaaaaaa"));
        Assert.assertEquals(0, ret.size());

    }

}
