package com.lantukh;

public class StringToIntegerAtoi {

    public static void getSolution() {

        String someString = "-91283472332";

        int solution = solution(someString);
    }

    private static int solution(String s) {
        long output_long = 0;

        char[] chars = s.toCharArray();

        int sign = 0;

        for (int i = 0; i < chars.length; i++) {

            char aChar = chars[i];

            if (aChar == ' ') {
                if (sign != 0) {
                    break;
                }
                continue;
            } else if (aChar == '+') {
                if (sign != 0) {
                    break;
                }
                sign = 1;
                continue;
            } else if (aChar == '-') {
                if (sign != 0) {
                    break;
                }
                sign = -1;
                continue;
            } else if (Character.isDigit(aChar)) {
                output_long = output_long * 10 + Character.getNumericValue(aChar);
                if (sign == 0) {
                    sign = 1;
                }
            } else {
                break;
            }

            long signed_long = sign * output_long;
            if (signed_long > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (signed_long < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

        }
        return (int) (sign * output_long);
    }
}
