package com.real_interview.twilio_2021;

import java.util.Arrays;
import java.util.List;

public class ConnectedGraph {
    // Node count from 1;
    public int solution(int grpahCount, List<Integer> from, List<Integer> to) {
        int[] parent = new int[grpahCount + 1], count = new int[grpahCount + 1];
        Arrays.fill(count, 1);
        for (int i = 0; i < from.size(); i++) {
            int a = from.get(i), b = from.get(i);
            while (parent[a] != 0) {
                a = parent[a];
            }

            while (parent[b] != 0) {
                b = parent[b];
            }

            if (a != b) {
                parent[b] = a;
                count[a] += count[b];
                count[b] = 0;
            }
        }

        int ret = 0;
        for (int v : count) {
            if (v != 0) {
                ret += Math.ceil(Math.sqrt(v));
            }
        }

        return ret;
    }
}
