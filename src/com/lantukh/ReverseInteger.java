package com.lantukh;

public class ReverseInteger {
    public static void getSolution() {

        int x = -123;

        int solution = solution(x);
    }

    private static int solution(int x) {
        long reversedNum = 0;
        long input_long = x;

        while (input_long != 0) {
            reversedNum = reversedNum * 10 + input_long % 10;
            input_long = input_long / 10;
        }

        if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reversedNum;
    }
}
