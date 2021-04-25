package com.leetcode.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LargeCaseUtil {
    public static int[] readArray(String fileName) {
        List<Integer> list = new ArrayList<>();
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line = reader.readLine();
                while (line != null) {
                    String[] arry = line.split(",");
                    for (String item : arry) {
                        list.add(Integer.parseInt(item.trim()));
                    }
                    line = reader.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public static String readString(String fileName) {
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                return reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
