package com.codewars;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecretDetective {
    public static class CharNode {
        char ch;
        int inDegree;
        List<CharNode> children;

        public CharNode(char ch) {
            this.ch = ch;
            children = new ArrayList<>();
        }
    }

    public String recoverSecret(char[][] triplets) {
        Map<Character, CharNode> nodes = new HashMap<>();
        for (char[] triplet : triplets) {
            if (!nodes.containsKey(triplet[0])) {
                nodes.put(triplet[0], new CharNode(triplet[0]));
            }
            CharNode a = nodes.get(triplet[0]);

            if (!nodes.containsKey(triplet[1])) {
                nodes.put(triplet[1], new CharNode(triplet[1]));
            }
            CharNode b = nodes.get(triplet[1]);

            if (!nodes.containsKey(triplet[2])) {
                nodes.put(triplet[2], new CharNode(triplet[2]));
            }
            CharNode c = nodes.get(triplet[2]);

            a.children.add(b);
            b.inDegree += 1;
            b.children.add(c);
            c.inDegree += 1;
        }

        char ch = 'a';
        for (char c : nodes.keySet()) {
            if (nodes.get(c).inDegree == 0) {
                ch = c;
                break;
            }
        }

        char[] ret = new char[nodes.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = ch;
            CharNode p = nodes.get(ch);
            for (CharNode child : p.children) {
                child.inDegree -= 1;
                if (child.inDegree == 0) {
                    ch = child.ch;
                }
            }
        }

        return String.valueOf(ret);
    }

    public static void main(String[] args) {
        char[][] triplets = {
                {'t','u','p'},
                {'w','h','i'},
                {'t','s','u'},
                {'a','t','s'},
                {'h','a','p'},
                {'t','i','s'},
                {'w','h','s'}
        };

        SecretDetective sd = new SecretDetective();
        Assert.assertEquals("whatisup", sd.recoverSecret(triplets));
    }
}