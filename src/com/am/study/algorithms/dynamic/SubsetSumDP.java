package com.am.study.algorithms.dynamic;

import com.am.study.algorithms.sorting.Mergesort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by augustomarinho on 27/11/17.
 */
public class SubsetSumDP {

    public static boolean isSubsetSum(int set[], int n, int sum) {
        boolean[][] solution = new boolean[set.length + 1][sum + 1];
        //All columns in the first line is false
        for (int i = 1; i <= sum; i++) {
            solution[0][i] = false;
        }

        //All lines in the first column is true
        for (int i = 0; i <= set.length; i++) {
            solution[i][0] = true;
        }

        //Building the matrix with possibilities
        for (int i = 1; i <= set.length; i++) {
            for (int j = 1; j <= sum; j++) {
                //first copy the data from the top
                solution[i][j] = solution[i - 1][j];

                //If solution[i][j]==false check if can be made
                if (solution[i][j] == false && j >= set[i - 1])
                    solution[i][j] = solution[i][j] || solution[i - 1][j - set[i - 1]];
            }
        }

        return solution[set.length][sum];
    }

    public static Set<Set<Integer>> findSubSets(int[] set, int sum) {

        Set<Integer> subset = null;
        Set<Set<Integer>> map = new LinkedHashSet<>();

        int parcialSubsetSum = 0;
        for (int i = 0; i < set.length; i++) {

            subset = new HashSet<>();
            subset.add(set[i]);

            int auxj = set.length;
            int limitJ = set.length;

            if (set[i] == sum) {
                HashSet<Integer> orphanMumber = new HashSet<>();
                orphanMumber.add(sum);
                map.add(orphanMumber);
            }

            for (int j = 0; j < limitJ; j++) {

                subset.add(set[i]);

                if (i != j) {
                    subset.add(set[j]);

                    if (sumSubSet(subset) == sum) {
                        map.add(subset);

                        subset = new HashSet<>();
                        subset.add(set[i]);
                    }
                }

                if (j == set.length - 1) {
                    j = 0;
                    limitJ--;
                    subset = new HashSet<>();
                    subset.add(set[i]);
                }
            }
        }

        return map;
    }

    public static int sumSubSet(Collection<Integer> subset) {
        int sum = 0;

        for (Integer num : subset) {
            sum += num;
        }

        return sum;
    }


    public static void main(String args[]) {
        int set[] = {3, 4, 12, 5};
        int sum = 23;
        int n = set.length;
        //System.out.println(isSubsetSum(set, n, sum));

        Arrays.sort(set);
        Set<Set<Integer>> map = findSubSets(set, sum);

        map.forEach((list) -> {
            System.out.println("SubSet : " + list);
        });
    }
}