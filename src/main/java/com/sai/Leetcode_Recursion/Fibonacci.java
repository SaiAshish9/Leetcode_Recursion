package com.sai.Leetcode_Recursion;

public class Fibonacci {
    static int fn(int n) {
        if (n <= 1)
            return n;
        return fn(n - 1) + fn(n - 2);
    }

    public static void main(String args[]) {
        int n = 2;
        System.out.println(fn(n)); // 1
    }

}


