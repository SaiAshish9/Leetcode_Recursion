package com.sai.Leetcode_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumberIII {

    private static int ans = 0;

    private static final char[][] pairs = {
            {'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

    public static int strobogrammaticInRange(String low, String high) {
        for (int n = low.length(); n <= high.length(); ++n) {
            char[] c = new char[n];
            dfs(low, high, c, 0, n - 1);
        }

        return ans;
    }

    private static void dfs(final String low, final String high, char[] c, int l, int r) {
        if (l > r) {
            final String s = new String(c);
            if (s.length() == low.length() && s.compareTo(low) < 0)
                return;
            if (s.length() == high.length() && s.compareTo(high) > 0)
                return;
            ++ans;
            return;
        }

        for (char[] pair : pairs) {
            if (l == r && pair[0] != pair[1])
                continue;
            c[l] = pair[0];
            c[r] = pair[1];
            if (c.length > 1 && c[0] == '0')
                continue;
            dfs(low, high, c, l + 1, r - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(strobogrammaticInRange("50","100")); // 3
    }

}
