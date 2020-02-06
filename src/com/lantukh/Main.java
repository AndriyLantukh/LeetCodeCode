package com.lantukh;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        GenerateParentheses.getSolution();
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> integersMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Integer res = integersMap.get(target - nums[i]);
            if (res != null) {
                result[0] = res;
                result[1] = i;
                return result;
            }
            integersMap.put(nums[i], i);


        }
        return result;
    }

    public static int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }

        int moveFactor = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> intSet = new HashSet<>();
        for (int num : nums) {
            if (!intSet.add(num)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> intSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!intSet.add(nums[i])) {
                return true;
            }
            if (i > k) {
                intSet.remove(i - k - 1);
            }
        }
        return false;
    }

    public static boolean isIsomorphic(String s, String t) {
        List<Character> charsS = new ArrayList<>();
        for (char theChar : s.toCharArray()) {
            charsS.add(theChar);
        }
        List<Character> charsT = new ArrayList<>();
        for (char theChar : t.toCharArray()) {
            charsT.add(theChar);
        }
        while (charsS.size() > 0) {
            List<Integer> indexesS = new ArrayList<>();
            List<Integer> indexesT = new ArrayList<>();
            for (int i = 0; i < charsS.size(); i++) {
                if (charsS.get(i) == charsS.get(0)) {
                    indexesS.add(i);
                }
                if (charsT.get(i) == charsT.get(0)) {
                    indexesT.add(i);
                }
            }
            if (!indexesS.equals(indexesT)) {
                return false;
            }
            Collections.reverse(indexesS);
            indexesS.forEach(theInt -> {
                charsS.remove((int) theInt);
                charsT.remove((int) theInt);
            });

        }
        return true;
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


}
