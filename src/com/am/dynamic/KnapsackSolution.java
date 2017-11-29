package com.am.dynamic;

import java.util.Scanner;

public class KnapsackSolution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testCaseSize = scan.nextInt();

        for (int i = 0; i < testCaseSize; i++) {

            int metaDataArray[] = new int[2];
            for (int j = 0; j < metaDataArray.length; j++) {
                metaDataArray[j] = scan.nextInt();
            }

            int itensArray[] = new int[metaDataArray[0]];
            for (int k = 0; k < itensArray.length; k++) {
                itensArray[k] = scan.nextInt();
            }

            System.out.println(maxSum(itensArray, itensArray, itensArray.length, metaDataArray[1]));
        }
    }

    public static int maxSum(int values[], int weights[], int capacity, int maxSum) {
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
                    int m1 = values[item - 1] + matrix[item - 1][weight - weights[item - 1]];
                    int m2 = matrix[item - 1][weight];

                    matrix[item][weight] = Math.max(m1, m2);
                } else {
                    matrix[item][weight] = matrix[item - 1][weight];
                }
            }
        }

        int calculatedMaxSum = matrix[limitOfItens][capacity];

        if (calculatedMaxSum < maxSum) {
            return maxSum;
        }

        return calculatedMaxSum;
    }
}
