package com.am.study.algorithms.dynamic;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.sound.midi.SysexMessage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Knapsack {

    public static int maxWeight(int values[], int weights[], int capacity) {
        int limitOfItens = weights.length;
        int[][] matrix = new int[limitOfItens + 1][capacity + 1];

        for (int col = 0; col <= capacity; col++) {
            matrix[0][col] = 0;
        }
        for (int row = 0; row <= limitOfItens; row++) {
            matrix[row][0] = 0;
        }

        for (int item = 1; item <= limitOfItens; item++) {
            for (int weight = 1; weight <= capacity; weight++) {
                if (weights[item - 1] <= weight) {
                    matrix[item][weight] = Math.max(values[item - 1] + matrix[item - 1][weight - weights[item - 1]], matrix[item - 1][weight]);
                } else {
                    matrix[item][weight] = matrix[item - 1][weight];
                }
            }
        }
        //Printing the matrix
        for (int[] rows : matrix) {
            for (int col : rows) {
                System.out.format("%5d", col);
            }
            System.out.println();
        }
        return matrix[limitOfItens][capacity];
    }

    public Map<Integer, Integer> selectedItens(int values[], int weights[], int capacity) {
        int limitOfItens = weights.length;
        int[][] matrix = new int[limitOfItens + 1][capacity + 1];
        boolean[][] keep = new boolean[values.length][capacity + 1];

        for (int col = 0; col <= capacity; col++) {
            matrix[0][col] = 0;
        }
        for (int row = 0; row <= limitOfItens; row++) {
            matrix[row][0] = 0;
        }

        for (int item = 1; item <= limitOfItens; item++) {
            for (int weight = 1; weight <= capacity; weight++) {
                if (weights[item - 1] <= weight) {
                    int m1 = values[item - 1] + matrix[item - 1][weight - weights[item - 1]];
                    int m2 = matrix[item - 1][weight];

                    matrix[item][weight] = Math.max(m1, m2);

                    if (m1 > m2) {
                        keep[item - 1][weight] = true;
                    } else {
                        keep[item - 1][weight] = false;
                    }

                } else {
                    matrix[item][weight] = matrix[item - 1][weight];
                }
            }
        }

        //Printing the matrix
        for (boolean[] rows : keep) {
            for (boolean col : rows) {
                System.out.format("%5d", col ? 1 : 0);
            }
            System.out.println();
        }

        //printing what items we picked
        int K = capacity;
        int n = values.length;
        int wsel = 0;
        int vsel = 0;
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            if (keep[i][K] == true) {
                result.put(values[i], weights[i]);
                wsel += weights[i];
                vsel += values[i];
                K = K - weights[i];
            }
        }

        return result;
    }

    public static void main(String args[]) {

        int[] values = new int[]{60, 100, 120};
        int[] weight = new int[]{10, 20, 30};
        int capacity = 30;

        Knapsack knapsack = new Knapsack();
        System.out.println("MaxValue: " + knapsack.maxWeight(values, weight, capacity));
        Map<Integer, Integer> result = (knapsack.selectedItens(values, weight, capacity));
        result.forEach((key, value) -> System.out.println("[v: " + key + "][w: " + value + "]"));
    }
}