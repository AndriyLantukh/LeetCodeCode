package com.lantukh;

public class LongestCommonPrefix {

    public static void getSolution() {

        String[] someStrings = {"aa","a"};

        String solution = longestCommonPrefix(someStrings);
        System.out.println(solution);
    }


    public static String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length < 1) {
            return"";
        }

        if( strs.length < 2) {
            return strs[0];
        }

        char[] prefix = strs[0].toCharArray();

        for (int i = 1; i < strs.length; i++) {

            if (prefix.length == 0) {
                break;
            }

            char[] toCheck = strs[i].toCharArray();

            if(toCheck.length < prefix.length) {
                char[] newPrefix = new char[toCheck.length];
                System.arraycopy(prefix, 0, newPrefix, 0, toCheck.length);
                prefix = newPrefix;
            }

            int j;
            for (j = 0; j < prefix.length; j++) {
                if (toCheck[j] != prefix[j]) {
                    int newSize = j;
                    char[] newPrefix = new char[newSize];
                    System.arraycopy(prefix, 0, newPrefix, 0, newSize);
                    prefix = newPrefix;
                    break;
                }
            }

        }
        return new String(prefix);
    }

}
