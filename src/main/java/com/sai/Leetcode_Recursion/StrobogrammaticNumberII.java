package com.sai.Leetcode_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumberII {

    public static List<String> findStrobogrammatic(int n) {
        return fn(n, n);
    }

    private static List<String> fn(int n, int k) {
        if (n == 0)
            return new ArrayList<>(Arrays.asList(""));
        if (n == 1)
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        List<String> ans = new ArrayList<>();
        for (final String inner : fn(n - 2, k)) {
            if (n < k)
                ans.add("0" + inner + "0");
            ans.add("1" + inner + "1");
            ans.add("6" + inner + "9");
            ans.add("8" + inner + "8");
            ans.add("9" + inner + "6");
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findStrobogrammatic(3));
//        [101, 609, 808, 906, 111, 619, 818, 916, 181, 689, 888, 986]
    }

}
