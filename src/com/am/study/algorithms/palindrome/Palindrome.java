package com.am.study.algorithms.palindrome;

public class Palindrome {

    /**
     * Only check words, its possible this solution not working for sentences
     *
     * @param text
     * @return
     */
    public boolean isPalidrome(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }

        boolean palindrome = true;
        char letters[] = text.toCharArray();

        for (int start = 0, end = text.length() - 1; start < (text.length() / 2); start++, end--) {
            if (letters[start] != letters[end]) {
                palindrome = false;
                break;
            }
        }

        return palindrome;
    }

    private boolean isLetter(char letter) {

        if ((letter >= 65 && letter <= 90) ||
                letter >= 97 && letter <= 122) {
            return true;
        }

        return false;

    }

    public static void main(String args[]) {

        String text = "0110";
        Palindrome p = new Palindrome();

        System.out.println(p.isPalidrome(text));
    }
}