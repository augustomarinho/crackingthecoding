package com.am.study.algorithms.ascii;

public class TextCaseFormatter {

    public String toLower(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        char[] lowerChars = text.toCharArray();

        for (int i = 0; i < lowerChars.length; i++) {

            char letter = lowerChars[i];

            if (letter >= 65 && letter <= 90) {
                lowerChars[i] = (char) (letter + 32);
            }
        }

        return new String(lowerChars);
    }

    public String toUpper(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        char[] upperChars = text.toCharArray();

        for (int i = 0; i < upperChars.length; i++) {

            char letter = upperChars[i];

            if (letter >= 97 && letter <= 122) {
                upperChars[i] = (char) (letter - 32);
            }
        }

        return new String(upperChars);
    }

    public static void main(String args[]) {

        String name = "Augusto Marinho";

        TextCaseFormatter myString = new TextCaseFormatter();

        System.out.println(myString.toLower(name));
        System.out.println(myString.toUpper(name));
    }
}