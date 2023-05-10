package com.sai.Leetcode_Recursion;

public class CountGoodNumbers {

    private static final int kMod = 1_000_000_007;

    private static long myPow(long x, long n) {
        if (n == 0)
            return 1;
        if (n % 2 == 1)
            return x * myPow(x, n - 1) % kMod;
        return myPow(x * x % kMod, n / 2);
    }

    public static int countGoodNumbers(long n) {
        return (int) (myPow(4 * 5, n / 2) * (n % 2 == 1 ? 5 : 1) % kMod);
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(1)); // 5
//        The good numbers of length 1 are "0", "2", "4", "6", "8".
    }

}


