package com.am.crackingthecoding.algorithms.strings.anagrams;

import java.util.*;

public class FindAnagramInTwoStrings {

    public static int numberNeeded(String first, String second) {

        int sum = 0;
        if (first != null && second != null) {

            char[] firstArray = first.toCharArray();
            char[] secondArray = second.toCharArray();

            int[] fullAlphabet = new int['z' - 'a' + 1];

            for (char letter : firstArray) {
                fullAlphabet[letter - 'a']++;
            }

            for (char letter : secondArray) {
                fullAlphabet[letter - 'a']--;
            }

            for(int letter : fullAlphabet) {
                sum += Math.abs(letter);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //resposta 30
        String a = "fcrxzwscanmligyxyvym"; //in.next();
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke"; //in.next();
        System.out.println(numberNeeded(a, b));
    }
}