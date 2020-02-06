package com.lantukh;

import java.util.Stack;

public class ValidParentheses {

    public static void getSolution() {

        String s = "()[]{}";


        boolean solution = isValid(s);
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if ((s.length() % 2) > 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        Stack<Character> st = new Stack();

        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];

            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                st.push(currentChar);
            } else if (!st.isEmpty() && isOpposite(st.peek(), currentChar)) {
                st.pop();
            } else {
                return false;
            }
        }
        return st.isEmpty();
    }

    private static boolean isOpposite(char ch1, char ch2) {
        if (ch1 == '(' && ch2 == ')') {
            return true;
        } else if (ch1 == '{' && ch2 == '}') {
            return true;
        } else if (ch1 == '[' && ch2 == ']') {
            return true;
        }
        return false;
    }
}
