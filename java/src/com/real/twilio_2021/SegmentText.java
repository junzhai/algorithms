package com.real.twilio_2021;

import java.util.ArrayList;
import java.util.List;

public class SegmentText {
    // Break string into segments with suffix. Segment's max len = 160, adding suffix (1/200) to each segment. If
    // message is shorter than or equal to 160, don't add suffix
    public List<String> solution(String message) {
        List<String> ret = new ArrayList<>();
        StringBuilder segment = new StringBuilder(), word = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch == ' ' || ch == '.' || ch == ',') {
                if (word.length() > 0) {
                    String w = word.toString();
                    word.setLength(0);
                    if (w.length() + segment.length() > 160) {
                        ret.add(segment.toString());
                        segment.setLength(0);
                    }
                    segment.append(w);
                }
                if (segment.length() + 1 > 160) {
                    ret.add(segment.toString());
                    segment.setLength(0);
                }
                segment.append(ch);
            } else {
                word.append(ch);
            }
        }

        if (word.length() > 0) {
            String w = word.toString();
            if (w.length() + segment.length() > 160) {
                ret.add(segment.toString());
                segment.setLength(0);
            }
            segment.append(w);
        }

        if (segment.length() > 0) {
            ret.add(segment.toString());
        }

        if (ret.size() == 1) {
            return ret;
        }

        int oldTotal = 1, newTotal = ret.size();
        while (oldTotal < newTotal) {
            adjust(ret, newTotal);
            oldTotal = newTotal;
            newTotal = ret.size();
        }

        for (int i = 0; i < ret.size(); i++) {
            ret.set(i, ret.get(i) + "(" + (i + 1) + "/" + oldTotal + ")");
        }

        return ret;
    }

    private void adjust(List<String> ret, int total) {
        String left = "";
        int i = 0, len = ret.size();
        while (i < len) {
            String suffix = "(" + (i + 1) + "/" + total + ")";
            int maxLen = 160 - suffix.length();
            if (left.length() >= maxLen) {
                ret.add(i, left.substring(0, maxLen));
                i += 1;
                len += 1;
                left = left.substring(maxLen);
                continue;
            }

            String w = left + ret.get(i);
            if (w.length() <= maxLen) {
                ret.set(i, w);
                left = "";
                i += 1;
                continue;
            }

            ret.set(i, w.substring(0, maxLen));
            left = w.substring(maxLen);
            i += 1;
        }

        if (left.length() > 0) {
            ret.add(left);
        }
    }
}
