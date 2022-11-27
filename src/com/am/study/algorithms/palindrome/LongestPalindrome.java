package com.am.study.algorithms.palindrome;

class LongestPalindrome {
    public String getPalindrome(String s, int start, int end) {

        if(start > end) return "";

        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return s.substring(start + 1, end);
    }

    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1 || s.length() > 1000) {
            return null;
        }

        String longest = String.valueOf(s.charAt(0));
        for(int i = 0; i < s.length() - 1; i++) {
            String check = getPalindrome(s, i, i);
            String check2 = getPalindrome(s, i, i + 1);

            System.out.println(check + "- " + check2);

            if(check.length() > longest.length()) {
                longest = check;
            }

            if(check2.length() > longest.length()) {
                longest = check2;
            }
        }


        return longest;
    }

    public static void main(String[] args) {
     System.out.println(new LongestPalindrome().longestPalindrome("babad"));
    }
}
