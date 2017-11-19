package com.am.crackingthecoding.algorithms.arrays.rotation;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayLeftRotationDuringInput {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt(); // Size of elements
        int rotation = in.nextInt(); // Size of left rotation
        int a[] = new int[size];

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < size; i++) {
            if (rotation > i) {
                a[size - rotation + i] = in.nextInt();
            } else {
                a[i - rotation] = in.nextInt();
            }
        }

        System.out.print(Arrays.toString(a).replaceAll("\\[|\\]|,", ""));
    }
}