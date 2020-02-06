package com.lantukh;

import java.util.Arrays;

public class FindPattern {


    public static void getSolution() {

        String aa = "abab";

        boolean solution = repeatedSubstringPattern(aa);
        System.out.println(solution);

    }

    public static boolean repeatedSubstringPattern(String s) {

        String candidat = s.substring(0, 1);
        int len = 1;
        for(int i = candidat.length(); i < s.length(); i = i + candidat.length()) {
            int endPos = i + candidat.length();

            if ( endPos > s.length()){
                return false;
            }

            String part = s.substring(i, endPos);
            if(!candidat.equals(part)) {
                len++;
                candidat = s.substring(0, len);
                i = 0;
            } else if (endPos == s.length()){
                return true;
            }

        }
        return false;
    }
}
