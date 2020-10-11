package com.leetcode.algorithms.gridIllumination_1001;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Time Limit Exceeded
 */
public class UseMapSet extends Solution {
    @Override
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        Map<Integer, Set<Integer>> lampMap = new HashMap<>();
        for (int[] lamp : lamps) {
            if (!lampMap.containsKey(lamp[0])) {
                lampMap.put(lamp[0], new HashSet<>());
            }
            Set<Integer> lampSet = lampMap.get(lamp[0]);
            lampSet.add(lamp[1]);
        }

        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            boolean luminated = false;

            Set<Integer> lampSet = lampMap.get(x);
            if (lampSet != null && !lampSet.isEmpty()) {
                luminated = true;
                lampSet.remove(y - 1);
                lampSet.remove(y);
                lampSet.remove(y + 1);
            }

            lampSet = lampMap.get(x - 1);
            if (lampSet != null) {
                luminated = luminated || lampSet.contains(y - 1) || lampSet.contains(y) || lampSet.contains(y + 1);
                lampSet.remove(y - 1);
                lampSet.remove(y);
                lampSet.remove(y + 1);
            }

            lampSet = lampMap.get(x + 1);
            if (lampSet != null) {
                luminated = luminated || lampSet.contains(y - 1) || lampSet.contains(y) || lampSet.contains(y + 1);
                lampSet.remove(y - 1);
                lampSet.remove(y);
                lampSet.remove(y + 1);
            }

            for (int xx : lampMap.keySet()) {
                if (luminated) {
                    break;
                }

                if (xx == x || xx == x - 1 || xx == x + 1) {
                    continue;
                }

                lampSet = lampMap.get(xx);
                int diff = Math.abs(x - xx);
                luminated = lampSet.contains(y) || lampSet.contains(y + diff) || lampSet.contains(y - diff);
            }

            ret[i] = luminated ? 1 : 0;
        }

        return ret;
    }
}
