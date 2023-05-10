package com.sai.Leetcode_Recursion;

public class PowerOfFour {

    public static boolean fn(int n) {
        if (n < 1)
            return false;
        if (n % 4 == 0)
            return fn(n / 4);
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(fn(16)); // true
    }

}

