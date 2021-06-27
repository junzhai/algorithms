package com.real_interview.noom_2021;

/**
 * 3 job types: coaching, supporting, managing
 * 2 type of schedules: baseline {coaching: 50%, managing:50%}, temporary{coaching: 25%, support: 25%, managing: 50%}
 * temporary has start, end time and there is no overlap;
 */
public class JobTypeDistribution {
    private static class Temporary {
        long start, end;
        double[] alloc;

        Temporary(long start, long end, double[] alloc) {
            this.start = start;
            this.end = end;
            this.alloc = alloc;
        }
    }

    // Report total job type allocation in a range.
    public double[] solution(long start, long end, double[] baseline, Temporary[] temporaries) {
        double[] ret = new double[3];
        int total = (int) ((end - start) / 24 / 60 / 60), remain = total;
        for (Temporary t : temporaries) {
            if (t.start >= end || t.end <= start) {
                continue;
            }

            int d = (int) (Math.min(end, t.end) - Math.max(start, t.start)) / 24 / 60 / 60;
            for (int i = 0; i < 3; i++) {
                ret[i] += t.alloc[i] * d;
            }

            remain -= d;
        }

        for (int i = 0; i < 3; i++) {
            ret[i] += remain * baseline[i];
        }

        for (int i = 0; i < 3; i++) {
            ret[i] /= total;
        }

        return ret;
    }
}
