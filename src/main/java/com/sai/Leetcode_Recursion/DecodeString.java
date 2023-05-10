package com.sai.Leetcode_Recursion;

public class DecodeString {

    private static int index = 0;

    static String fn(String s) {
        String ans = "";
        int num = 0;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            if (p == '[') {
                str = fn(s.substring(i + 1));
                i = i + index;
                index = 0;
                while (num-- > 0)
                    ans += str;
                num = 0;

            } else if (Character.isDigit(p))
                num = num * 10 + (p - 48);
            else if (p != ']')
                ans += p;
            else {
                index = i + 1;
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fn("3[a]2[bc]")); // "aaabcbc"
    }

}
