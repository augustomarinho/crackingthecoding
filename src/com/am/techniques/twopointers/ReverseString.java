package com.am.techniques.twopointers;

public class ReverseString {

    public static String reverseString(String text) {
        char[] array = text.toCharArray();
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }

        return new String(array);
    }

    public static void main(String[] args) {
        System.out.println(ReverseString.reverseString("augusto"));
    }
}
