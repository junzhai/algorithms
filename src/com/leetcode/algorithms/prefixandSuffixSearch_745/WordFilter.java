package com.leetcode.algorithms.prefixandSuffixSearch_745;

import org.junit.Assert;

abstract class WordFilter {
    abstract public int f(String prefix, String suffix);

    public static void main(String[] args) {
        String[] words;
        int ret;
        WordFilter f;


        words = new String[]{"pop"};
//        f = new BitMapTrie(words);
//        f = new Trie_2D(words);
        f = new Trie_differentInsertion(words);

        ret = f.f("", "");
        Assert.assertEquals(0, ret);
        ret = f.f("", "p");
        Assert.assertEquals(0, ret);
        ret = f.f("", "op");
        Assert.assertEquals(0, ret);
        ret = f.f("", "pop");
        Assert.assertEquals(0, ret);
        ret = f.f("p", "");
        Assert.assertEquals(0, ret);
        ret = f.f("p", "p");
        Assert.assertEquals(0, ret);
        ret = f.f("p", "op");
        Assert.assertEquals(0, ret);
        ret = f.f("p", "pop");
        Assert.assertEquals(0, ret);
        ret = f.f("po", "");
        Assert.assertEquals(0, ret);
        ret = f.f("po", "p");
        Assert.assertEquals(0, ret);
        ret = f.f("po", "op");
        Assert.assertEquals(0, ret);
        ret = f.f("po", "pop");
        Assert.assertEquals(0, ret);
        ret = f.f("pop", "");
        Assert.assertEquals(0, ret);
        ret = f.f("pop", "p");
        Assert.assertEquals(0, ret);
        ret = f.f("pop", "op");
        Assert.assertEquals(0, ret);
        ret = f.f("pop", "pop");
        Assert.assertEquals(0, ret);
        ret = f.f("", "");
        Assert.assertEquals(0, ret);
        ret = f.f("", "p");
        Assert.assertEquals(0, ret);
        ret = f.f("", "gp");
        Assert.assertEquals(-1, ret);
        ret = f.f("", "pgp");
        Assert.assertEquals(-1, ret);
        ret = f.f("p", "");
        Assert.assertEquals(0, ret);
        ret = f.f("p", "p");
        Assert.assertEquals(0, ret);
        ret = f.f("p", "gp");
        Assert.assertEquals(-1, ret);
        ret = f.f("p", "pgp");
        Assert.assertEquals(-1, ret);
        ret = f.f("pg", "");
        Assert.assertEquals(-1, ret);
        ret = f.f("pg", "p");
        Assert.assertEquals(-1, ret);
        ret = f.f("pg", "gp");
        Assert.assertEquals(-1, ret);
        ret = f.f("pg", "pgp");
        Assert.assertEquals(-1, ret);
        ret = f.f("pgp", "");
        Assert.assertEquals(-1, ret);
        ret = f.f("pgp", "p");
        Assert.assertEquals(-1, ret);
        ret = f.f("pgp", "gp");
        Assert.assertEquals(-1, ret);
        ret = f.f("pgp", "pgp");
        Assert.assertEquals(-1, ret);


        words = new String[]{"abbbababbb", "baaabbabbb", "abababbaaa", "abbbbbbbba",
                "bbbaabbbaa", "ababbaabaa", "baaaaabbbb", "babbabbabb", "ababaababb", "bbabbababa"};

//        WordFilter f = new BitMapTrie(words);
        f = new Trie_2D(words);
        ret = f.f("", "aa");
        Assert.assertEquals(5, ret);

        ret = f.f("", "abaa");
        Assert.assertEquals(5, ret);
        ret = f.f("babbab", "");
        Assert.assertEquals(7, ret);
        ret = f.f("ab", "baaa");
        Assert.assertEquals(2, ret);
        ret = f.f("baaabba", "b");
        Assert.assertEquals(1, ret);
        ret = f.f("abab", "abbaabaa");
        Assert.assertEquals(5, ret);
        ret = f.f("", "bba");
        Assert.assertEquals(3, ret);
        ret = f.f("", "baaaaabbbb");
        Assert.assertEquals(6, ret);
        ret = f.f("ba", "aabbbb");
        Assert.assertEquals(6, ret);
        ret = f.f("baaa", "aabbabbb");
        Assert.assertEquals(1, ret);


        //         f = new BigMap(new String[]{"apple"});
        f = new BitMapTrie(new String[]{"apple"});
        ret = f.f("a", "e");
        Assert.assertEquals(0, ret);
    }
}