package com.sai.Leetcode_Recursion;

public class PowerOfThree {

    public static boolean fn(int n) {
        if (n <= 0)
            return false;
        else if (n == 1)
            return true;
        return (n % 3 == 0 && fn(n / 3));
    }

    public static void main(String[] args) {
        System.out.println(fn(3)); // true
    }

}

