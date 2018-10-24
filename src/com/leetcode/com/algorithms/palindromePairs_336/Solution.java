package com.leetcode.com.algorithms.palindromePairs_336;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

abstract public class Solution {
    abstract public List<List<Integer>> palindromePairs(String[] words);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
                new HashMap(),
                new Trie()
        };

        List<List<Integer>> ret, expect;
        for (Solution s : solutions) {
            // [[0,1],[1,0]]
            ret = s.palindromePairs(new String[]{"a", ""});
            expect = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 0));
            assertTrue(expect.size() == ret.size() && expect.containsAll(ret) && ret.containsAll(expect));

            // [[0,1],[1,0]]
            ret = s.palindromePairs(new String[]{"bat", "tab", "cat"});
            expect = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 0));
            assertTrue(expect.size() == ret.size() && expect.containsAll(ret) && ret.containsAll(expect));

            ret = s.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
            expect = Arrays.asList(
                    Arrays.asList(0, 1),
                    Arrays.asList(1, 0),
                    Arrays.asList(3, 2),
                    Arrays.asList(2, 4));
            assertTrue(expect.size() == ret.size() && expect.containsAll(ret) && ret.containsAll(expect));

            ret = s.palindromePairs(new String[]{
                    "ajdhjaefgjaebadg"
                    , "bjjdac", "ebhc", "jghbcfdifacffjajeb",
                    "ebgiabbbeajh", "jcffagcijagjdd",
                    "cgcdcbhdbedhh", "eibgeiaghdehgdbgighe",
                    "agajidfchfebdfcgj",
                    "fjgaajfchhijgdd", "beibeiafjjbcf", "hiiafi", "haiiijfhedchfj",
                    "bcdhehg", "cdcjfdadcciceebdecff",
                    "jhdjabebcieabd", "cgbdbfaihegdifgchf", "jidjdedffedbdaii",
                    "ccdiahaceiihecafecj", "bahhc", "dcgfbg",
                    "abjjcbadgccibgcebc", "aiicgeca", "adbjaecaeafgbdfehg",
                    "affj", "cjbe", "e", "chif", "cjij", "dge",
                    "hafdifafifefgjd", "cahbeiiicdb", "ghifhddaggjfghjfhjc",
                    "hcdaebaiebbhbgeihfec", "idhfceicdehchj",
                    "jjfcce", "fgjidcbijbgaj", "habdbfh", "ghdjbheggib", "i",
                    "icbfih", "dfb", "aajhbahgidb", "fgfdbgjhdde",
                    "ajcaiggfifafgech", "ejdcbdeadhcfcbhcgh", "bh", "d",
                    "eeigjafgffcdiibdgg",
                    "fhhhgbddhibfb",
                    "dgehidgjedehgjiicibe",
                    "dibagciedhjjeiibeihg",
                    "jffhbehbhdighe",
                    "fa",
                    "hiaebaabh",
                    "aajde",
                    "ehifhadchfgcgjaadd",
                    "ahgdjfedcfjc",
                    "hadcbaijfa", "ifegdd",
                    "fchdfighceehhed", "achdhaidbhiie", "jhcdfafjhdjg",
                    "ide", "ffgfec", "jdjaeii", "gfajdjbdjifdhgj",
                    "ajed",
                    "jhfcb",
                    "chhbejjejie", "gbfd",
                    "afbffejcciaafgcacf",
                    "ijfd",
                    "dg",
                    "dibdjhcfiea",
                    "gbcdjacjjeeaibaahcj",
                    "igcadcahdcajejjhbdj",
                    "agfdhbfeagbbbaijfgbe",
                    "ajifaceefedgjaeja",
                    "jhebhabehebffdfih",
                    "icheeehdfjh",
                    "g",
                    "hf",
                    "cijbdefgdjcaj",
                    "fjegffdhcjfhefjb",
                    "jihedcbf", "hcghgadaffbhd",
                    "fjbaabffeaf", "ffjfbdcafdde",
                    "hebgbhfdd", "aagf",
                    "jhbcid", "aejgjdhbchije",
                    "hicjeddbhjijc", "bi", "jh",
                    "ccebbcdiajafgj",
                    "caf",
                    "cjhiafe",
                    "iccjgacbeb",
                    "gdjjcgbbgacighd",
                    "achbaiejjgi",
                    "aej",
                    "agigfhdfjhfjicfjahh",
                    "jjhhceihcd",
                    "jhihjggdajibeeifijbc",
                    "hbdhijijhgbei",
                    "bddfcageiijcbcjgfga",
                    "jdeejgbeiaebb",
                    "hffj",
                    "cj",
                    "jhgjeaiidebjafegcic",
                    "fhjbdb",
                    "jagffbchb",
                    "deh",
                    "aghbfb",
                    "gdijdjihbebbfhd",
                    "fhii",
                    "cjajdaifbfjee",
                    "dij",
                    "bffihiadibhjfibgeb",
                    "fbehgdccjhffihafhef",
                    "gidechad",
                    "fbfic",
                    "bgecggbj",
                    "be",
                    "bedhcgdhijgiigbibab",
                    "fh",
                    "ee",
                    "f"});

            expect = Arrays.asList(
                    Arrays.asList(53, 129), Arrays.asList(41, 70),
                    Arrays.asList(73, 47), Arrays.asList(81, 73), Arrays.asList(129, 82),
                    Arrays.asList(82, 127), Arrays.asList(39, 94), Arrays.asList(53, 97),
                    Arrays.asList(117, 82), Arrays.asList(26, 125), Arrays.asList(127, 129),
                    Arrays.asList(127, 82), Arrays.asList(128, 26), Arrays.asList(26, 128));
            assertTrue(expect.size() == ret.size() && expect.containsAll(ret) && ret.containsAll(expect));
        }
    }
}
