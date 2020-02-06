package com.lantukh;

public class RotateMatrix {

    public int[][] rotateMatrix(int matrix[][]) {

        if (matrix == null || matrix.length < 2) {
            return null;
        }

        int colMaxIndex = matrix.length;
        int rowMaxIndex = matrix[0].length;

        if (colMaxIndex != rowMaxIndex) {
            return null;
        }

        int n = colMaxIndex;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
        return matrix;

    }

//            00 01 02 03   30 20 10 00    00 < 30
//            10 11 12 13   31 21 11 01    01 < 20
//            20 21 22 23   32 22 12 02    02 < 10
//            30 31 32 33   33 23 13 03    03 < 00


}
