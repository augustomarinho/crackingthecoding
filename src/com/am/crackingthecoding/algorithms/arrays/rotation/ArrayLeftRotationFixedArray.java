package com.am.crackingthecoding.algorithms.arrays.rotation;

import java.util.Arrays;

public class ArrayLeftRotationFixedArray {

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int rotation = 4;
        int size = a.length;

        int firstElement = 0;
        for (int i = 0; i < rotation + 1; i++) {

            if (i > 0) {
                firstElement = a[0];

                for (int j = 0; j < size - 1; j++) {
                    a[j] = a[j + 1];
                }

                a[size - 1] = firstElement;
            }
        }

        System.out.print(Arrays.toString(a).replaceAll("\\[|\\]|,", ""));
    }
}
