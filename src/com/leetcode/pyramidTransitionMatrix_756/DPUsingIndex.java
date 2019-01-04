package com.leetcode.pyramidTransitionMatrix_756;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DPUsingIndex extends Solution {
    @Override
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int len = bottom.length() - 1;
        Integer[][][] mapping = new Integer[7][7][0];
        for (String a : allowed) {
            Integer[] t = mapping[a.charAt(0) - 'A'][a.charAt(1) - 'A'];
            t = Arrays.copyOf(t, t.length + 1);
            t[t.length - 1] = allowed.indexOf(a);
            mapping[a.charAt(0) - 'A'][a.charAt(1) - 'A'] = t;
        }

        Integer[][] dp = new Integer[len][];
        for (int i = 0; i < len; i++) {
            Integer[] m = mapping[bottom.charAt(i) - 'A'][bottom.charAt(i + 1) - 'A'];
            if (m.length == 0) {
                return false;
            }
            dp[i] = Arrays.copyOf(m, m.length);
        }

        Set<Integer> tt = new HashSet<>();
        while (len > 1) {
            for (int i = 0; i < len - 1; i++) {
                Integer[] arr1 = dp[i], arr2 = dp[i + 1];
                for (int a1 : arr1) {
                    for (int a2 : arr2) {
                        String s1 = allowed.get(a1), s2 = allowed.get(a2);
                        if (s1.charAt(1) == s2.charAt(0)) {
                            Integer[] m = mapping[s1.charAt(2) - 'A'][s2.charAt(2) - 'A'];
                            tt.addAll(Arrays.asList(m));
                        }
                    }
                }
                if (tt.size() == 0) {
                    return false;
                }
                dp[i] = tt.toArray(new Integer[0]);
                tt.clear();
            }
            len -= 1;
        }
        return true;
    }
}
