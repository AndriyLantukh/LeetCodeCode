package com.lantukh;

import java.util.Arrays;

public class UnionIntervals {


    public static void getSolution() {
        int[] testArr1 = {1, 12, 42, 70, 36, -4, 43, 15};
        int[] testArr2 = {5, 15, 44, 72, 36, 2, 69, 24};

        int solution = solution(testArr1, testArr2);

        System.out.println("Count:" + solution);

    }

    private static int solution(int[] A, int[] B) {
        mergeSort(A, B, 0, A.length - 1);

        System.out.println();
        Arrays.stream(A).forEachOrdered(a -> System.out.print(a +","));
        System.out.println();
        Arrays.stream(B).forEachOrdered(b -> System.out.print(b +","));
        System.out.println();

        int counter = 1;
        int bMax = B[0];
        for (int i = 0; i < A.length - 1; i++) {
            if(B[i] <= bMax) {
                continue;
            }

            bMax = B[i];

            if(bMax < A[i + 1]) {
                counter++;
            }
        }

        return counter;
    }

    private static void mergeSort(int sortArr[], int pairArr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(sortArr, pairArr, l, m);
            mergeSort(sortArr, pairArr, m + 1, r);

            merge(sortArr, pairArr, l, m, r);
        }
    }

    private static void merge(int sortArr[], int pairArr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];
        int Lp[] = new int[n1];
        int Rp[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = sortArr[l + i];
            Lp[i] = pairArr[l + i];

        }

        for (int j = 0; j < n2; ++j) {
            R[j] = sortArr[m + 1 + j];
            Rp[j] = pairArr[m + 1 + j];
        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                sortArr[k] = L[i];
                pairArr[k] = Lp[i];

                i++;
            } else {
                sortArr[k] = R[j];
                pairArr[k] = Rp[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            sortArr[k] = L[i];
            pairArr[k] = Lp[i];
            i++;
            k++;
        }

        while (j < n2) {
            sortArr[k] = R[j];
            pairArr[k] = Rp[j];
            j++;
            k++;
        }
    }
}
