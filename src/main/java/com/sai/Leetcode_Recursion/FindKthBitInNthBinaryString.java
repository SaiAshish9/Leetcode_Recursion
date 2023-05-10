package com.sai.Leetcode_Recursion;

public class FindKthBitInNthBinaryString {

    public static char findKthBit(int n, int k) {
        int cc = fn(n, k);
        return cc == 0 ? '0' : '1';
    }

    public static int fn(int n, int k) {
        if (n == 1 || k == 1) {
            return 0;
        }
        int len = (int) Math.pow(2, n) - 1;
        int mid = ((len) / 2);
        if (mid == k - 1) {
            return 1;
        }
        if (k - 1 < mid) {
            return fn(n - 1, k);
        } else {
            return fn(n - 1, len - k + 1) ^ 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(findKthBit(3, 1)); // 0
    }

}



