package com.lantukh;

public class PalindromeNumber {

    public static void getSolution() {

        int someInt = 121;

        boolean solution = solution(someInt);
    }

    private static boolean solution(int x) {

        if(x < 0) {
            return false;
        }

        int reversed = 0;
        int input = x;

        while (input != 0) {
            reversed = reversed * 10 + input % 10;
            input = input / 10;
        }

        return x == reversed;
    }
}
