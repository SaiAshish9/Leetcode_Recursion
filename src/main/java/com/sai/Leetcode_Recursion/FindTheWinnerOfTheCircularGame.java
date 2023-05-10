package com.sai.Leetcode_Recursion;

public class FindTheWinnerOfTheCircularGame {

    public static int findTheWinner(int n, int k) {
        return fn(n, k) + 1;
    }

    private static int fn(int n, int k) {
        if (n == 1)
            return 0;
        return (fn(n - 1, k) + k) % n;
    }

    public static void main(String[] args) {
        System.out.println(findTheWinner(6, 5)); // 1
    }

}


