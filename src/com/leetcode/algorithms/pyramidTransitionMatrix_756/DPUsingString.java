package com.leetcode.algorithms.pyramidTransitionMatrix_756;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DPUsingString extends Solution {
    @Override
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int len = bottom.length() - 1;
        String[][][] mapping = new String[7][7][0];
        for (String a : allowed) {
            String[] t = mapping[a.charAt(0) - 'A'][a.charAt(1) - 'A'];
            t = Arrays.copyOf(t, t.length + 1);
            t[t.length - 1] = a;
            mapping[a.charAt(0) - 'A'][a.charAt(1) - 'A'] = t;
        }

        String[][] dp = new String[len][];
        for (int i = 0; i < len; i++) {
            String[] m = mapping[bottom.charAt(i) - 'A'][bottom.charAt(i + 1) - 'A'];
            if (m.length == 0) {
                return false;
            }
            dp[i] = Arrays.copyOf(m, m.length);
        }

        Set<String> tt = new HashSet<>();
        while (len > 1) {
            for (int i = 0; i < len - 1; i++) {
                String[] arr1 = dp[i], arr2 = dp[i + 1];
                for (String a1 : arr1) {
                    for (String a2 : arr2) {
                        if (a1.charAt(1) == a2.charAt(0)) {
                            String[] m = mapping[a1.charAt(2) - 'A'][a2.charAt(2) - 'A'];
                            tt.addAll(Arrays.asList(m));
                        }
                    }
                }
                if (tt.size() == 0) {
                    return false;
                }
                dp[i] = tt.toArray(new String[0]);
                tt.clear();
            }
            len -= 1;
        }
        return true;
    }
}
