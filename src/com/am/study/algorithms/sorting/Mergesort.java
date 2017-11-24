package com.am.study.algorithms.sorting;

import java.util.Arrays;

public class Mergesort {

    public static int[] sort(int[] array) {

        if (array.length <= 1) {

            return array;
        }

        int meio = array.length / 2;
        int[] dir = array.length % 2 == 0 ? new int[meio] : new int[meio + 1];
        int[] esq = new int[meio];

        int[] aux = new int[array.length];

        for (int i = 0; i < meio; i++) {
            esq[i] = array[i];
        }

        int auxIndex = 0;
        for (int i = meio; i < array.length; i++) {
            dir[auxIndex] = array[i];
            auxIndex++;
        }

        esq = sort(esq);
        dir = sort(dir);

        aux = mergesort(esq, dir);

        return aux;
    }

    static int[] mergesort(int[] esq, int[] dir) {
        int[] aux = new int[esq.length + dir.length];

        int indexDir = 0, indexEsq = 0, indexAux = 0;

        while (indexEsq < esq.length || indexDir < dir.length) {
            if (indexEsq < esq.length && indexDir < dir.length) {
                if (esq[indexEsq] <= dir[indexDir]) {
                    aux[indexAux] = esq[indexEsq];
                    indexAux++;
                    indexEsq++;
                } else {
                    aux[indexAux] = dir[indexDir];
                    indexAux++;
                    indexDir++;
                }
            } else if (indexEsq < esq.length) {
                aux[indexAux] = esq[indexEsq];
                indexAux++;
                indexEsq++;
            } else if (indexDir < dir.length) {
                aux[indexAux] = dir[indexDir];
                indexAux++;
                indexDir++;
            }
        }
        return aux;
    }

    public static void main(String args[]) {
        int[] valores = {7, 3, 9, 1, 10, 200, 300, 0, -1};
        System.out.println(Arrays.toString(sort(valores)));
    }
}