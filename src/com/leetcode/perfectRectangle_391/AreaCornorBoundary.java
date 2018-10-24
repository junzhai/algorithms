package com.leetcode.perfectRectangle_391;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AreaCornorBoundary extends Solution {
    private void add(Map<String, Integer> m, String k) {
        if (m.containsKey(k)) {
            m.put(k, m.get(k) + 1);
        } else {
            m.put(k, 1);
        }
    }

    @Override
    public boolean isRectangleCover(int[][] rectangles) {
        int[] bound = Arrays.copyOf(rectangles[0], 4);
        Map<String, Integer> cornor = new HashMap<>();
        int area = 0;
        for (int[] r : rectangles) {
            area += (r[2] - r[0]) * (r[3] - r[1]);
            bound[0] = Math.min(bound[0], r[0]);
            bound[1] = Math.min(bound[1], r[1]);
            bound[2] = Math.max(bound[2], r[2]);
            bound[3] = Math.max(bound[3], r[3]);
            add(cornor, r[0] + "," + r[1]);
            add(cornor, r[2] + "," + r[1]);
            add(cornor, r[0] + "," + r[3]);
            add(cornor, r[2] + "," + r[3]);
        }
        if (area != (bound[2] - bound[0]) * (bound[3] - bound[1])) {
            return false;
        }

        String k = bound[0] + "," + bound[1];
        if (!cornor.containsKey(k) || cornor.remove(k) != 1) {
            return false;
        }
        k = bound[0] + "," + bound[3];
        if (!cornor.containsKey(k) || cornor.remove(k) != 1) {
            return false;
        }
        k = bound[2] + "," + bound[1];
        if (!cornor.containsKey(k) || cornor.remove(k) != 1) {
            return false;
        }
        k = bound[2] + "," + bound[3];
        if (!cornor.containsKey(k) || cornor.remove(k) != 1) {
            return false;
        }

        for (String key : cornor.keySet()) {
            int c = cornor.get(key);
            if (c != 2 && c != 4) {
                return false;
            }
        }
        return true;
    }
}
