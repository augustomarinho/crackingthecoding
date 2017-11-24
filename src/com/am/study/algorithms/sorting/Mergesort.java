package com.am.study.algorithms.sorting;

import java.util.Arrays;

public class Mergesort {

    public int[] sort(int[] vetor) {
        int[] auxiliar = new int[vetor.length];
        return sort(vetor, auxiliar, 0, vetor.length - 1);
    }

    private int[] sort(int[] vetor, int[] auxiliar, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            sort(vetor, auxiliar, inicio, meio);
            sort(vetor, auxiliar, meio + 1, fim);
            merge(vetor, auxiliar, inicio, meio, fim);
        }

        return vetor;
    }

    private void merge(int[] vetor, int[] auxiliar, int inicio, int meio, int fim) {
        for (int k = inicio; k <= fim; k++) {
            auxiliar[k] = vetor[k];
        }

        int i = inicio;
        int j = meio + 1;

        for (int k = inicio; k <= fim; k++) {
            if (i > meio) vetor[k] = auxiliar[j++];
            else if (j > fim) vetor[k] = auxiliar[i++];
            else if (auxiliar[i] < auxiliar[j]) vetor[k] = auxiliar[i++];
            else vetor[k] = auxiliar[j++];
        }
    }

    public static void main(String args[]) {
        int[] valores = {7, 3, 9, 1, 10, 200, 300, 0, -1};

        Mergesort mergesort = new Mergesort();
        System.out.println(Arrays.toString(mergesort.sort(valores)));
    }
}