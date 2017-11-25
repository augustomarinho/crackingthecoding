package com.am.study.algorithms.search;

public class BinarySearch {

    public int find(int[] array, int value) {

        if (array == null || array.length == 0) {
            return -1;
        }

        int middle = 0;
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            middle = (start + end) / 2;

            if (array[middle] == value) {
                return middle;
            } else if (array[middle] < value) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        BinarySearch bs = new BinarySearch();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        System.out.println(bs.find(array, 16));
    }
}