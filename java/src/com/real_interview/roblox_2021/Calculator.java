package com.real_interview.roblox_2021;

/*
You are building an educational website and want to create a simple calculator for students to use. The calculator will only allow addition and subtraction of non-negative integers.

1) Given an expression string using the "+", "-" operators like "5+16-2", write a function to parse the string and evaluate the result.

2) We also want to allow parentheses in our input. Given an expression string using the "+", "-", "(", and ")" operators like "5+(16-2)", write a function to parse the string and evaluate the result.

Sample output:
  calculate("5+16-((9-6)-(4-2))+1") => 21
  calculate("22+(2-4)") => 20
  calculate("6+9-12") => 3
  calculate("((1024))") => 1024
  calculate("1+(2+3)-(4-5)+6") => 13
  calculate("255") => 255

n: length of the input string
*/

public class Calculator {
    public static void main(String[] argv) {
        String expression2_1 = "5+16-((9-6)-(4-2))+1";
        String expression2_2 = "22+(2-4)";
        String expression2_3 = "6+9-12";
        String expression2_4 = "((1024))";
        String expression2_5 = "1+(2+3)-(4-5)+6";
        String expression2_6 = "255";

        System.out.println(test(expression2_1, 0)[0]);
        System.out.println(test(expression2_2, 0)[0]);
        System.out.println(test(expression2_3, 0)[0]);
        System.out.println(test(expression2_4, 0)[0]);
        System.out.println(test(expression2_5, 0)[0]);
        System.out.println(test(expression2_6, 0)[0]);
    }

    private static int[] test(String s, int j) {
        int op = 0, ret = 0, v = 0, i = j;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == '(') {
                int[] vv = test(s, i + 1);
                v = vv[0];
                i = vv[1];
            } else if (ch >= '0' && ch <= '9') {
                v = v * 10 + (ch - '0');
                i += 1;
            } else if (ch == ')') {
                return new int[]{ret + ((op == 1) ? -v : v), i + 1};
            } else {
                ret += (op == 1) ? -v : v;
                op = ch == '-' ? 1 : 0;
                v = 0;
                i += 1;
            }
        }

        return new int[]{ret += (op == 1) ? -v : v, s.length()};
    }
}