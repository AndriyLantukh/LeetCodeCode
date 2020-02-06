package com.lantukh;

public class DivideTwoIntegers {


    public static void getSolution() {

        int i1 = 1038925803;
        int i2 = -2147483648;

        int solution = divide(i1, i2);
        System.out.println(solution);

    }

    public static int divide(int dividend, int divisor) {

        if(dividend == divisor) {
            return 1;
        }

        if(dividend == 0) {
            return 0;
        }

        if(divisor == 1) {
            return dividend;
        }

        if(divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }

        if(divisor == Integer.MIN_VALUE) {
            return 0;
        }

        int counter = 0;
        if(dividend > 0 && divisor > 0) {
            while(dividend >= divisor) {
                dividend = dividend - divisor;
                counter++;
            }
        } else  if(dividend < 0 && divisor < 0) {
            while(dividend <= divisor) {
                dividend = dividend - divisor;
                counter++;
            }
        } else  if(dividend > 0 && divisor < 0) {
            while(dividend >= -divisor) {
                dividend = dividend + divisor;
                counter++;
            }
            counter = -counter;
        } else  if(dividend < 0 && divisor > 0) {
            while(dividend <= -divisor) {
                dividend = dividend + divisor;
                counter++;
            }
            counter = -counter;
        }

        return counter;
    }
}
