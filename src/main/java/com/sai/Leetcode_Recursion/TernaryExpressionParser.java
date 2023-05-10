package com.sai.Leetcode_Recursion;

public class TernaryExpressionParser {

    private static int i = 0;

    public static String fn(String expression) {
        final char c = expression.charAt(i);
        if (i + 1 == expression.length() || expression.charAt(i + 1) == ':') {
            i += 2; // Skip ':'
            return String.valueOf(c);
        }
        i += 2; // Skip '?'
        final String first = fn(expression);
        final String second = fn(expression);
        return c == 'T' ? first : second;
    }


    public static void main(String[] args) {
        System.out.println(fn("T?2:3")); // 2
    }

}
