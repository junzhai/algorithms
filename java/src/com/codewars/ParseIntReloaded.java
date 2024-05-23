package com.codewars;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseIntReloaded {

    public static int parseInt(String numStr) {
        Map<String, Integer> number = new HashMap<>();
        number.put("zero", 0);
        number.put("one", 1);
        number.put("two", 2);
        number.put("three", 3);
        number.put("four", 4);
        number.put("five", 5);
        number.put("six", 6);
        number.put("seven", 7);
        number.put("eight", 8);
        number.put("nine", 9);
        number.put("ten", 10);
        number.put("eleven", 11);
        number.put("twelve", 12);
        number.put("thirteen", 13);
        number.put("fourteen", 14);
        number.put("fifteen", 15);
        number.put("sixteen", 16);
        number.put("seventeen", 17);
        number.put("eighteen", 18);
        number.put("nineteen", 19);
        number.put("twenty", 20);
        number.put("thirty", 30);
        number.put("forty", 40);
        number.put("fifty", 50);
        number.put("sixty", 60);
        number.put("seventy", 70);
        number.put("eighty", 80);
        number.put("ninety", 90);

        String[] nums = numStr.split(" ");
        List<Integer> rets = new ArrayList<>();
        int ret = 0;
        for (String num : nums) {
            if (num.indexOf('-') >= 0) {
                String[] v = num.split("-");
                ret += number.get(v[0]) + number.get(v[1]);
            } else if (number.containsKey(num)) {
                ret += number.get(num);
            } else if ("hundred".equalsIgnoreCase(num)) {
                ret *= 100;
            } else if ("thousand".equalsIgnoreCase(num)) {
                ret *= 1000;
                rets.add(ret);
                ret = 0;
            } else if ("million".equalsIgnoreCase(num)) {
                ret *= 1000000;
                rets.add(ret);
                ret = 0;
            }
        }
        rets.add(ret);

        ret = 0;
        for (int v : rets) {
            ret += v;
        }
        return ret;
    }

    public static void main(String[] args) {
        int ret;
        ret = parseInt("one thousand three hundred thirty-three");
        Assert.assertEquals(1333, ret);

        ret = parseInt("five hundred fifty-nine thousand three hundred fifty-eight");
        Assert.assertEquals(559358, ret);

        ret = parseInt("six hundred sixty-six thousand six hundred sixty-six");
        Assert.assertEquals(666666, ret);
    }
}
