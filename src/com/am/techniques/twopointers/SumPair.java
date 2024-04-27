package com.am.techniques.twopointers;

/**
 * Given a sorted array of unique integers and a target integer,
 * return true if there exists a pair of numbers that sum to target, false otherwise.
 */
public class SumPair {

    public static boolean findPairSum(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int sum = 0;
        while (left < right) {
            sum = array[left] + array[right];

            if (sum == target) {
                return true;
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(SumPair.findPairSum(new int[]{1, 2, 4, 6, 8, 9, 14, 15}, 16));
    }
}
