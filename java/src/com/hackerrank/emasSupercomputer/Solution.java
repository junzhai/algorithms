package com.hackerrank.emasSupercomputer;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("C://GitHub//algorithms//java//src//com//hackerrank//emasSupercomputer//testcase10");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int result = Result.twoPluses(grid);
        bufferedReader.close();
    }
}
