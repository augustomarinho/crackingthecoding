package com.am.study.algorithms.base;

public class Base6 {
    public static char HEX[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static String binaryToHex(String s) {
        int decimal = binaryToBase10(s);
        String result = "";

        while(decimal > 0) {
            result = HEX[decimal % 16] + result;
            decimal /= 16;
        }

        return result;
    }
    public static String binaryToBase6(String s) {

        int decimal = binaryToBase10(s);
        String result = "";
        // Decimal to base 6
        while (decimal > 0) {
            result = (decimal % 6) + result;
            decimal /= 6;
        }

        return result.toString();
    }
    public static int binaryToBase10(String s) {
        if(s == null) {
            return -1;
        }

        int decimal = 0;
        for(int i = 0; i < s.length(); i++) {
            decimal = decimal * 2 + (s.charAt(i) - '0');
        }

        return decimal;
    }

    public static void main(String[] args) {
        System.out.println(Base6.binaryToHex("100111"));
        System.out.println(Base6.binaryToBase10("100111"));
        System.out.println(Base6.binaryToBase6("100111"));
    }
}
