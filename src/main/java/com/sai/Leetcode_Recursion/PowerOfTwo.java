package com.sai.Leetcode_Recursion;

public class PowerOfTwo {

    public static boolean fn(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        return fn(n / 2);
    }

    public static void main(String[] args) {
        System.out.println(fn(1)); // true
    }

}

