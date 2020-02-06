package com.lantukh;

import java.util.*;

public class ThreeLettersAlphabet {

    public static String makeString(int A, int B, int C) {

        List<String> letters = new ArrayList<>();

        List<Stack<String>> stackList = createStackList(A, B, C);

        while (stackList.stream().anyMatch(stack -> !stack.isEmpty())) {
            stackList.sort((s1, s2) -> s2.size() - s1.size());

            String addCandidat = stackList.get(0).peek();

            if(canAdd(letters, addCandidat)) {
                letters.add(stackList.get(0).pop());
            } else if (!stackList.get(1).isEmpty()) {
                letters.add(stackList.get(1).pop());
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        letters.forEach(letter -> sb.append(letter));
        return sb.toString();
    }

    private  static Stack<String> createStack(String letter, int letterCount) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < letterCount; i++) {
            stack.push(letter);
        }
        return  stack;
    }

    private static List<Stack<String>> createStackList(int A, int B, int C) {

        List<Stack<String>> stackList = new ArrayList<>();
        stackList.add(createStack("a", A));
        stackList.add(createStack("b", B));
        stackList.add(createStack("c", C));

        return stackList;
    }

    private static boolean canAdd(List<String> letters, String letter) {
        int size = letters.size();

        if (size < 2) {
            return true;
        }

        if(!letters.get(size - 1).equals(letter)) {
            return true;
        }

        return !letters.get(size - 2).equals(letter);
    }
}
