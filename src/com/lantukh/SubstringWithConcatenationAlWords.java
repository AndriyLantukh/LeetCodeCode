package com.lantukh;

import java.util.*;
import java.util.stream.Collectors;

public class SubstringWithConcatenationAlWords {

    public static void getSolution() {

        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        List<Integer> solution = solution(s, words);
        solution.forEach(index -> System.out.println(index));
    }

    private static List<Integer> solution(String s, String[] words) {

        int n = words.length;
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        int wordSize = words[0].length();
        int window = n * wordSize;

        HashMap<String, Integer> expectedWords = new HashMap<>();

        for (String word : words) {
            expectedWords.put(word, expectedWords.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < s.length() - window + 1; i++) {
            HashMap<String, Integer> testWords = new HashMap<>();
            String toCheck = s.substring(i, i + window);
            for (int j = 0; j <= window - wordSize; j = j + wordSize) {
                String substring = toCheck.substring(j, j + wordSize);

                int testCount = testWords.getOrDefault(substring, 0) + 1;

                if (testCount > expectedWords.getOrDefault(substring, 0)) {
                    break;
                } else {
                    testWords.put(substring, testCount);
                }
            }

            if (expectedWords.equals(testWords)) {
                result.add(i);
            }
        }
        return result;
    }

}
