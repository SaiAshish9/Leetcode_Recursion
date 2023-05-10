package com.sai.Leetcode_Recursion;

public class RegularExpressionMatching {

    static boolean fn(char[] s, char[] p, int i, int j) {
        if (i < 0 && j < 0) return true;
        if (j < 0 && i >= 0) return false;
        if (i < 0 && j >= 0)
        //if s is exhausted by p remains , it will only be true if all characters in p have *;
        {
            while (j >= 0) {
                if (p[j] == '*') j -= 2;
                else return false;
            }
            return true;
        }
        if (p[j] == s[i] || p[j] == '.') return fn(s, p, i - 1, j - 1);
        if (p[j] == '*') {
            if (p[j - 1] != s[i] && p[j - 1] != '.')
                return fn(s, p, i, j - 2);
            else {
                return fn(s, p, i, j - 2) || fn(s, p, i - 1, j);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "a*";
        int m = s1.length() - 1;
        int n = s2.length() - 1;
        System.out.println(fn(s1.toCharArray(), s2.toCharArray(), m, n)); // true
    }

}


