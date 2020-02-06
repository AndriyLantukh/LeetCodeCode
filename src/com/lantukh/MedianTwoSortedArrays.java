package com.lantukh;

public class MedianTwoSortedArrays {

    public static void getSolution() {

        int[] nums1 = {1, 2,3,5,6};

        int[] nums2 = {4};

        double solution = findMedianSortedArrays(nums1, nums2);
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0) {
            return getMedian(nums2);
        }

        if (nums2 == null || nums2.length == 0) {
            return getMedian(nums1);
        }

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;

        while (low <= high) {
            int partX = (low + high) / 2;
            int partY = (x + y + 1) / 2 - partX;

            int maxLeftX = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int minRightX = partX == x ? Integer.MAX_VALUE : nums1[partX];

            int maxLeftY = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int minRightY = partY == y ? Integer.MAX_VALUE : nums2[partY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return ((double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partX - 1;
            } else {
                low = partX + 1;
            }

        }

        throw new IllegalArgumentException();
    }

    private static double getMedian(int[] nums) {
        int len = nums.length;
        int index = len / 2;
        if (len % 2 == 0) {
            return ((double)(nums[index - 1] + nums[index])) / 2;
        } else {
            return (double)nums[index];
        }
    }
}
