package com.leetcode.algorithms.wordLadderII_126;

import com.pattern.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@BFS
public class BFS2 extends Solution {
    public class Trie {
        int index;
        Trie[] children = new Trie[26];

        Trie(int index) {
            this.index = index;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> dict = new HashMap<>();
        Trie root = new Trie(-1);
        for (int i = 0; i < wordList.size(); i++) {
            String w = wordList.get(i);
            dict.put(w, i);
            Trie p = root;
            for (int k = 0; k < w.length(); k++) {
                int pos = w.charAt(k) - 'a';
                if (p.children[pos] == null) {
                    p.children[pos] = k == w.length() - 1 ? new Trie(i) : new Trie(-1);
                }
                p = p.children[pos];
            }
        }

        List<List<String>> ret = new ArrayList<>();
        if (!dict.containsKey(endWord)) {
            return ret;
        }

        int len = wordList.size(), wlen = beginWord.length();
        int[] step = new int[len];
        int[][] path = new int[len][0];
        Queue<Integer> q = new LinkedList<>();

        for (int i : getChildren(root, beginWord, wlen)) {
            step[i] = 1;
            q.offer(i);
        }

        while (!q.isEmpty()) {
            int index = q.poll();
            String w = wordList.get(index);
            if (w.equals(endWord)) {
                break;
            }
            int st = step[index];
            for (int i : getChildren(root, w, wlen)) {
                if (step[i] == 0 || step[i] == st + 1) {
                    if (step[i] == 0) {
                        step[i] = st + 1;
                        q.offer(i);
                    }
                    int[] arr = path[i];
                    arr = Arrays.copyOf(arr, arr.length + 1);
                    arr[arr.length - 1] = index;
                    path[i] = arr;
                }
            }
        }

        if (step[dict.get(endWord)] == 0) {
            return ret;
        }

        int[] buf = new int[wordList.size()];
        buf[0] = dict.get(endWord);
        helper(ret, buf, 1, beginWord, wordList, path);
        return ret;
    }

    private List<Integer> getChildren(Trie root, String w, int wlen) {
        List<Integer> ret = new ArrayList<>();
        Trie p = root;
        for (int i = 0; i < wlen; i++) {
            int target = w.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                if (j != target) {
                    Trie pp = p.children[j];
                    int k = i + 1;
                    while (pp != null && k < wlen) {
                        pp = pp.children[w.charAt(k) - 'a'];
                        k += 1;
                    }
                    if (pp != null) {
                        ret.add(pp.index);
                    }
                }
            }
            p = p.children[target];
            if (p == null) {
                break;
            }
        }
        return ret;
    }

    private void helper(List<List<String>> ret,
                        int[] buf,
                        int len,
                        String bw,
                        List<String> wordList,
                        int[][] path) {
        int index = buf[len - 1];
        if (path[index].length == 0) {
            List<String> l = new ArrayList<>();
            l.add(bw);
            for (int i = len - 1; i >= 0; i--) {
                l.add(wordList.get(buf[i]));
            }
            ret.add(l);
            return;
        }

        for (int i : path[index]) {
            buf[len] = i;
            helper(ret, buf, len + 1, bw, wordList, path);
        }
    }
}
