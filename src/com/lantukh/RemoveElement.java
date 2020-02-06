package com.lantukh;

import java.util.Arrays;

public class RemoveElement {


    public static void getSolution() {

        int[] arr = {3};

        int solution = removeElement(arr, 3);
        System.out.println(solution);
        Arrays.stream(arr).forEachOrdered(i -> System.out.print(i + ","));

    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int getPointer = nums.length - 1;
        int len = 0;

        for (int i = 0; i <= getPointer; i++) {
            int current = nums[i];

            if (current == val) {
                for (int j = getPointer; j > i; j--) {
                    int currentGet = nums[j];
                    if (currentGet != val) {
                        nums[i] = currentGet;
                        nums[j] = current;
                        getPointer = j - 1;
                        len++;
                        break;
                    }
                }
            } else {
                len++;
            }
        }
        return len;

    }
}
