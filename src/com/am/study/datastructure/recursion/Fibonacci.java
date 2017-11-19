package com.am.study.datastructure.recursion;

import java.math.BigInteger;
import java.util.Arrays;

public class Fibonacci {

    public BigInteger[] generateSerie(int maxDepth) {
        BigInteger[] fibonacciSerie = new BigInteger[maxDepth];
        return generate(fibonacciSerie, 0, maxDepth);
    }

    public BigInteger[] generate(BigInteger[] fibonacciSerie, int position, final int maxDepth) {

        if (position < maxDepth) {
            if (position == 0) {
                fibonacciSerie[position] = BigInteger.valueOf(0);
            } else if (position == 1) {
                fibonacciSerie[position] = BigInteger.valueOf(1);
            } else {
                fibonacciSerie[position] = fibonacciSerie[position - 2].add(fibonacciSerie[position - 1]);
            }

            generate(fibonacciSerie, ++position, maxDepth);
        }

        return fibonacciSerie;
    }

    public static void main(String args[]) {
        Fibonacci fibonacci = new Fibonacci();
        BigInteger[] serie = fibonacci.generateSerie(1000);
        System.out.println(Arrays.toString(serie));
    }
}
