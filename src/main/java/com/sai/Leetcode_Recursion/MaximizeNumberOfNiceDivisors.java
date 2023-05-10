package com.sai.Leetcode_Recursion;

public class MaximizeNumberOfNiceDivisors {

    private static final int kMod = 1_000_000_007;

    public static int maxNiceDivisors(int primeFactors) {
        if (primeFactors <= 3)
            return primeFactors;
        if (primeFactors % 3 == 0)
            return (int) (myPow(3, primeFactors / 3) % kMod);
        if (primeFactors % 3 == 1)
            return (int) (4 * myPow(3, (primeFactors - 4) / 3) % kMod);
        return (int) (2 * myPow(3, (primeFactors - 2) / 3) % kMod);
    }

    private static long myPow(long x, int n) {
        if (n == 0)
            return 1;
        if (n % 2 == 1)
            return x * myPow(x, n - 1) % kMod;
        return myPow(x * x % kMod, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(maxNiceDivisors(5)); // 6
    }

}
