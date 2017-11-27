package com.am.study.algorithms.dynamic;

/**
 * Created by augustomarinho on 27/11/17.
 */
public class SubsetSum {

    // Returns true if there is a subset of received array with sun equal to given sum
    static boolean isSubsetSum(int set[], int n, int sum) {
        boolean[][] solution = new boolean[set.length + 1][sum + 1];
        // if sum is not zero and subset is 0, we can't make it
        for (int i = 1; i <= sum; i++) {
            solution[0][i] = false;
        }
        // if sum is 0 the we can make the empty subset to make sum 0
        for (int i = 0; i <= set.length; i++) {
            solution[i][0] = true;
        }
        //
        for (int i = 1; i <= set.length; i++) {
            for (int j = 1; j <= sum; j++) {
                //first copy the data from the top
                solution[i][j] = solution[i - 1][j];

                //If solution[i][j]==false check if can be made
                if (solution[i][j] == false && j >= set[i - 1])
                    solution[i][j] = solution[i][j] || solution[i - 1][j - set[i - 1]];
            }
        }

                /* print table
         for (int i = 0; i <= sum; i++)
         {
           for (int j = 0; j <= n; j++)
              System.out.println (set[i][j]);
         } */

        return solution[set.length][sum];
    }

    /* Driver program to test above function */
    public static void main(String args[]) {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");
    }
}