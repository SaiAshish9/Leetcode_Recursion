package com.sai.Leetcode_Recursion;

public class NumberOfDigitOne {

    public static int fn(int n) {
        if (n <= 0) return 0;
        int high = n / 10;
        int one = countOne(high);
        int d = n % 10;
        int count = (d + 1) * one;
        if (d >= 1) ++count;
        --high;
        return count + fn(high) * 10 + high + 1;
    }

    private static int countOne(int n) {
        int count = 0;
        for (int i = n; i > 0; i /= 10) {
            if ((i % 10) == 1)
                ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(fn(13)); // 6
    }

}


