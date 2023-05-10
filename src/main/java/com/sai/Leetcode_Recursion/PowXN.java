package com.sai.Leetcode_Recursion;

public class PowXN {

    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 1 / myPow(x, -n);
        if ((n & 1) > 0)
            return x * myPow(x, n - 1);
        return myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0, 10)); // 1024.0
    }

}


