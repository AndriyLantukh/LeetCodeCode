package com.lantukh;

import java.util.Arrays;

public class IntegerToRoman {

    public static void getSolution() {

        int num = 1994;


        String solution = intToRoman(num);
        System.out.println(solution);
    }

    public static String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        int m = num / 1000;

        sb.append(getSimple(m, 'M'));

        num = num % 1000;

        int c = num / 100;

        append(sb, c, 'C', 'D', 'M');

        num = num % 100;

        int x = num / 10;

        append(sb, x,'X', 'L', 'C');

        num = num % 10;

        append(sb, num, 'I', 'V', 'X');

        return sb.toString();
    }

    private static void append(StringBuilder sb, int num, char one, char five, char next) {
        if (num > 0) {
            if (num == 4) {
                sb.append(createString(one, five));
                return;
            }
            if (num == 9) {
                sb.append(createString(one, next));
                return;
            }
            if (num >= 5) {
                sb.append(five);
                num = num - 5;
            }
            sb.append(getSimple(num, one));
        }
    }

    private static String getSimple(int count, char charToFill) {
        if (count > 0) {
            char[] array = new char[count];
            Arrays.fill(array, charToFill);
            return new String(array);
        }
        return "";
    }

    private static String createString(char... chars) {
        return new String(chars);
    }


}
