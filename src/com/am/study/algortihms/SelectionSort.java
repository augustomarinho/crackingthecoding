package com.am.study.algortihms;

import java.util.Arrays;

public class SelectionSort {

    public static int[] sort(int[] array) {

        int menorValor;
        int posicaoMenorValor;

        if (array == null && array.length <= 1) {
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            menorValor = array[i];
            posicaoMenorValor = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < menorValor) {
                    menorValor = array[j];
                    posicaoMenorValor = j;
                }
            }


            array[posicaoMenorValor] = array[i];
            array[i] = menorValor;
        }

        return array;
    }

    public static void main(String args[]) {
        int[] valores = {7, 3, 9, 1, 10};
        System.out.println(Arrays.toString(sort(valores)));
    }
}