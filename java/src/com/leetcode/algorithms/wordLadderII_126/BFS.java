package com.leetcode.algorithms.wordLadderII_126;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

@com.leetcode.algorithms.pattern.BFS
public class BFS extends Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<Character> chars = new HashSet<>();
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String w = wordList.get(i);
            dict.put(w, i);
            for (char c : w.toCharArray()) {
                chars.add(c);
            }
        }

        List<List<String>> ret = new ArrayList<>();
        if (!dict.containsKey(endWord)) {
            return ret;
        }

        int len = wordList.size(), wlen = beginWord.length();
        int[] step = new int[len];
        int[][] path = new int[len][len];
        Queue<Integer> q = new LinkedList<>();

        StringBuilder builder = new StringBuilder(beginWord);
        for (int i = 0; i < wlen; i++) {
            char old = builder.charAt(i);
            for (char c : chars) {
                builder.setCharAt(i, c);
                String nw = builder.toString();
                if (dict.containsKey(nw)) {
                    int index = dict.get(nw);
                    step[index] = 1;
                    q.offer(index);
                }
            }
            builder.setCharAt(i, old);
        }

        while (!q.isEmpty()) {
            int index = q.poll();
            String w = wordList.get(index);
            if (w.equals(endWord)) {
                break;
            }
            int st = step[index];
            StringBuilder sb = new StringBuilder(w);
            for (int i = 0; i < wlen; i++) {
                char old = sb.charAt(i);
                for (char c : chars) {
                    sb.setCharAt(i, c);
                    String nw = sb.toString();
                    if (dict.containsKey(nw)) {
                        int ni = dict.get(nw);
                        if (step[ni] == 0 || step[ni] == st + 1) {
                            if (step[ni] == 0) {
                                step[ni] = st + 1;
                                q.offer(ni);
                            }
                            path[ni][path[ni][0] + 1] = index;
                            path[ni][0] += 1;
                        }
                    }
                }
                sb.setCharAt(i, old);
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

    private void helper(List<List<String>> ret,
                        int[] buf,
                        int len,
                        String bw,
                        List<String> wordList,
                        int[][] path) {
        int index = buf[len - 1];
        if (path[index][0] == 0) {
            List<String> l = new ArrayList<>();
            l.add(bw);
            for (int i = len - 1; i >= 0; i--) {
                l.add(wordList.get(buf[i]));
            }
            ret.add(l);
            return;
        }

        for (int i = 0; i < path[index][0]; i++) {
            buf[len] = path[index][i + 1];
            helper(ret, buf, len + 1, bw, wordList, path);
        }
    }
}
