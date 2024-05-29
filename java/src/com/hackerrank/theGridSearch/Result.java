package com.hackerrank.theGridSearch;

import com.pattern.algorithms.KMP;

import java.util.List;

@KMP
public class Result {
    /*
     * Complete the 'gridSearch' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY G
     *  2. STRING_ARRAY P
     */

    public static String gridSearch(List<String> G, List<String> P) {
        int C = G.get(0).length();
        int c = P.get(0).length();
        int[] pv = calculateKMPVector(P);

        for (int i = 0; i <= C - c; i++) {
            if (kmp(G, i, P, pv)) {
                return "YES";
            }
        }

        return "NO";
    }

    private static int[] calculateKMPVector(List<String> P) {
        int[] ret = new int[P.size()];
        ret[0] = -1;
        for (int i = 1; i < ret.length - 1; i++) {
            int j = ret[i];
            while (j >= 0 && !P.get(j).equalsIgnoreCase(P.get(i))) {
                j = ret[j];
            }
            ret[i + 1] = j + 1;
        }
        return ret;
    }

    private static boolean kmp(List<String> G, int i, List<String> P, int[] pv) {
        int c = P.get(0).length();
        for (int g = 0, p = 0; g < G.size(); g++) {
            while (p >= 0 && !G.get(g).substring(i, i + c).equalsIgnoreCase(P.get(p))) {
                p = pv[p];
            }
            p += 1;
            if (p == P.size()) {
                return true;
            }
        }
        return false;
    }
}
