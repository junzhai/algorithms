package com.leetcode.maximumProductofWordLengths_318;

import org.junit.Assert;

abstract public class Solution {
    abstract public int maxProduct(String[] words);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new BruteForce(),
                new Trie_2(),
                new Trie_16(),
                new EnhancedBruteForce(),
                new EnhancedBruteForce_2(),
                new EnhancedBruteForce_3(),
                new EnhancedTrie_2(),
                new EnhancedTrie_2_2(),
                new EnhancedTrie_2_3(),
                new EnhancedTrie_16(),
                new EnhancedTrie_16_2(),
                new EnhancedTrie_64()
        };
        int ret;

        for (Solution s : solutions) {
            ret = s.maxProduct(new String[]{});
            Assert.assertEquals(0, ret);

            ret = s.maxProduct(new String[]{"abc", ""});
            Assert.assertEquals(0, ret);

            ret = s.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"});
            Assert.assertEquals(0, ret);

            ret = s.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"});
            Assert.assertEquals(4, ret);

            ret = s.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"});
            Assert.assertEquals(16, ret);

            ret = s.maxProduct(new String[]{"ccd", "accaceddeeeaefc", "bcaffa", "bbcfafbb", "accacfebbabbeedfbfdb",
                    "beddecbffcdaededdaefdedfdea", "cf", "ddafdcbd", "bbafacebacaefdaffccebddff",
                    "ebccffcddbeddccacceccaec",
                    "becfbfdccdfdeadfbfaddbcded", "cbabeaaeabefedbaeaedc", "dfadbbdbead", "cafaefdcd",
                    "eccdbfceafeeeacfcddc",
                    "dbabbcdbb", "abfbfbffcbebde", "cfaadaa", "fc", "faebcabb", "adbacebabcaaccbdeaffff", "aeaefccf",
                    "dbacbeeabdbcdfccabebaecfef", "ecdadeefcaddffaececffa", "defcabf", "abbcecbccbdaebaecaefabed",
                    "dfeeebcbaaefc", "aecccbcbbdddb", "dcfabacec", "fccfbacbacddeaaea", "dfdbfacbacbecb",
                    "cbfeebdbfecb",

                    "cffaacacbde", "aafd", "bdcebbbebd", "afeffadcfcdacfba", "dafeefbcdfaffcfacee",
                    "dcbbebfbedafedcdbab",
                    "cafaf", "bcbcccfdebdd", "efaaaacccff", "cffbead", "ebcfccfcddffdec", "fffdfdcec", "beeafefbdfa",
                    "cdfdbccfbaaeffcabab", "ddadcbabbcb", "decfaeabbecebaebeaddedae", "cdcbfffbebae",
                    "aeccefcbcbbddfdc",
                    "ffefedaf", "cddbabccafaffeafeedcbedbdad", "eddeeccfedcefadfdfebfacb", "aca", "ffdcafaddcddf", "ef",
                    "bbbbffe", "ffccfebabaadcffacbbb", "cbdeddfddffacbeeeebafebabda", "ddeecb", "cffdc", "edcffcebadf",
                    "becbcadcafddcfbbeeddbfffcab", "abcbaceeaeaddd", "cfeffceebfaeefadaaccfa", "eaccddb",
                    "caeafbfafecd",
                    "becaafdbaadbfecfdfde", "ecabaaeafbfbcbadaac", "bdcdffcfaeebeedfdfddfaf", "dbbfbaeecbfcdebad",
                    "cceecddeeecdbde", "beec", "adbcfdbfdbccdcffffbcffbec", "bbbbfe", "cdaedaeaad", "dadbfeafadd",
                    "fcacaaebcedfbfbcddfc", "ceecfedceac", "dada", "ccfdaeffbcfcc", "eadddbbbdfa", "beb",
                    "fcaaedadabbbeacabefdabe", "dfcddeeffbeec", "defbdbeffebfceaedffbfee", "cffadadfbaebfdbadebc",
                    "fbbadfccbeffbdeabecc", "bdabbffeefeccb", "bdeeddc", "afcbacdeefbcecff", "cfeaebbbadacbced",
                    "edfddfedbcfecfedb", "faed", "cbcdccfcbdebabc", "efb", "dbddadfcddbd",
                    "fbaefdfebeeacbdfbdcdddcbefc",
                    "cbbfaccdbffde", "adbcabaffebdffad"});
            Assert.assertEquals(39, ret);
        }
    }
}
