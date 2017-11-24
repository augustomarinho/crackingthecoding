package com.am.crackingthecoding.algorithms.bit;

public class LonelyInteger {

    public static void main(String args[]) {
        int[] numbers = {0, 0, 1, 2, 1};

        int lonely = 0;
        for (int number : numbers) {
            lonely ^= number;
        }

        System.out.println(lonely);
    }
}