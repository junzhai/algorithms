package com.codewars;

import com.pattern.algorithms.MatrixExponentiation;

import java.math.BigInteger;

@MatrixExponentiation
public class TheMillionthFibonacciKata {
    public static BigInteger fib(BigInteger n) {
        int v = n.intValue();
        return switch (v) {
            case 0 -> BigInteger.ZERO;
            case -1, 1, 2 -> BigInteger.ONE;
            default -> v > 0 ? positiveMatrixExponentiation(v - 1)[0][0] : negativeMatrixExponentiation(-v - 1)[0][0];
        };

    }

    // f(N) =   |f(2), f(1)|   *   |1, 1| ^ (N - 2)
    //          |f(1), f(0)|       |1, 0|
    private static BigInteger[][] positiveMatrixExponentiation(int n) {
        if (n == 1) {
            return new BigInteger[][]{
                    {BigInteger.ONE, BigInteger.ONE},
                    {BigInteger.ONE, BigInteger.ZERO}
            };
        }

        if (n % 2 == 0) {
            BigInteger[][] t = positiveMatrixExponentiation(n / 2);
            return new BigInteger[][]{
                    {t[0][0].multiply(t[0][0]).add(t[0][1].multiply(t[1][0])), t[0][0].multiply(t[0][1]).add(t[0][1].multiply(t[1][1]))},
                    {t[1][0].multiply(t[0][0]).add(t[1][1].multiply(t[1][0])), t[1][0].multiply(t[0][1]).add(t[1][1].multiply(t[1][1]))}
            };
        }

        BigInteger[][] t = positiveMatrixExponentiation(n - 1);
        return new BigInteger[][]{
                {t[0][0].add(t[0][1]), t[0][0]},
                {t[1][0].add(t[1][1]), t[1][0]}
        };
    }

    // f(N) =   |f(-1), f(0)|   *   |-1, 1| ^ (|N| - 1)
    //          |f(0),  f(1)|       | 1, 0|
    private static BigInteger[][] negativeMatrixExponentiation(int n) {
        if (n == 1) {
            return new BigInteger[][]{
                    {BigInteger.ONE.negate(), BigInteger.ONE},
                    {BigInteger.ONE, BigInteger.ZERO}
            };
        }

        if (n % 2 == 0) {
            BigInteger[][] t = negativeMatrixExponentiation(n / 2);
            return new BigInteger[][]{
                    {t[0][0].multiply(t[0][0]).add(t[0][1].multiply(t[1][0])), t[0][0].multiply(t[0][1]).add(t[0][1].multiply(t[1][1]))},
                    {t[1][0].multiply(t[0][0]).add(t[1][1].multiply(t[1][0])), t[1][0].multiply(t[0][1]).add(t[1][1].multiply(t[1][1]))}
            };
        }

        BigInteger[][] t = negativeMatrixExponentiation(n - 1);
        return new BigInteger[][]{
                {t[0][1].subtract(t[0][0]), t[0][0]},
                {t[1][1].subtract(t[1][0]), t[1][0]}
        };
    }

    public static void main(String[] args) {
        BigInteger ret;
        ret = fib(BigInteger.valueOf(-6));
        System.out.println(ret);
    }
}
