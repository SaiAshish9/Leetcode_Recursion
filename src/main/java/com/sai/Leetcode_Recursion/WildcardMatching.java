package com.sai.Leetcode_Recursion;

public class WildcardMatching {

    static boolean fn(int i, int j, char[] s, char[] p) {
        if (i < 0 && j < 0) return true;
        if (j < 0 && i >= 0) return false;
        if (i < 0 && j >= 0) {
            while (j >= 0) {
                if (p[j] == '*') j--;
                else return false;
            }
            return true;
        }

        if (s[i] == p[j] || p[j] == '?') return fn(i - 1, j - 1, s, p);
        if (p[j] == '*') {
            return fn(i - 1, j, s, p) || fn(i, j - 1, s, p);
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(fn(1, 0, "aa".toCharArray(), "a".toCharArray())); // false
    }

}


