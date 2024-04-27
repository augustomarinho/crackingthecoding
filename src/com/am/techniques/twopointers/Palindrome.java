package com.am.techniques.twopointers;

public class Palindrome {

    public static boolean isPalindrome(String text) {
        char[] auxArray = text.toCharArray();
        int left = 0;
        int right = auxArray.length - 1;

        while (left < right) {
            if (auxArray[left] != auxArray[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("aba"));
        System.out.println(Palindrome.isPalindrome("abaa"));
    }
}
