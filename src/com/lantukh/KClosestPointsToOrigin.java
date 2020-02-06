package com.lantukh;

public class KClosestPointsToOrigin {

    public static void getSolution() {

        //  int[][] points = {{8, -1}, {-4, 10}, {0, 1}, {7, -8}, {-3, -10}, {-2, -3}, {0, 3}};
        int[][] points = {{2, 2}, {2, 2}, {2, 2}, {2, 2}, {2, 2}, {2, 2}, {1, 1}};

        int k = 1;

        int[][] solution = solution(points, k);
    }

    private static int[][] solution(int[][] points, int k) {
        bubbleSortMin(points, k);

        int[][] result = new int[k][2];
        System.arraycopy(points, 0, result, 0, k);
        return result;
    }

    private static int[][] bubbleSortMin(int[][] arr, int K) {
        int n = arr.length;
        int counter = 0;
        for (int i = 0; i < n - 1; i++) {
            if (counter == K) {
                break;
            }
            for (int j = 0; j < n - i - 1; j++) {
                if (compare(arr[j - 1], arr[j])) {
                    int[] temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
            counter++;
        }
        return arr;
    }

    private static boolean compare(int[] prevElement, int[] element) {
        int e10 = Math.abs(prevElement[0]);
        int e11 = Math.abs(prevElement[1]);

        int e20 = Math.abs(element[0]);
        int e21 = Math.abs(element[1]);

        return e10 * e10 + e11 * e11 > e20 * e20 + e21 * e21;
    }


}
