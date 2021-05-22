package com.leetcode.algorithms.soupServings_808;

import com.pattern.algorithms.DP;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@DP
public class DPScanN extends Solution {
    @Override
    public double soupServings(int N) {
        int target = N % 1;
        Map<String, double[]> dp = new HashMap<>(), tmp = new HashMap<>();
        dp.put("0.0", new double[]{0, 0, 1});

        double ret = 0;
        while (target <= N) {
            double afirst = 0, equal = 0;
            tmp.clear();
            Iterator<String> it = dp.keySet().iterator();
            while (it.hasNext()) {
                String k = it.next();
                double[] v = dp.get(k);
                if (v[0] >= target && v[1] >= target) {
                    equal += v[2];
                } else if (v[0] >= target) {
                    afirst += v[2];
                } else if (v[0] < target && v[1] < target) {
                    it.remove();
                    double[] r = push(tmp, v, target);
                    afirst += r[0];
                    equal += r[1];
                }
            }
            ret = afirst + equal / 2;
            if (1 - ret < 0.000001) {
                return 1;
            }

            for (String k : tmp.keySet()) {
                double[] v = tmp.get(k);
                if (dp.containsKey(k)) {
                    dp.get(k)[2] += v[2];
                } else {
                    dp.put(k, v);
                }
            }
            target += 1;
        }

        return ret;
    }

    private double[] push(Map<String, double[]> dp, double[] v, int target) {
        if (v[0] < target && v[1] < target) {
            double[] ret = new double[2];
            double np = v[2] / 4;
            double[] r = push(dp, new double[]{v[0] + 100, v[1], np}, target);
            ret[0] += r[0];
            ret[1] += r[1];
            r = push(dp, new double[]{v[0] + 75, v[1] + 25, np}, target);
            ret[0] += r[0];
            ret[1] += r[1];
            r = push(dp, new double[]{v[0] + 50, v[1] + 50, np}, target);
            ret[0] += r[0];
            ret[1] += r[1];
            r = push(dp, new double[]{v[0] + 25, v[1] + 75, np}, target);
            ret[0] += r[0];
            ret[1] += r[1];
            return ret;
        }

        String k = (int) v[0] + "." + (int) v[1];
        if (v[0] >= target && v[1] >= target) {
            if (dp.containsKey(k)) {
                dp.get(k)[2] += v[2];
            } else {
                dp.put(k, v);
            }
            return new double[]{0, v[2]};
        }

        if (v[0] >= target) {
            if (dp.containsKey(k)) {
                dp.get(k)[2] += v[2];
            } else {
                dp.put(k, v);
            }
            return new double[]{v[2], 0};
        }

        if (dp.containsKey(k)) {
            dp.get(k)[2] += v[2];
        } else {
            dp.put(k, v);
        }
        return new double[]{0, 0};
    }
}
