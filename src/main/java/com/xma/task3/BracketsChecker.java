package com.xma.task3;

import java.util.Stack;

public class BracketsChecker {
    public static int check(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        int index = 0;

        for (; index < array.length; index++) {
            char symbol = array[index];

            if (isBracket(symbol)) {
                if (isOpened(symbol)) {
                    stack.push(symbol);
                } else {
                    if (stack.isEmpty() || isNotPair(symbol, stack.pop())) {
                        return index;
                    }
                }
            }
        }

        return stack.isEmpty() ? -1 : index;
    }

    private static boolean isBracket(char symbol) {
        return symbol == '[' || symbol == '{' || symbol == '('
                || symbol == ']' || symbol == '}' || symbol == ')';
    }

    private static boolean isOpened(char symbol) {
        return symbol == '[' || symbol == '{' || symbol == '(';
    }

    private static boolean isNotPair(char symbol, char pop) {
        return switch (pop) {
            case '[' -> symbol != ']';
            case '{' -> symbol != '}';
            case '(' -> symbol != ')';
            default -> throw new IllegalStateException("Unexpected value: " + pop);
        };
    }
}
