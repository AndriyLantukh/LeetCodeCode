package com.lantukh;

public class ContainerWithMostWater {

    public static void getSolution() {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};


        int solution = maxArea(height);
    }

    public static int maxArea(int[] height) {

        int lo = 0;
        int hi = height.length -1;

        int maxArea = 0;
        while (lo < hi) {

            int loMax = height[lo];
            int hiMax = height[hi];

            int newMaxArea = (hi - lo) * (loMax<hiMax ? loMax : hiMax);

            if (newMaxArea > maxArea) {
                maxArea = newMaxArea;
            }

            if (height[lo] <= height[hi])
                while (lo < hi && height[lo] <= loMax) ++lo;
            else
                while (hi > lo && height[hi] <= hiMax) --hi;

        }
        return maxArea;
    }
}
