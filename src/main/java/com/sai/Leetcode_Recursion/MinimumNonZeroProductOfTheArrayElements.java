package com.sai.Leetcode_Recursion;

public class MinimumNonZeroProductOfTheArrayElements {

    public static int minNonZeroProduct(int p) {
        final long n = 1L << p;
        final long halfCount = n / 2 - 1;
        return (int) (myPow(n - 2, halfCount) * ((n - 1) % kMod) % kMod);
    }

    private static final int kMod = 1_000_000_007;

    private static long myPow(long x, long n) {
        if (n == 0)
            return 1L;
        x %= kMod;
        if (n % 2 == 1)
            return x * myPow(x, n - 1) % kMod;
        return myPow(x * x, n / 2) % kMod;
    }


    public static void main(String[] args) {
        System.out.println(minNonZeroProduct(2)); // 6 , nums = [01, 10, 11]. 1*2*3
    }

}


