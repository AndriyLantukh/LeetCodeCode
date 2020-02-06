package com.lantukh;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RegularExpressionMatching {
    public static void getSolution() {

        String stringToCheck = "";
        String pattern = "";

        boolean solution = isMatch(stringToCheck, pattern);
    }

    public static boolean isMatch(String s, String p) {

        char[] testChars = s.toCharArray();
        char[] patChars = p.toCharArray();


        List<String> patternParts = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        boolean asteriskFound = false;
        for(int i = p.length() - 1; i >= 0; i--) {
            char patternChar = p.charAt(i);

            if(patternChar == '*') {
                asteriskFound = true;
                if (sb.length() > 0) {
                   patternParts.add(0, sb.reverse().toString());
                   sb.setLength(0);
               }
            } else if(asteriskFound) {
                asteriskFound = false;
                sb.append(patternChar);
                sb.append('*');
                patternParts.add(0, sb.toString());
                sb.setLength(0);
            } else {
                sb.append(patternChar);
            }
        }

        Iterator<String> iterator = patternParts.iterator();

        int index = 0;

        while (iterator.hasNext()) {
            String patternPart = iterator.next();
            boolean asteriskPart = patternPart.endsWith("*");

            for (int i = 0; i < s.length(); i++) {

                char testChar = s.charAt(index);
                char patChar = patternPart.charAt(index);

                if(testChar == patChar) {

                }
            }


            //if()
        }

        for (int i = 0; i < testChars.length; i++) {


            char testChar = testChars[i];



        }

        CharacterIterator it = new StringCharacterIterator(p);

        int start = 0;

        char prevPatChar = '-';


        qq:   while (it.current() != CharacterIterator.DONE) {

            char currentPatChar = it.current();

            for (int i = start; i < testChars.length; i++) {


                char testChar = testChars[i];

                if(currentPatChar == testChar) {
                    prevPatChar = currentPatChar;
                    it.next();
                    start = i;
                    continue qq;
                } else if(currentPatChar == '.') {
                    prevPatChar = currentPatChar;
                    it.next();
                    start = i;
                    continue qq;
                } else  if(currentPatChar == '*') {

                } else {

                }


            }


        }




        return false;

    }
}
