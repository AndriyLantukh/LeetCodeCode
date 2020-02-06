package com.lantukh;

public class ZigZagConversion {

    public static void getSolution() {

        String someString = "PAYPALISHIRING";
        int numRows = 4;

        String solution = solution(someString, numRows);
    }

    private static String solution(String s, int numRows) {

        if(numRows < 2) {
            return s;
        }

        if(s.length() <= numRows) {
            return s;
        }

        char[] inputChars = s.toCharArray();

        StringBuilder result = new StringBuilder();

        int period = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {

            StringBuilder rowResult = new StringBuilder();

            for (int j = i; j < inputChars.length; j = j + period) {
                rowResult.append(inputChars[j]);

                if (i != 0 && i != numRows - 1) {

                    int j1 = j + period - 2 * i;
                    if(j1 >= inputChars.length) {
                        continue;
                    }
                    rowResult.append(inputChars[j1]);
                }
            }

            result.append(rowResult.toString());
            rowResult.setLength(0);
        }

        return result.toString();
    }
}
