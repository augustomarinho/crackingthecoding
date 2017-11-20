package com.am.crackingthecoding.algorithms.stack.balancedbracktes;

import java.util.*;
import java.util.stream.IntStream;


public class BalancedBrackets {
    public static boolean isBalanced(String expression) {

        if ((expression.length() & 1) == 1) return false;
        else {
            char[] brackets = expression.toCharArray();
            Stack<Character> s = new Stack<>();
            for (char bracket : brackets)
                switch (bracket) {
                    case '{':
                        s.push('}');
                        break;
                    case '(':
                        s.push(')');
                        break;
                    case '[':
                        s.push(']');
                        break;
                    default:
                        if (s.empty() || bracket != s.peek())
                            return false;
                        s.pop();
                }
            return s.empty();
        }

    }


    public static void main(String args[]) {
        System.out.println(isBalanced("{[()]}()()()"));
    }
}