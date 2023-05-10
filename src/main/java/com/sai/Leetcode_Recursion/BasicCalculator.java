package com.sai.Leetcode_Recursion;

public class BasicCalculator {
    
    private static int index;

    private static int fn(String s) {
        int res = 0, num = 0, sign = 1;
        while (index < s.length()) {
            char c = s.charAt(index++);
            if (c >= '0' && c <= '9') num = num * 10 + c - '0';
            else if (c == '(') num = fn(s);
            else if (c == ')') return res + sign * num;
            else if (c == '+' || c == '-') {
                res += sign * num;
                num = 0;
                sign = c == '-' ? -1 : 1;
            }
        }
        return res + sign * num;
    }

    public static int calculate(String s) {
        index = 0;
        return fn(s);
    }

    public static void main(String[] args) {
        System.out.println(calculate("1 + 1")); // 2
    }

}


