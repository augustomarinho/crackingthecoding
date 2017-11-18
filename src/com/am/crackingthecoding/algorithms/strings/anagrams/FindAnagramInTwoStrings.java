package com.am.crackingthecoding.algorithms.strings.anagrams;

import java.util.*;

public class FindAnagramInTwoStrings {

    public static int numberNeeded(String first, String second) {
        String biggest = null;
        String smallest = null;

        if (first != null && second != null) {
            if (first.length() >= second.length()) {
                biggest = first;
                smallest = second;
            } else {
                biggest = second;
                smallest = first;
            }

            char [] smallestArray = smallest.toCharArray();
            char [] biggestArray = biggest.toCharArray();

            String auxBiggest = biggest;
            for (char currentChar : smallest.toCharArray()) {
                if (biggest.indexOf(currentChar) != -1) {
                    auxBiggest = auxBiggest.replaceFirst(currentChar + "", "");
                    biggest = biggest.replaceFirst(currentChar + "", "");
                }
            }

            return auxBiggest.length() + biggest.length();
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = "abc"; //in.next();
        String b = "cde"; //in.next();
        System.out.println(numberNeeded(a, b));
    }
}