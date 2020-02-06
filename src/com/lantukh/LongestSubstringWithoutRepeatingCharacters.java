package com.lantukh;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void getSolution() {

        String someString = "abcabcabc";

        int solution = solution(someString);
    }

    private static int solution(String s) {
        char[] chars = s.toCharArray();

        int candidateLength = 0;
        HashSet<Integer> workSet = new HashSet<>();
        LinkedList<Integer> workList = new LinkedList<>();

        for (int i = 0; i < chars.length; i++) {

            int aChar = chars[i];

            if (!workSet.add(aChar)) {
                if (workSet.size() > candidateLength) {
                    candidateLength = workSet.size();
                }

                while (true) {
                    Integer integer = workList.pollFirst();
                    workSet.remove(integer);
                    if (integer == aChar) {
                        break;
                    }
                }
            }

            workSet.add(aChar);
            workList.addLast(aChar);

        }

        if (workSet.size() > candidateLength) {
            candidateLength = workSet.size();
        }

        return candidateLength;
    }
}
