package com.lantukh;

import java.util.*;

public class Sum3Int {

    public static void getSolution() {

        int[] nums = {-1, 0, 1, 2, -1, -4};


        List<List<Integer>> solution = threeSum(nums);
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> sums = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {

            HashSet<Integer> s = new HashSet<>();

            int curr_sum = 0 - nums[i];

            for (int j = i + 1; j < nums.length; j++) {

                if (s.remove(curr_sum - nums[j])) {

                    int no1 = nums[i];
                    int no2 = nums[j];
                    int no3 = curr_sum - nums[j];

                    int sto;
                    int hi;
                    int lo;

                    if (no1 > no2) {
                        sto = no1;
                        lo = no2;
                    } else {
                        sto = no2;
                        lo = no1;
                    }
                    if (sto > no3) {
                        hi = sto;
                        if (lo > no3) {
                            sto = lo;
                            lo = no3;
                        } else {
                            sto = no3;
                        }
                    } else hi = no3;

                    sums.add(Arrays.asList(lo, sto, hi));
                } else {
                    s.add(nums[j]);
                }
            }
        }
        return new ArrayList<>(sums);
    }
}
